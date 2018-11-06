package redis;


import redis.clients.jedis.Jedis;

/**
 * Created by deepak.jayaprakash on 02/11/18.
 */
public class RedisClient {

    private static Jedis client;

    private static RedisClient instance;

    public static RedisClient getInstance() {
        if (instance == null) {
            initializeClient();
            instance = new RedisClient();
        }
        return instance;
    }

    private static void initializeClient() {
        client = new Jedis("localhost");
    }

    public Jedis getRedissonClient() {
        return client;
    }

    public static void main(String[] args) {
        initializeClient();
    }

}
