package redis;


import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by deepak.jayaprakash on 02/11/18.
 */
public class RedisUtils {

    static Jedis client = RedisClient.getInstance().getRedissonClient();

    public static String getValue(String key) {
        return client.get(key);
    }

    public static Set<String> getAllKeys() {
        Set<String> keys = client.keys("*");
        return keys;
    }

    public static String setValue(String key, String value) {
        return client.set(key, value);
    }

    public void ping() {
        System.out.println(client.ping());
    }

    public static void main(String[] args) {
        System.out.println(getValue("asdf"));
    }
}
