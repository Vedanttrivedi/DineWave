package com.example.dinewave;

import com.example.dinewave.connectors.Client;
import com.example.dinewave.dao.Database;
import com.example.dinewave.services.DeliveryService;
import com.example.dinewave.services.OrderService;
import com.example.dinewave.services.PaymentService;
import com.example.dinewave.services.RestaurantService;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.ThreadingModel;
import io.vertx.core.Vertx;

public class Main
{

  public static void main(String[] args)
  {
      var users = Database.getUsers();
      var restaurants = Database.getRestaurants();

      var vertx = Vertx.vertx();

      vertx.deployVerticle(new OrderService(),new DeploymentOptions());

      vertx.deployVerticle(new PaymentService(users,restaurants),
          new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER));

      vertx.deployVerticle(new RestaurantService(restaurants));

      vertx.deployVerticle(new DeliveryService(restaurants));

      vertx.deployVerticle(new Client(users,restaurants));

  }

}
