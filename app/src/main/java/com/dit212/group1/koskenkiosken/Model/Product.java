package com.dit212.group1.koskenkiosken.Model;

public class Product {

    private String name;
    private int pid;
    private int price;
    private int stock; //Should this really be in Product class?

    public Product(){
        this.name = "Nocoo";
        this.pid = 0;
        this.price = 10;
        this.stock = 10;
    }

    public Product(String name, int pid, int price, int stock){
        this.name = name;
        this.pid = pid;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
