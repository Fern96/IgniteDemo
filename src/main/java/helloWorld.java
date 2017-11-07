import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
public class helloWorld {
    public static void main(String[] args) throws IgniteException{
        try(
                Ignite ignite=Ignition.start(new IgniteConfiguration())
                ){
            IgniteCache<Integer,String> cache=ignite.getOrCreateCache("myCache");
            cache.put(1,"Hello");
            cache.put(2,"World");
            ignite.compute().broadcast(()->{
                String hello=cache.get(1);
                String world=cache.get(2);
                System.out.println(hello+" "+world);
                    }
            );
        }
    }
}
