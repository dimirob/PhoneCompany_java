package com.company;
import java.util.Scanner;
public class Contracts  {
    private Services serviceName; //Service of contract
    private String clientName; //costumer name
    private String clientNumber; //phone number of client
    private String activationDate; //activation date of contract
    private String paymentMethod; //payment method
    private int minutestoBase; //minutes that the contract has talked to base phones
    private int minutesToCell; //minutes that the contract has talked to cell phones
    private int sms; //number of sms that the contract has used
    private int data; //data that ws used by the contract
    float discount; //the discount of each individual contract
    public Contracts(Services serviceName,String clientName,String clientNumber,String activationDate,String paymentMethod,int minutesToCell,int minutestoBase,int sms,float discount){// constructor for talking contracts
        this.serviceName=serviceName;
        this.clientName=clientName;
        this.clientNumber=clientNumber;
        this.activationDate=activationDate;
        this.paymentMethod=paymentMethod;
        this.minutesToCell=minutesToCell;
        this.minutestoBase=minutestoBase;
        this.sms=sms;
        this.discount=discount;
    }
    public Contracts(Services serviceName,String clientName,String clientNumber,String activationDate,String paymentMethod,int data,float discount){// constructor for data contracts
        this.serviceName=serviceName;
        this.clientName=clientName;
        this.clientNumber=clientNumber;
        this.activationDate=activationDate;
        this.paymentMethod=paymentMethod;
        this.data=data;
        this.discount=discount;
    }
    public static Services getContractService(Contracts cont){
        return cont.serviceName;
    }// getter for the service of the contract
    public String toString(){//toString that has an output depending on the contract service type
        if (this.serviceName.getType().equals("Data Service")) return "Name: "+this.clientName+" client number: "+this.clientNumber+" activation date "+this.activationDate+" payment method: "+this.paymentMethod+" data: "+this.data+" special discount: "+this.discount;
        else return "Name: "+this.clientName+" client number: "+this.clientNumber+" activation date "+this.activationDate+" payment method: "+this.paymentMethod+" minutes to cellphones: "+this.minutesToCell+" minutes to base phones: "+this.minutestoBase+" special discount: "+this.discount;
    }
    public static void setStats(Contracts con){//setter for the stats that depends on teh contracts service type
        Scanner sc=new Scanner(System.in);
        if (con.serviceName.getType().equals("Data Service")){
            System.out.print("Enter data usage");
            con.data=sc.nextInt();
        }
        else{
            System.out.println("Enter minutes to cell");
            con.minutesToCell=sc.nextInt();
            System.out.println("Enter minutes to base phones");
            con.minutestoBase=sc.nextInt();
            System.out.println("Enter SMS");
            con.sms=sc.nextInt();
        }
    }
    public static float getCost(CollectionofServandConts coll,Contracts con,Services serv){//function to get the cost of a contract, parameters:(CollectionofServandConts object,the contract and the service of the contract)
        switch(coll.getServiceType(serv)){
            case "Data Service"://Data contract case:
                float fee=serv.getServiceFee();
                int freedata=serv.getFreeData();
                if (con.data<=freedata) return fee;
                else{
                    float servDiscount=serv.getServiceDiscount();
                    float dataCost=serv.getDataCost();
                    return (float)fee+(con.data-freedata)*dataCost-(servDiscount+con.discount)*((con.data-freedata)*dataCost+fee);
                }
            case "Non card contract"://non Card contract case
                fee=serv.getServiceFee();
                int freeMins=serv.getFreeMinutes();
                int freeSMS=serv.getFreeSMS();
                if(con.minutesToCell+con.minutestoBase<=freeMins & con.sms<=freeSMS) return fee;
                else{
                    float servDiscount=serv.getServiceDiscount();
                    float minCost=serv.getMinutesCost();
                    float smsCost=serv.getSMSCost();
                    float sumMinCost=con.minutesToCell+con.minutestoBase<=freeMins?0:(con.minutesToCell+con.minutesToCell-freeMins)*minCost;
                    float sumSMSCost=con.sms<=freeSMS?0:(con.sms-freeSMS)*smsCost;
                    return fee+sumMinCost+sumSMSCost-(fee+sumMinCost+sumSMSCost)*(con.discount+servDiscount);
                }
            case "Card Contract"://card contract case
                fee=serv.getServiceFee();
                freeMins=serv.getFreeMinutes();
                freeSMS=serv.getFreeSMS();
                float budget=serv.getBudget();
                float servDiscount=serv.getServiceDiscount();
                float minCost=serv.getMinutesCost();
                float smsCost=serv.getSMSCost();
                float sumMinCost=con.minutesToCell+con.minutestoBase<=freeMins?0:(con.minutesToCell+con.minutesToCell-freeMins)*minCost;
                float sumSMSCost=con.sms<=freeSMS?0:(con.sms-freeSMS)*smsCost;
                float totalCost=fee+sumMinCost+sumSMSCost-(fee+sumMinCost+sumSMSCost)*(con.discount+servDiscount);
                if(totalCost<=budget) return budget-totalCost;
                else return budget;
            default:
                return 0;
        }
    }
    static void createDataCont(Services serv,CollectionofServandConts colls){
        Scanner sc=new Scanner(System.in);
        System.out.println("Client name: "); //Collecting data starts here
        String name=sc.next();
        System.out.println("Client number: ");
        String num=sc.next();
        System.out.println("Activation Date (In yyyy-mm-dd format): ");
        String date=sc.next();
        System.out.println("Payment method: ");
        String payMethod=sc.next();
        System.out.println("Data usage: ");
        int data=sc.nextInt();
        System.out.println("Special discount (if there is no discount enter 0): ");
        float discount=sc.nextFloat(); //Collecting data ends here
        colls.addToCollection(new Contracts(serv, name, num, date, payMethod, data, discount)); //new object added to the ArrayList

    }
    static void createTalkCon(Services serv,CollectionofServandConts colls){
        Scanner sc=new Scanner(System.in);
        System.out.println("Client name: "); //Collecting data starts here
        String name=sc.next();
        System.out.println("Client number: ");
        String num=sc.next();
        System.out.println("Activation Date (In yyyy-mm-dd format): ");
        String date=sc.next();
        System.out.println("Payment method: ");
        String payMethod=sc.next();
        System.out.println("Minutes to cell phones: ");
        int minutesToCell=sc.nextInt();
        System.out.println("Minutes to base phones: ");
        int minutestoBase=sc.nextInt();
        System.out.println("SMS: ");
        int sms=sc.nextInt();
        System.out.println("Special discount (if there is no discount enter 0): "); //Collecting data ends here
        float discount=sc.nextFloat();
        colls.addToCollection(new Contracts(serv, name, num, date, payMethod, minutesToCell,minutestoBase,sms, discount)); //new object added to the ArrayList
    }
}
