package com.example.helloworld.Refuel;

public class RefuleModel {
    String date,cost,location,qty;
    public RefuleModel(String date, String cost, String location, String qty) {
        this.date=date;
        this.cost=cost;
        this.location=location;
        this.qty=qty;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
