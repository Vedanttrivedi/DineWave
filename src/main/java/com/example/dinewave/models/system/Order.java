package com.example.dinewave.models.system;

import java.time.LocalDateTime;
import java.util.List;

public class Order
{
    long userId;
    List<Item> items;
    LocalDateTime orderTime;

}
