package com.example.darshan.miniproject;

public class Mobiles {
    private String Model;
    private String Price;
    private String RAM;
    private String Screen_size;
    private String Storage;

    public Mobiles() {
    }

    public Mobiles(String model, String price, String RAM, String screen_size, String storage) {
        Model = model;
        Price = price;
        this.RAM = RAM;
        Screen_size = screen_size;
        Storage = storage;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getScreen_size() {
        return Screen_size;
    }

    public void setScreen_size(String screen_size) {
        Screen_size = screen_size;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

}
