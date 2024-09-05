package com.example.dinewave.services;

import com.example.dinewave.dao.OrderDAO;
import com.example.dinewave.models.system.Order;
import com.example.dinewave.utils.Address;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class OrderService extends AbstractVerticle
{
  //Order Service call Restaurant Service to prepare order
  //Order Service call Delivery service to pass information about delivery
  static final String paymentAddress = "com.example.dinewave.payment";
  static final String deliveryAddress = "com.example.dinewave.delivery";
  static final String restaurantAddress = "com.example.dinewave.restaurant";

  @Override
  public void start(Promise<Void> startPromise) throws Exception
  {

    //listen for incoming orders
    var eventBus = vertx.eventBus();



    eventBus.<JsonObject>localConsumer(Address.orderAddress, handler->{

      System.out.println("I recieved Order From "+handler.address());
      System.out.println("Order Details "+handler.body());

      var order = handler.body();
      System.out.println("Received in order service "+order);
      //First Make the payment

      eventBus.request(paymentAddress,order,reply->{
        if(reply.succeeded())
        {
          eventBus.send(restaurantAddress,order);
          eventBus.send(deliveryAddress,order);
        }
        else
        {
          System.out.println("payment failed!");
        }
      });


      //notify the deliveryman for order information
      //eventBus.request()

    });

  }
}
