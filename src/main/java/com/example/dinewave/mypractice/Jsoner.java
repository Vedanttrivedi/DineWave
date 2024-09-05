package com.example.dinewave.mypractice;

import io.vertx.core.json.JsonArray;

public class Jsoner
{
    public static void main(String[] args) {
        JsonArray array = new JsonArray();

        array.add(new Test(10));
        array.add(new Test(2));
        System.out.println(array);
    }
}
class Test{
    int a;
    Test(int a)
    {
        this.a=a;
    }
}
