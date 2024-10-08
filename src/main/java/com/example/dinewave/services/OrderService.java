package com.example.dinewave.services;
import com.example.dinewave.utils.Address;
import com.example.dinewave.utils.OrderStatus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class OrderService extends AbstractVerticle
{

  @Override
  public void start(Promise<Void> startPromise) throws Exception
  {

    //listen for incoming orders
    var eventBus = vertx.eventBus();

    eventBus.<JsonObject>localConsumer(Address.orderAddress, handler->{

      System.out.println("I recieved Order in "+handler.address());

      System.out.println("Order Details "+handler.body());

      var order = handler.body();
      //First Make the payment

      eventBus.request(Address.paymentAddress,order,reply->{

      if(reply.succeeded())
        {
            var replyInString = reply.result().body();

            System.out.println("Reply in string order "+replyInString);

            if(replyInString.equals("Done"))
            {
                //update the order status to ordered
                order.put("orderStatus", OrderStatus.ordered);

                System.out.println("Sending Order Information to DeliveryAddress and RestaurantAddress");

                eventBus.publish(Address.restaurantAndDeliveryAddress,order);
            }
            else
            {
                System.out.println("Payment Error.May be insufficient Balance");
            }
        }
      else
        {
          System.out.println("payment failed! Cannot Proceed Order!");
        }
      });
    });

  }
}
