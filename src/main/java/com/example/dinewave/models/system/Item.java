package com.example.dinewave.models.system;

import io.vertx.core.json.JsonObject;

final public class Item
{
  private String name;
  private String description;
  private long price;

  public Item(String name, String description, long price)

  {
    this.name = name;
    this.description = description;
    this.price = price;
  }


  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }
}
