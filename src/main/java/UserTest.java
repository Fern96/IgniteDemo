import java.util.List;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
public class UserTest {

    public static void main(String[] args) {

        Ignite ignite = Ignition.start();
        //创建部门信息缓存
        CacheConfiguration<Integer, Department> depCfg = new CacheConfiguration<Integer, Department>();
        depCfg.setName("DEP");
        depCfg.setCacheMode(CacheMode.PARTITIONED);
        depCfg.setIndexedTypes(Integer.class, Department.class);
        IgniteCache<Integer, Department> depCache = ignite.getOrCreateCache(depCfg);
        depCache.put(1, new Department(4, "内科", "主任医师"));
        depCache.put(2, new Department(2, "骨科", "主治医师"));
        depCache.put(3, new Department(5, "皮肤科", "专家"));
        depCache.put(4, new Department(1, "神经科", "副主任医师"));
        depCache.put(5, new Department(7, "门诊", "护士"));
        depCache.put(6, new Department(3, "外科", "专家"));
        //创建用户信息缓存
        CacheConfiguration<Integer, User> userCfg = new CacheConfiguration<Integer, User>();
        userCfg.setName("USER");
        userCfg.setCacheMode(CacheMode.PARTITIONED);
        userCfg.setIndexedTypes(Integer.class, User.class);
        IgniteCache<Integer, User> userCache = ignite.getOrCreateCache(userCfg);
        userCache.put(1, new User(101, 2, "a", 23, 0, "17123490987"));
        userCache.put(2, new User(222, 3, "b", 45, 1, "13268948987"));
        userCache.put(3, new User(123, 6, "c", 66, 1, "15176585987"));
        userCache.put(4, new User(456, 7, "d", 18, 0, "14720896787"));
        userCache.put(5, new User(589, 4, "e", 33, 1, "13521236687"));
        userCache.put(6, new User(600, 1, "f", 56, 0, "15225475687"));
        //部门查询
        SqlFieldsQuery sql = new SqlFieldsQuery(
                "select concat(dep.depId, '----', dep.depName, '----',dep.role) as depInfo"
                        + " "
                        + "from Department as dep"
                        + "");
        QueryCursor<List<?>> cursor = depCache.query(sql);
        System.out.println("部门信息：");
        for (List<?> row : cursor) {
            System.out.println(row.get(0));
        }
        System.out.println("-------------------------------------------------------------");

        //关联查询
        SqlFieldsQuery sql1 = new SqlFieldsQuery(
                "select concat(dep.depId, '----', dep.depName,'----',dep.role) as depInfo"
                        + ", concat(u.name, '----', u.age,'----',u.gender,'----',u.phoneNumber) as userInfo "
                        + "from Department as dep,USER.User as u "
                        + "where dep.depId = u.depId");

        QueryCursor<List<?>> cursor1 = depCache.query(sql1);
        for (List<?> row : cursor1) {
            System.out.println("部门信息：" + row.get(0) + "，用户信息：" + row.get(1));
        }
        System.out.println("-------------------------------------------------------------");
        //用户查询
        SqlFieldsQuery sql2 = new SqlFieldsQuery(
                "select concat(u.userId, '----',u.name, '----', u.age,'----',u.gender,'----',u.phoneNumber) as userInfo"
                        + " "
                        + "from User as u"
                        + "");
        QueryCursor<List<?>> cursor2 = userCache.query(sql2);
        System.out.println("用户信息：");
        for (List<?> row : cursor2) {
            System.out.println( row.get(0));
        }
        System.out.println("-------------------------------------------------------------");
        //插入数据
            //merge(条目列表)
        userCache.query(new SqlFieldsQuery("merge into User(_key,userId,name,age,gender,phoneNumber)"+"values(1,2,'a',23,0,'17123490987'),(9,45,'www',56,1,'12345678909')"));
        userCache.query(new SqlFieldsQuery("merge into User(_key,name,age)"+"values(1,'a',23)"));
        QueryCursor<List<?>> cursor3 = userCache.query(sql2);
        System.out.println("merge操作：");
        for (List<?> row : cursor3) {
            System.out.println( row.get(0));
        }
           //insert(不能添加缓存中已经存在的)
        userCache.query(new SqlFieldsQuery("insert into User(_key,name,age)"+"values(32,'Mary',44)"));
        QueryCursor<List<?>> cursor4 = userCache.query(sql2);
        System.out.println("insert操作：");
        for (List<?> row : cursor4) {
            System.out.println( row.get(0));
        }
       //修改数据
           //update(可以更新缓存中的值的每个字段，但无法更新缓存键极其字段)
        userCache.query(new SqlFieldsQuery("update User set name=?"+"where _key<=?").setArgs("Jack",2L));
        QueryCursor<List<?>> cursor5 = userCache.query(sql2);
        System.out.println("update操作：");
        for (List<?> row : cursor5) {
            System.out.println( row.get(0));
        }
        //删除数据
        userCache.query(new SqlFieldsQuery("delete from User "+"where _key>=?").setArgs(5L));
        QueryCursor<List<?>> cursor6 = userCache.query(sql2);
        System.out.println("delete操作：");
        for (List<?> row : cursor6) {
            System.out.println( row.get(0));
        }
    }
}
