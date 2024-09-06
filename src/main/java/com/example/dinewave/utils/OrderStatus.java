package com.example.dinewave.utils;

import java.io.Serializable;

public enum OrderStatus implements Serializable
{
    pending,
    ordered,
    preparing,
    dispatched,
    delivered;
}
