
import org.apache.ignite.cache.query.annotations.QuerySqlField;
public class User {

    @QuerySqlField
    private int userId;
    @QuerySqlField
    private int depId;
    @QuerySqlField
    private String name;
    @QuerySqlField
    private int age;
    @QuerySqlField
    private int gender;
    @QuerySqlField
    private String phoneNumber;

    public User(int userId, int depId,String name, int age,int  gender, String phoneNumber) {

        this.userId = userId;
        this.depId=depId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ",depId=" + depId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
