package com.example.dinewave.services;

import com.example.dinewave.models.actors.Restaurant;
import com.example.dinewave.models.actors.User;
import com.example.dinewave.models.system.Item;
import com.example.dinewave.models.system.Order;
import com.example.dinewave.utils.Address;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentService extends AbstractVerticle
{
    private final ConcurrentHashMap<Long, User> users;
    private final ConcurrentHashMap<Long, Restaurant> restaurants;

    public PaymentService(ConcurrentHashMap<Long, User> users, ConcurrentHashMap<Long, Restaurant> restaurants) {
        this.users = users;
        this.restaurants = restaurants;
    }

    @Override
    public void start(Promise<Void> startPromise)
    {

        System.out.println("Payment Verticle Loaded " + Thread.currentThread().getName());

        var eventBus = vertx.eventBus();

        eventBus.<JsonObject>localConsumer(Address.paymentAddress, handler -> {

            System.out.println("Payment received from order service " + handler.body());

            System.out.println("User Order IN Payment Service "+handler.body());

            JsonObject jsonObject = handler.body();


            System.out.println("JsonObject "+jsonObject);

            var userId = jsonObject.getLong("userId");

            System.out.println("Userid : "+userId);

            var user = users.get(userId);

            var restaurantId = jsonObject.getLong("restaurantId");

            var restaurant = restaurants.get(restaurantId);

            System.out.println("Item details are "+jsonObject.getJsonArray("items"));

            long bill = jsonObject.getJsonArray("items").stream()
                .mapToLong(item-> ((JsonObject) item).getLong("price")).sum();

            System.out.println("Bill is "+bill);

            System.out.println("User information "+user);

            if (user.getBalance() >= bill)
            {
                user.setBalance(user.getBalance() - bill);

                System.out.println("Payment initiated at " + LocalDateTime.now());

                try
                {
                    Thread.sleep(4000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Exception in Payment Service sleep.");
                    handler.reply("Payment processing failed.");
                    return;
                }

                System.out.println("Payment complete at " + LocalDateTime.now());

                handler.reply("Done");
            }

            else
            {
                System.out.println("Insufficient balance for user: " + user.getUsername());

                handler.reply("Insufficient balance.");
            }
        });
    }


    private long calculateTotalPrice(Order order)
    {

        long totalPrice = 0;

        for (Item item : order.items())
        {
            totalPrice += item.getPrice();
        }

        long tax = (long) (totalPrice * 0.05);

        long deliveryCharge = 50;

        return totalPrice + tax + deliveryCharge;
    }
}
