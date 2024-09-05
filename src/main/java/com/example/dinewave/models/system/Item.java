package com.example.dinewave.models.system;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Item implements Serializable
{
    @JsonProperty
  private String name;
    @JsonProperty
  private String description;
  @JsonProperty
    private long price;

  public Item()
  {

  }
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
