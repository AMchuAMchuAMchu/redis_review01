package com.atguigu.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: redis_review01
 * @BelongsPackage: com.atguigu.redis
 * @Version: 1.0
 * @CreateTime: 2022-09-04 21:19:41
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class JedisTest01 {


    @Test
    public void test03(){

        Jedis jedis = new Jedis("192.168.200.159", 6379);

        System.out.println(jedis.ping());


    }

    @Test
    public void test02() {

        Jedis jedis = new Jedis("192.168.200.159", 6379);

        System.out.println(" > " + jedis.ping());

        jedis.set("k1", "v1");

        jedis.set("k2", "v2");

        jedis.set("k3", "v3");

        jedis.set("k3", "v3");

        Set<String> keys = jedis.keys("*");

        keys.forEach(System.out::println);

        System.out.println("expire::"+jedis.expire("k3", 10));

        System.out.println("01ttl::"+jedis.ttl("k3"));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("02ttl::"+jedis.ttl("k3"));


        System.out.println("exists::"+jedis.exists("k1"));

        System.out.println("get::"+jedis.get("k1"));



    }

    @Test
    public void test01() {

        Jedis jedis = new Jedis("192.168.200.159", 6379);

        System.out.println(" >> " + jedis.ping());

        jedis.close();

    }

}
