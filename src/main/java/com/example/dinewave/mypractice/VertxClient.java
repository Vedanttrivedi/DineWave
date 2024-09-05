package com.example.dinewave.mypractice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class VertxClient extends AbstractVerticle
{
  @Override
  public void start(Promise<Void> startPromise) throws Exception
  {
    for (int i = 1; i <=20; i++)
    {
      NetClient client = vertx.createNetClient();

      client.connect(4444, "localhost", res -> {

        if (res.succeeded())
        {
          System.out.println("Connected to server!");

          NetSocket socket = res.result();


          socket.handler(buffer -> {
            System.out.println("Received from server: " + buffer.toString());
          });

          socket.closeHandler(v -> {
            System.out.println("Disconnected from server");
          });

          socket.exceptionHandler(e -> {
            System.err.println("Socket exception: " + e.getMessage());
          });

        }
        else
        {
          System.err.println("Failed to connect to server: " + res.cause().getMessage());
        }
      });
    }
  }
}

