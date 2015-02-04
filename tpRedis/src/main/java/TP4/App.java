package TP4;

import redis.clients.jedis.Jedis;

/**
 * Baptiste Quéré
 * Yoann Le Taillanter
 * M1 MIAGE
 * TP SIR
 */
public class App {
    public static void main( String[] args ) {

        Jedis jedis = new Jedis("localhost");

        //Exemple 1
        /*
        jedis.set("foo","bar");
        String value = jedis.get("foo");
        System.err.println(value);
        */

        //Exemple 2
        /* 
        System.out.println(jedis.get("counter"));
        jedis.incr("counter");
        System.out.println(jedis.get("counter"));
        */

        // Exemple 3
        /*
        String cachekey = "cachekey";
        // adding a new key
        jedis.set(cachekey,"cached value");
        // setting the TTL in seconds
        jedis.expire(cachekey, 15);
        // Getting the remaining ttl
        System.out.println("TTL:" + jedis.ttl(cachekey));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TTL:" + jedis.ttl(cachekey));
        // Getting the cache value
        System.out.println("Cached Value:" + jedis.get(cachekey));

        // Wait for the TTL finishs
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // trying to get the expired key
        System.out.println("Expired Key:" + jedis.get(cachekey));
        */
        
        //Exemple4
        String cacheKey = "languages";

        // Adding a set as value
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "C#");
        jedis.sadd(cacheKey, "Python");// SADD

        // Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey));

        // Adding new values
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "Ruby");

        // Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis.smembers(cacheKey));


    }
}
