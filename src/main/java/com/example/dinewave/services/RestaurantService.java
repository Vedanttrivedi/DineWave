package com.example.dinewave.services;

import com.example.dinewave.models.actors.Restaurant;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import java.util.concurrent.ConcurrentHashMap;

public class RestaurantService extends AbstractVerticle
{
    ConcurrentHashMap<Long,Restaurant> restaurants;

    public RestaurantService(ConcurrentHashMap<Long,Restaurant> restaurants)
    {
        this.restaurants =restaurants;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

    }
}
