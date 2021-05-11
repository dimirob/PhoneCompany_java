package com.company;

public class nonCardContract extends PhoneServices { //non card Service
    private final float discount = (float) 0.2; //Standard discount for each contract

    public nonCardContract(String name, float fee, int mins, int sms, float minCost, float smsCost) {
        super(name, fee, mins, sms, minCost, smsCost,"Non card contract");
    }

    public String toString() {
        return "Service type: non Card Contract  Service name: " + this.serviceName + "  Service Fee: " + this.serviceFee + "  Free minutes: " + this.freeMinutes + "  Minutes cost: " + this.minutesCost + "  Free SMS: " + this.freeSMS + "  SMS Cost: " + this.smsCost;
    }

    float getServiceDiscount() {
        return this.discount;
    }//getter for the discount of the service
}
