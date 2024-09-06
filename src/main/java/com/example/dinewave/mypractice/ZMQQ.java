package com.example.dinewave.mypractice;

import io.vertx.core.buffer.Buffer;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ZMQQ
{
    public static void main(String[] args) {
        ZContext ctx = new ZContext();
        ZMQ.Socket socket = ctx.createSocket(SocketType.REQ);
        socket.connect("tcp://10.20.40.150:5555");
        String request = "Hello";
        System.out.println("Req :" + request);
        socket.send(request.getBytes(ZMQ.CHARSET), 0);
        Buffer response = Buffer.buffer(socket.recv());
        System.out.println("response :" + response);

    }
}
