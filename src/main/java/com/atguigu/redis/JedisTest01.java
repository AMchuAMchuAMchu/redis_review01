package com.atguigu.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
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

    public static Jedis jedis = new Jedis("192.168.200.159", 6379);






    @Test
    public void test07(){

        System.out.println(jedis.ping());


        jedis.zadd("z1",100,"食锈末世录");
        jedis.zadd("z1",50,"SAO");
        jedis.zadd("z1",10,"影宅");

        Set<String> z1 = jedis.zrange("z1", 0, -1);

        z1.forEach(System.out::println);

    }


    @Test
    public void test06(){

        System.out.println(jedis.ping());

        HashMap<String, String> animeHash = new HashMap<>();

        animeHash.put("name01","哥布林杀手");
        animeHash.put("age","20");
        animeHash.put("name02","女神官");
        animeHash.put("name03","妖精弓手");

        jedis.hmset("h1",animeHash);

        List<String> hmget = jedis.hmget("h1", "name01", "name02", "name03", "age");

        hmget.forEach(System.out::println);




    }


    @Test
    public void test05(){

        System.out.println(jedis.ping());

        jedis.sadd("s1","k1艾米丽可");
        jedis.sadd("s1","k1艾米丽可");
        jedis.sadd("s1","k2柊筱娅");

        Set<String> s1 = jedis.smembers("s1");

        s1.forEach(System.out::println);


    }


    @Test
    public void test04() {

        System.out.println(jedis.ping());

        Long lpush = jedis.lpush("l1", "黑岩射手", "黑衣麻陶","小鸟游");

        List<String> l1 = jedis.lrange("l1", 0, -1);

        l1.forEach(System.out::println);

    }


    @Test
    public void test03() {

        Jedis jedis = new Jedis("192.168.200.159", 6379);

        System.out.println(jedis.ping());

        jedis.mset("k1", "v1艾米丽可", "k2", "v2凯特");

        List<String> mget = jedis.mget("k1", "k2");

        mget.forEach(System.out::println);


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

        System.out.println("expire::" + jedis.expire("k3", 10));

        System.out.println("01ttl::" + jedis.ttl("k3"));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("02ttl::" + jedis.ttl("k3"));


        System.out.println("exists::" + jedis.exists("k1"));

        System.out.println("get::" + jedis.get("k1"));


    }

    @Test
    public void test01() {

        Jedis jedis = new Jedis("192.168.200.159", 6379);

        System.out.println(" >> " + jedis.ping());

        jedis.close();

    }

}
