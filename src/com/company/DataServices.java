package com.company;

public class DataServices extends Services { //yphresia kinhtoy internet
    private final float discount = (float) 0.3; //Ypothetoume ekptwsh pou dinetai sthn ekfwnhsh
    private int freeData; //dwrean dedomena
    private float dataCost; //kostos dedomenwn meta apo dwrean

    public DataServices(String name, float fee, int freeData, float dataCost) {
        super(name, fee);
        this.dataCost = dataCost;
        this.freeData = freeData;
    }

    public String toString() {
        return "Service type: Data service  Service name: " + this.serviceName + "  Service Fee: " + this.serviceFee + "  Free data: " + this.freeData + "  Data cost: " + this.dataCost;
    }

    public int getFreeData() {
        return this.freeData;
    }//geter gia free data

    public float getDataCost() {
        return this.dataCost;
    }//geter gia data cost

    public float getServiceDiscount() {
        return this.discount;
    } //geter gia thn ekptwsh ths uphresias

    public int getFreeMinutes() {
        return 0;
    }// arxh implemantation methodwn pou den efarmozontai gia data services

    public int getFreeSMS() {
        return 0;
    }

    public float getMinutesCost() {
        return 0;
    }

    public float getSMSCost() {
        return 0;
    }// telos implementation methodwn pou den efarmozontai gia data services

    public float getBudget() {
        return 0;
    }//methodos gia to ypoloipo budget gia kartosymbolaia
}
