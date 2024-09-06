package com.example.dinewave.connectors;

import com.example.dinewave.dao.Database; // Import the database class
import com.example.dinewave.models.actors.User;
import com.example.dinewave.models.actors.Restaurant;
import com.example.dinewave.models.system.Item;
import com.example.dinewave.models.system.Location;
import com.example.dinewave.models.system.Order;
import com.example.dinewave.utils.Address;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Client extends AbstractVerticle
{
    ConcurrentHashMap<Long,Restaurant> restaurants;
    ConcurrentHashMap<Long,User> users;


    public Client(ConcurrentHashMap<Long,User> users,ConcurrentHashMap<Long,Restaurant> restaurants)
    {
        this.users = users;
        this.restaurants =restaurants;
    }

    @Override
    public void start()
    {
        vertx.setPeriodic(20000, handler -> {

            var randomRestaurant = pickRandomRestaurant(restaurants);

            List<Item> randomItems = pickRandomItems(randomRestaurant);

            Order order = new Order(
                generateRandomNumber(1, users.size()),
                generateRandomNumber(1, restaurants.size()),
                randomItems,
                LocalDateTime.now().toString()
            );

            vertx.eventBus().send(Address.orderAddress, order.toJson());

            System.out.println("Order Sent From Client: " + order.toJson());

        });

        vertx.eventBus().<JsonObject>localConsumer(Address.clientService,handler->{

            System.out.println("Client Order Recived At "+ LocalDateTime.now().toString());

            System.out.println("Client Order "+handler.body());

        });
    }

    private User pickRandomUser(ConcurrentHashMap<Long, User> users)
    {
        List<Long> userIds = new ArrayList<>(users.keySet());
        Long randomUserId = userIds.get(generateRandomNumber(1, userIds.size() - 1));
        return users.get(randomUserId);
    }

    private Restaurant pickRandomRestaurant(ConcurrentHashMap<Long, Restaurant> restaurants)
    {
        List<Long> restaurantIds = new ArrayList<>(restaurants.keySet());
        Long randomRestaurantId = restaurantIds.get(generateRandomNumber(1, restaurantIds.size() - 1));
        return restaurants.get(randomRestaurantId);
    }

    private List<Item> pickRandomItems(Restaurant restaurant)
    {
        List<Item> availableItems = restaurant.getItems();
        int numberOfItems = generateRandomNumber(1, availableItems.size()); // Random number of items to pick

        List<Item> selectedItems = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++)
        {
            selectedItems.add(availableItems.get(generateRandomNumber(0, availableItems.size() - 1)));
        }

        return selectedItems;
    }

    public static int generateRandomNumber(int m, int n)
    {
        Random random = new Random();
        return random.nextInt(m,n);
    }
}
