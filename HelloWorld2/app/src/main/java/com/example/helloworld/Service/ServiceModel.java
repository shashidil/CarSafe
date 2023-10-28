package com.example.helloworld.Service;

public class ServiceModel {
    String Servicecenter,mileage, rbvalue,discription,date;
    public ServiceModel(String Servicecenter,String mileage,String rbvalue,String discription ,String date) {
        this.Servicecenter=Servicecenter;
        this.mileage=mileage;
        this.rbvalue=rbvalue;
        this.discription= discription;
        this.date=date;

    }

    public String getServicecenter() {
        return Servicecenter;
    }

    public void setServicecenter(String servicecenter) {
        Servicecenter = servicecenter;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getRbvalue() {
        return rbvalue;
    }

    public void setRbvalue(String rbvalue) {
        this.rbvalue = rbvalue;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
