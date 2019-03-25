package com.example.darshan.miniproject.model;

public class Mobile {

    private String Model ;
    private int Price;
    private int RAM;
    private double Screen_Size;
    private int Storage;

    public Mobile() {
    }

    public Mobile(String Model, int Price, int RAM, double Screen_Size, int Storage) {
        this.Model = Model;
        this.Price = Price;
        this.RAM = RAM;
        this.Screen_Size = Screen_Size;
        this.Storage = Storage;
    }


    public String getName() {
        return Model;
    }

    public int getPrice() {
        return Price;
    }

    public int getRAM() {
        return RAM;
    }

    public double getScreen_Size() {
        return Screen_Size;
    }

    public int getStorage() {
        return Storage;
    }


    public void setModel(String model) {
        this.Model = model;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public void setRAM(int ram) {
        this.RAM = ram;
    }

    public void setScreen_Size(double screen_size) {
        this.Screen_Size = screen_size;
    }

    public void setStorage(int storage) {
        this.Storage = storage;
    }

}

