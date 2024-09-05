package com.example.dinewave;

import com.example.dinewave.connectors.Client;
import com.example.dinewave.services.DeliveryService;
import com.example.dinewave.services.OrderService;
import com.example.dinewave.services.PaymentService;
import com.example.dinewave.services.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.vertx.core.Vertx;

public class Main
{

  public static void main(String[] args)
  {

      ObjectMapper objectMapper = new ObjectMapper();

      objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

      System.out.println("Main Vertx called");

      var vertx = Vertx.vertx();

      vertx.deployVerticle(new OrderService());

      vertx.deployVerticle(new PaymentService());

      vertx.deployVerticle(new RestaurantService());

      vertx.deployVerticle(new DeliveryService());

      vertx.deployVerticle(new Client());

  }

}
