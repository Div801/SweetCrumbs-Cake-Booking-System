
package com.sweetcrumbs.model;

public class Cake {

    private int id;
    private String name;
    private String flavor;
    private double price;
    private String size;

    public Cake(int id, String name, String flavor,
                double price, String size) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
        this.price = price;
        this.size = size;
    }

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

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
