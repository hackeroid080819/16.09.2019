package com.example.itaykan.fbfb3;


public class User {
    public User()
    {

    }
    private String name;
    private int age;

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int value)
    {
        this.age = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String value)
    {
        this.name = value;
    }
}

