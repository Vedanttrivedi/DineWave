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

    items.forEach(item->itemsArray.add(item.toJson()));

    var object =  new JsonObject()
      .put("userId",userId)
      .put("restaurantId",restaurantId)
       .put("items",itemsArray)
      .put("time",time);

      return object;
  }
}
