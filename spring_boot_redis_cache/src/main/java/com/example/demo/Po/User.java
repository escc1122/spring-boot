package com.example.demo.Po;

import java.io.Serializable;

public class User implements Serializable{
    public User(int id, String name, int age, double money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    private int id;
    private String name;
    private int age;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}