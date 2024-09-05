package com.example.dinewave.models.system;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record Order (long userId,long restaurantId,List<Item> items,String time) implements Serializable
{
  public JsonObject toJson()
  {
    JsonArray itemsArray = new JsonArray();

    items.forEach(item -> itemsArray.add(item));

    JsonObject object =  new JsonObject()
      .put("userid ",userId)
      .put("restaurantid",restaurantId)
        .put("items",itemsArray)
      .put("time",time);

      System.out.println("JsonObject Type "+object.getClass());
      return object;
  }
}
