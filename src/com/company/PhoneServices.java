package com.company;

public class PhoneServices extends Services { //yphresia kinhths thlefwnias
    protected int freeMinutes; //dwrean lepta
    protected int freeSMS; //dwrean sms
    protected float minutesCost; //kostos leptwn meta apo dwrean
    protected float smsCost; //kostos sms meta apo dwrean

    public PhoneServices(String name, float fee, int mins, int sms, float minCost, float smsCost) {
        super(name, fee);
        this.freeMinutes = mins;
        this.freeSMS = sms;
        this.minutesCost = minCost;
        this.smsCost = smsCost;
    }

    public int getFreeData() {
        return 0;
    }//implementation methodou (den yparxei free data se yphresias kinhths thlefwnias)

    public float getDataCost() {
        return 0;
    }//implementation methodou (den yparxei data cost se yphresias kinhths thlefwnias)

    float getServiceDiscount() {
        return 0;
    }//geter gia ekptwsh yphresias

    public int getFreeMinutes() {
        return this.freeMinutes;
    }//geter gia dwrean lepta yphresias

    public int getFreeSMS() {
        return this.freeSMS;
    }//geter gia dwrean sms

    public float getMinutesCost() {
        return this.minutesCost;
    }//geter gia kostos ana lepto

    public float getSMSCost() {
        return this.smsCost;
    }//getter gia kostos ana sms

    public float getBudget() {
        return 0;
    }//geter gia diathesimo ypoloipo (yphresies kartosymbolaiou)
}
