package com.example.dinewave.models.actors;

import com.example.dinewave.models.system.Item;

import java.util.List;

class Restaurant
{
    final long restaurantId;
    final String location;
    String name,description;
    List<Item> items;

  public Restaurant(long restaurantId, String name, String description, String location)
  {
    this.restaurantId = restaurantId;
    this.name = name;
    this.description = description;
    this.location = location;
  }

  public void addItem(Item item)
  {

  }

  public void updateItemPrice(String itemName,long price)
  {

  }

  public void removeItem(String item)
  {

  }

  public long getRestaurantId()
  {
    return restaurantId;
  }


  public String getName()
  {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
