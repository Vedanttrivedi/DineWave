package com.example.dinewave.connectors;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetSocket;

public class ClientHandler
{
  Vertx vertx;
  NetSocket socket;
  public ClientHandler(NetSocket socket)
  {
    this.vertx = vertx;
    this.socket = socket;
  }
  public void clientHandler()
  {
    System.out.println("Client Connected From "+socket.localAddress());

    System.out.println("Client Details ");

    System.out.println(socket.localAddress().hostAddress()+"\t"+socket.localAddress().port());
    socket.write("You are connected to thread from server "+Thread.currentThread().getName());

    socket.handler(buffer->
    {
      System.out.println("Data From Client "+buffer.toString());

    });

    socket.closeHandler(handler->{
      System.out.println("Client Disconnected From "+socket.localAddress().hostAddress());
    });

    socket.exceptionHandler(handler->{
      System.out.println("Exception in socket At "+handler.getLocalizedMessage());
    });

  }
}

