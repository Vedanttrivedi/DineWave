package com.example.dinewave.models.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.io.Serializable;

public class Item implements Serializable
{

  private String name;

  private String description;

    private Long price;


    public JsonObject toJson()
    {
        return new JsonObject()
            .put("name",name)
            .put("description",description)
            .put("price",price);
    }
  public Item()
  {

  }
  public Item(String name, String description, Long price)

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

  public void setPrice(Long price) {
    this.price = price;
  }
}
