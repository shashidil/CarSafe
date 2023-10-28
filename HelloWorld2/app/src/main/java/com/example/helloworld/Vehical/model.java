package com.example.helloworld.Vehical;

public class model {
    String name,vehNum,maufacture,model,fuelType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehNum() {
        return vehNum;
    }

    public void setVehNum(String vehNum) {
        this.vehNum = vehNum;
    }

    public String getMaufacture() {
        return maufacture;
    }

    public void setMaufacture(String maufacture) {
        this.maufacture = maufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public model(String name, String vehNum, String maufacture, String model, String fuelType) {
        this.name = name;
        this.vehNum = vehNum;
        this.maufacture = maufacture;
        this.model = model;
        this.fuelType = fuelType;
    }
}
