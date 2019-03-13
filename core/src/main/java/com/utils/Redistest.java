package com.utils;

import redis.clients.jedis.Jedis;

public class Redistest {

    public static  void  main(String[] args){

        Jedis jedis = new Jedis("localhost");
        jedis.set("greeting","helloredis");
        System.out.println(jedis.get("greeting"));
    }




}
