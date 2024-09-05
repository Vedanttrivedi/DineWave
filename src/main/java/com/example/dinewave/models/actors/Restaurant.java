package com.example.dinewave.models.actors;

import com.example.dinewave.models.system.Item;
import com.example.dinewave.models.system.Location;

import java.util.List;

public class Restaurant
{
    String name,description;
    List<Item> items;
    Location location;


  public Location getLocation()
  {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Restaurant(String name, String description,Location location)
  {
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


  public String getName()
  {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
