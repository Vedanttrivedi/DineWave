package com.example.dinewave.dao;

import com.example.dinewave.models.actors.Customer;
import com.example.dinewave.models.actors.Restaurant;
import com.example.dinewave.models.actors.User;
import com.example.dinewave.models.system.Item;
import com.example.dinewave.models.system.Location;
import com.example.dinewave.models.system.Order;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Database
{

    private static final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, Restaurant> restaurants = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, Order> orders = new ConcurrentHashMap<>();

    static {
        // Preload random users
        users.put(1L, new Customer("Vedant", "123456", "ved@mail.com", "Ahmedabad", 20000));
        users.put(2L, new Customer("Darshan", "abcdef", "darshan@mail.com", "Mumbai", 15000));
        users.put(3L, new Customer("Aakash", "qwerty", "aakash@mail.com", "Surat", 10000));
        users.put(4L, new Customer("Soniya", "password", "nidhi@mail.com", "Jaipur", 25000));
        users.put(5L, new Customer("Priya", "welcome", "priya@mail.com", "Delhi", 30000));

        // Preload random restaurants with items
        restaurants.put(1L, new Restaurant("Spice Garden", "Indian Cuisine", new Location("MG Road", "Bangalore", "Karnataka", 123456L)));
        restaurants.put(2L, new Restaurant("Pasta Palace", "Italian Cuisine", new Location("Marine Drive", "Mumbai", "Maharashtra", 654321L)));
        restaurants.put(3L, new Restaurant("Sushi World", "Japanese Cuisine", new Location("Connaught Place", "Delhi", "Delhi", 789012L)));
        restaurants.put(4L, new Restaurant("The BBQ Hub", "Barbecue Specials", new Location("Park Street", "Kolkata", "West Bengal", 345678L)));
        restaurants.put(5L, new Restaurant("Baker's Delight", "Bakery and Desserts", new Location("MG Road", "Ahmedabad", "Gujarat", 876543L)));

        // Adding items to each restaurant
        restaurants.get(1L).setItems(
            List.of(
            new Item("Butter Pavbhaji", "Rich and spicy pavbhaji", 300L),
            new Item("Paneer Tikka", "Grilled cottage cheese", 250L),
            new Item("Paneer Butter Masala", "Grilled Subgy", 350L)
        ));

        restaurants.get(2L).setItems(List.of(
            new Item("Margherita Pizza", "Classic Italian pizza with tomatoes and mozzarella", 500L),
            new Item("Spaghetti Carbonara", "Spaghetti with creamy sauce and bacon", 450L)
        ));

        restaurants.get(3L).setItems(List.of(
            new Item("Sushi Platter", "Assorted sushi selection", 800L),
            new Item("Ramen", "Traditional Japanese noodle soup", 400L)
        ));

        restaurants.get(4L).setItems(List.of(
            new Item("Grilled Sandwich", "Barbecue-style grilled sandwich", 600L),
            new Item("Smoked Ribs", "Tender smoked pork ribs", 700L)
        ));

        restaurants.get(5L).setItems(List.of(
            new Item("Chocolate Cake", "Rich chocolate layered cake", 350L),
            new Item("Croissant", "Buttery French croissant", 150L)
        ));
    }

    public static ConcurrentHashMap<Long, User> getUsers() {
        return users;
    }

    public static ConcurrentHashMap<Long, Restaurant> getRestaurants() {
        return restaurants;
    }
    public static ConcurrentHashMap<Long, Order> getOrders() {
        return orders;
    }

}


