package DBClients;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by deepak.jayaprakash on 15/11/18.
 */
public class GuavaCache {

    @Test
    public void sizeBasedEviction() {
        LoadingCache<Integer, String> idNameCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer integer) throws Exception {
                        return "value" + String.valueOf(integer);
                    }
                });
        try {
            System.out.println(idNameCache.get(1));
            System.out.println(idNameCache.get(2));
            System.out.println(idNameCache.get(3));
            Assert.assertEquals(idNameCache.size(), 3);
            System.out.println(idNameCache.get(4));
            Assert.assertEquals(idNameCache.size(), 3);
            Assert.assertNull(idNameCache.getIfPresent(1));
        } catch (ExecutionException e) {
            System.out.println("cache miss for " + e);
        }
    }

    @Test
    public void timeBasedEviction() {
        LoadingCache<Integer, String> idNameCache = CacheBuilder.newBuilder()
                .expireAfterAccess(1, TimeUnit.SECONDS) // expire after read
                .expireAfterWrite(1, TimeUnit.SECONDS) // expire after write
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer integer) throws Exception {
                        return "value" + String.valueOf(integer);
                    }
                });
        try {
            System.out.println(idNameCache.get(1));
            System.out.println(idNameCache.get(2));
            System.out.println(idNameCache.get(3));
            System.out.println(idNameCache.get(4));
            Assert.assertEquals(idNameCache.size(), 4);
            Thread.sleep(3500);
            Assert.assertNull(idNameCache.getIfPresent(1));
            Assert.assertNull(idNameCache.getIfPresent(2));
            Assert.assertNull(idNameCache.getIfPresent(3));
            Assert.assertNull(idNameCache.getIfPresent(4));

            Assert.assertEquals(idNameCache.size(), 0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}