package com.example.dinewave.connectors;

import com.example.dinewave.models.system.Item;
import com.example.dinewave.models.system.Order;
import com.example.dinewave.utils.Address;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


//This Class Will Generate Some Random Orders every 3 seconds
/*
Class Should be able to generate order for random user and random items
from random restaurants.

Once the Order is generated send this to order service.


 */

public class Client extends AbstractVerticle
{

  @Override
  public void start()
  {
    //Send the orders to order service
    //Sample Stimulation
    //Allow Only 1 order from 1 place only

    Order order = new Order(
      1,
      1,
      new ArrayList<Item>(
        Arrays.asList(
          new Item("Pulav", "Spicy", 200),
          new Item("Papad", "Regular", 40)
        )),
      LocalDateTime.now().toString()
    );

    //Pick random user (between userid 0 to n)
    //Pick random restaurant (between restaurant id (0 to n)
    //Generate Random order every 1 second
      JsonObject jsoner = new JsonObject();

      vertx.setPeriodic(3000,handler->{

      vertx.eventBus().send(Address.orderAddress,order.toJson());

      System.out.println("Order Sent From Client");

    });

  }
}
