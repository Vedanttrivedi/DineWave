package com.example.dinewave.models.actors;

abstract class User
{
    String username,email;
    transient String password;
    long userId;
    String location;

  public User()
  {

  }

    public User(String username,String password,String email,String location)
    {
      this.username = username;
      this.password = password;
      this.email = email;
      this.location = location;
    }


  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
