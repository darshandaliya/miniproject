package com.example.darshan.miniproject;

public class Mobile {

    private String model;
    private float price;
    private float ram;
    private float screen_size;
    private float storage;

    public Mobile()
    {
        
    }

    public Mobile(String model, float price, float ram, float screen_size, float storage) {
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.screen_size = screen_size;
        this.storage = storage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRam() {
        return ram;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public float getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(float screen_size) {
        this.screen_size = screen_size;
    }

    public float getStorage() {
        return storage;
    }

    public void setStorage(float storage) {
        this.storage = storage;
    }
}