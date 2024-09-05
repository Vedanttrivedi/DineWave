package com.example.dinewave.models.system;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.List;

public record Order (long userId,long restaurantId,List<Item> items,String time)
{
  public JsonObject toJson()
  {
    JsonArray itemsArray = new JsonArray();

    items.forEach(itemsArray::add);

    return new JsonObject()
      .put("userid ",userId)
      .put("restaurantid",restaurantId)
      .put("items",itemsArray)
      .put("time",time);
  }
}
