package com.example.darshan.miniproject;

public class Mobile {

    private String Model ;
    private float Price;
    private float RAM;
    private float Screen_Size;
    private float Storage;

    public Mobile(){}


    public Mobile(String Model, float Price, float RAM, float Screen_Size, float Storage) {
        this.Model = Model;
        this.Price = Price;
        this.RAM = RAM;
        this.Screen_Size = Screen_Size;
        this.Storage = Storage;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getRAM() {
        return RAM;
    }

    public void setRAM(float RAM) {
        this.RAM = RAM;
    }

    public float getScreen_Size() {
        return Screen_Size;
    }

    public void setScreen_Size(float screen_Size) {
        Screen_Size = screen_Size;
    }

    public float getStorage() {
        return Storage;
    }

    public void setStorage(float storage) {
        Storage = storage;
    }
}

