package com.example.dinewave.dao;

import com.example.dinewave.models.actors.Customer;
import com.example.dinewave.models.actors.Restaurant;
import com.example.dinewave.models.actors.User;
import com.example.dinewave.models.system.Location;

import java.util.LinkedHashMap;
import java.util.Locale;

public class RestaurantDAO
{
  LinkedHashMap<Long, Restaurant> restaurants;
  public RestaurantDAO()
  {
    //load prebuild restaurants in the list
    restaurants = new LinkedHashMap<>();

    restaurants.put(1L,
      new Restaurant("Dakshinyan","Best SouthIndianFood",
        new Location("Science city","ahmedabad","gujarat",12345)));


    restaurants.put(2L,
      new Restaurant("Dominoze","Pizza",
        new Location("Gota","ahmedabad","gujarat",234567)));

    restaurants.put(3L,
      new Restaurant("AMC Chinese","Chinese Food",
        new Location("Sachin","surat","gujarat",34567)));

  }
}
