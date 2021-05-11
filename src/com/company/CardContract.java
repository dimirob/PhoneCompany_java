package com.company;

public class CardContract extends PhoneServices { //card contract service
    float budget; //arxiko mhniaio upoloipo gia ta kartosumvolaia
    private final float discount = (float) 0.25; //Ypothetoume ekptwsh pou dinetai sthn ekfwnhsh

    public CardContract(String name, float fee, int mins, int sms, float minCost, float smsCost, float startingBudget) {
        super(name, fee, mins, sms, minCost, smsCost);
        this.budget = startingBudget;
    }

    public String toString() {
        return "Service type: Card Contract  Service name: " + this.serviceName + "  Service Fee: " + this.serviceFee + "  Free minutes: " + this.freeMinutes + "  Minutes cost: " + this.minutesCost + "  Free SMS: " + this.freeSMS + "  SMS Cost: " + this.smsCost + "  Starting budget: " + this.budget;
    }

    public float getServiceDiscount() {
        return this.discount;
    }//geter gia ekptwsh yphresias

    @Override
    public float getBudget() {
        return this.budget;
    }//getter gia diathesimo ypoloipo
}
