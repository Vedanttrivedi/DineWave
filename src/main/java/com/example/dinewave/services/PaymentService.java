package com.example.dinewave.services;

import com.example.dinewave.models.system.Order;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.DeliveryOptions;

public class PaymentService extends AbstractVerticle
{
  @Override
  public void start(Promise<Void> startPromise) throws Exception
  {
      var eventBus = vertx.eventBus();

      eventBus.<Order>localConsumer("com.example.dinewave.payment",handler->{

        System.out.println("Received Order Payment ");

        handler.reply("Done");

      });
  }
}
