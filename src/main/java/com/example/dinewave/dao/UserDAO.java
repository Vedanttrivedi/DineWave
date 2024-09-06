package com.example.dinewave.dao;

import com.example.dinewave.models.actors.Admin;
import com.example.dinewave.models.actors.Customer;
import com.example.dinewave.models.actors.User;

import java.util.LinkedHashMap;

public class UserDAO
{
  LinkedHashMap<Long, User> users;
  public UserDAO()
  {
    //load prebuild users in the list
    users = new LinkedHashMap<>();

    users.put(1L,new Customer("vedant","123456","ved@mail.com","ahmedabad",20000));
    users.put(2L,new Customer("Darshan","123456","darshan@mail.com","mumbai",10000));
    users.put(3L,new Customer("Aakash","123456","aakash@mail.com","surat",5000));

  }
}
