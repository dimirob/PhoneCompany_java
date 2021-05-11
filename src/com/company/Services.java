package com.company;

public abstract class Services{ //abstract class for services in general
    protected String serviceName; //service name
    protected float serviceFee; //service fee
    public Services(String name,float fee){
        this.serviceFee=fee;
        this.serviceName=name;
    }
    float getServiceFee(){return this.serviceFee;}
    abstract float getServiceDiscount();
    abstract float getDataCost();
    abstract int getFreeData();
    abstract int getFreeMinutes();
    abstract int getFreeSMS();
    abstract float getMinutesCost();
    abstract float getSMSCost();
    abstract float getBudget();
}

