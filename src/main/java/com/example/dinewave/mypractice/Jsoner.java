package com.example.dinewave.mypractice;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;

import java.util.Random;

public class Jsoner
{
    public static void main(String[] args) {
        var vertx = Vertx.vertx();

        vertx.setPeriodic(3000,handler->{
            System.out.println("Entered here bro "+Thread.currentThread().getName());

            vertx.executeBlocking(promise->
            {
                try
                {

                    Thread.sleep(15000);
                    System.out.println("Executed "+Thread.currentThread().getName());
                }
                catch (InterruptedException e)
                {
                    System.out.println("Thread sleep exception");
                }
            });

        });
    }
}
class Test{
    int a;
    Test(int a)
    {
        this.a=a;
    }
}
