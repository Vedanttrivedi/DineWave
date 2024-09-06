package com.example.dinewave.services;

import com.example.dinewave.models.actors.Restaurant;
import com.example.dinewave.utils.Address;
import com.example.dinewave.utils.OrderStatus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

import java.util.concurrent.ConcurrentHashMap;

public class RestaurantService extends AbstractVerticle
{
    ConcurrentHashMap<Long,Restaurant> restaurants;

    public RestaurantService(ConcurrentHashMap<Long,Restaurant> restaurants)
    {
        this.restaurants =restaurants;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {
        var eventBus = vertx.eventBus();

        eventBus.<JsonObject>localConsumer(Address.restaurantAndDeliveryAddress, handler->{

            var order = handler.body();

            vertx.executeBlocking(promise->{

                try
                {
                    System.out.println("Order is in preparing stage ");

                    order.put("orderStatus",OrderStatus.preparing);

                    Thread.sleep(5000);

                }
                catch (InterruptedException ie)
                {
                    System.out.println("Error in Restaurant Service "+ie);

                    promise.fail("Failed To Prepare Order");
                }
                promise.complete("Order Ready");

            },false,future->{

                if(future.succeeded())
                {
                    order.put("orderStatus", OrderStatus.dispatched);

                    System.out.println("Order Is Now Dispatched ");

                    vertx.eventBus().send(Address.deliveryService,order);
                }

            });
        });
    }
}
