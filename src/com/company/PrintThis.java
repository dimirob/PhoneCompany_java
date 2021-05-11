package com.company;

public class PrintThis {
    public static void printMenu() {
        System.out.println("0: Exit from menu"); //Menu starts here
        System.out.println("1: Show available services");
        System.out.println("2: Create new contract");
        System.out.println("3: Show contracts for a specific service");
        System.out.println("4: Update the stats for a contract");
        System.out.println("5: Calculate monthly cost (data and non card contracts) and remaining budget for card contracts");
        System.out.println("6: Calculate remaining free sms and talking time for card contracts and non card contracts, and remaining data for data contracts"); //Menu ends here
    }
    public static void printServ(CollectionofServandConts colls){
        for (int i=0;i<colls.getServicesLength();i++) System.out.println(colls.getFromServices(i)+"  service no: "+i); //Print available contracts
    }
    public static void printCon(CollectionofServandConts colls){
        for (int i=0;i<colls.getContractLength();i++) System.out.println(colls.getFromContracts(i)+"  Contract id: "+colls.getConId(colls.getFromContracts(i))); //Print live contracts
    }
    public static void printContbyType(int serv,CollectionofServandConts colls){
        switch(serv){
            case 1:
                for (int i=0;i<colls.getContractLength();i++){
                    if (colls.getServiceType(Contracts.getContractService(colls.getFromContracts(i))).equals("Data Service")) System.out.println(colls.getFromContracts(i)); //print only Data contracts
                }
                break;
            case 2:
                for (int i=0;i<colls.getContractLength();i++){
                    if (colls.getServiceType(Contracts.getContractService(colls.getFromContracts(i))).equals("Card Contract")) System.out.println(colls.getFromContracts(i)); //print only Card contracts
                }
                break;
            case 3:
                for (int i=0;i<colls.getContractLength();i++){
                    if (colls.getServiceType(Contracts.getContractService(colls.getFromContracts(i))).equals("Non card contract")) System.out.println(colls.getFromContracts(i)); //print only nonCard contracts
                }
                break;
            default:
                System.out.println("Invalid number");

        }
    }
}
