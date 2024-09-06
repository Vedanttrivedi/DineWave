package com.example.dinewave.services;

import com.example.dinewave.models.actors.Restaurant;
import com.example.dinewave.utils.Address;
import com.example.dinewave.utils.OrderStatus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import java.util.concurrent.ConcurrentHashMap;

public class DeliveryService extends AbstractVerticle
{
    ConcurrentHashMap<Long, Restaurant> restaurants;

    public DeliveryService(ConcurrentHashMap<Long,Restaurant> restaurants)
    {
        this.restaurants =restaurants;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {

        var eventBus = vertx.eventBus();

        eventBus.<JsonObject>localConsumer(Address.deliveryService,handler->
        {

            var order = handler.body();

            vertx.executeBlocking(promise->{

                try
                {
                    System.out.println("Order is in delivery stage ");

                    Thread.sleep(5000);

                    System.out.println("Order Delivered");

                }
                catch (Exception ie)
                {
                    System.out.println("Error in Delivery Service "+ie);

                    promise.fail("Delay in delivery");
                }

                promise.complete("Delivered");

            },future->{

                if(future.succeeded())
                {
                    order.put("orderStatus",OrderStatus.delivered);

                    vertx.eventBus().send(Address.clientService,order);
                }
                else
                    System.out.println("Deliveryman Ate the food OOPS!!");
            });

        });

    }
}
