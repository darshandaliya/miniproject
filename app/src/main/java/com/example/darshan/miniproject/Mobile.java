package com.example.darshan.miniproject;

public class Mobile {

    private String Model ;
    private String Price;
    private String RAM;
    private String Screen_Size;
    private String Storage;


    public Mobile(String Model, String Price, String RAM, String Screen_Size, String Storage) {
        this.Model = Model;
        this.Price = Price;
        this.RAM = RAM;
        this.Screen_Size = Screen_Size;
        this.Storage = Storage;
    }


    public String getName() {
        return Model;
    }

    public String getPrice() {
        return Price;
    }

    public String getRAM() {
        return RAM;
    }

    public String getScreen_Size() {
        return Screen_Size;
    }

    public String getStorage() {
        return Storage;
    }


    public void setModel(String model) {
        this.Model = model;
    }

    public void setPrice(String price) {
        this.Price = price;
    }

    public void setRAM(String ram) {
        this.RAM = ram;
    }

    public void setScreen_Size(String screen_size) {
        this.Screen_Size = screen_size;
    }

    public void setStorage(String storage) {
        this.Storage = storage;
    }

}

