package com.example.dinewave.models.actors;

abstract public class User
{
    String username,email;
    transient String password;
    String location;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    long balance;

    public User(String username,String password,String email,String location,long balance)
    {
      this.username = username;
      this.password = password;
      this.email = email;
      this.location = location;
      this.balance=balance;
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

    @Override
    public String toString() {
        return "User{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", location='" + location + '\'' +
            ", balance=" + balance +
            '}';
    }
}
