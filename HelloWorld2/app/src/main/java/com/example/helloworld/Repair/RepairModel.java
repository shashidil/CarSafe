package com.example.helloworld.Repair;

public class RepairModel {
    private String Date,repair,discription,cost;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public RepairModel(String repair,String discription, String cost,String Date) {

        this.repair=repair;
       this.discription= discription;
       this.cost=cost;
       this.Date= Date;
    }
}
