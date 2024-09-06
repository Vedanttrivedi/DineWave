package com.example.dinewave.mypractice;

import io.vertx.core.json.JsonArray;

import java.util.Random;

public class Jsoner
{
    public static void main(String[] args) {

        Random random = new Random();

        System.out.println("Random Number "+random.nextInt(10,20));
    }
}
class Test{
    int a;
    Test(int a)
    {
        this.a=a;
    }
}
