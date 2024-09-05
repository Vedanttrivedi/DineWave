package com.example.dinewave;

import com.example.dinewave.models.system.Item;
import com.example.dinewave.models.system.Order;
import com.example.dinewave.services.OrderService;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main
{
  final static int port=4444;
  public static void main(String[] args)
  {
    //Sample Stimulation
    //Allow Only 1 order from 1 place only
    Order order = new Order(
      12345,
      1200,
      new ArrayList<Item>(
        Arrays.asList(
          new Item("Pulav","Spicy",200),
          new Item("Papad","Regular",40)
          )),
      LocalDateTime.now().toString()
    );


    HashMap<Integer,Integer> map = new HashMap<>();
    var vertx = Vertx.vertx(new VertxOptions());
    vertx.deployVerticle(new OrderService());
    JsonObject object = new JsonObject();
    
    vertx.setPeriodic(4000,event -> {

      vertx.eventBus().send("com.example.dinewave.order",order.toJson());
      System.out.println("Data Sent to order!");

    });

  }

}
