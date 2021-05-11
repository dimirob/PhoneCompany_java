package com.company;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        CollectionofServandConts colls = new CollectionofServandConts(); //Creating a "database" object for Services and Contracts
        Scanner sc = new Scanner(System.in); // Creating an object for the user interface
        int choice; //variable for the user choice from the menu

        colls.addToCollection(new DataServices("On the go", (float) 20.50, 500, (float) 0.15)); //Initializing of services starts here
        colls.addToCollection(new DataServices("DataAth", (float) 24.50, 400, (float) 0.12));
        colls.addToCollection(new CardContract("TalkALot", (float) 14.40, 100, 100, (float) 1.05, (float) 0.1, (float) 20.0));
        colls.addToCollection(new CardContract("TalkMore", (float) 16.80, 110, 120, (float) 1.15, (float) 0.15, (float) 30.0));
        colls.addToCollection(new nonCardContract("UNI student", (float) 12.30, 300, 50, (float) 0.9, (float) 0.05));
        colls.addToCollection(new nonCardContract("Every Student", (float) 12.50, 250, 100, (float) 0.95, (float) 0.12)); //Initializing of services ends here


        colls.addToCollection(new Contracts(colls.getFromServices(0), "Dimitris Vosnakis", "8235799430", "2020-12-11", "Cash", 600, (float) 0.0)); //Initializing of contracts starts here
        colls.addToCollection(new Contracts(colls.getFromServices(0), "Serafeim Kapetanis", "235624626", "2020-12-11", "Card", 200, (float) 0.2));
        colls.addToCollection(new Contracts(colls.getFromServices(1), "Elias Kalantzis", "3285694851", "2020-12-11", "Card", 1245, (float) 0.1));
        colls.addToCollection(new Contracts(colls.getFromServices(1), "Giannis Apostolou", "98476291374", "2020-12-11", "Card", 321, (float) 0.12));
        colls.addToCollection(new Contracts(colls.getFromServices(2), "Petros Poulios", "5237589702", "2020-12-11", "Cash", 123, 20, 11, (float) 0.0));
        colls.addToCollection(new Contracts(colls.getFromServices(2), "Sarah Vosnaki", "9231749863", "2020-12-11", "Card", 11, 10, 23, (float) 0.11));
        colls.addToCollection(new Contracts(colls.getFromServices(3), "Giannis Agrogannis", "0487238964", "2020-12-11", "Cash", 112, 31, 1, (float) 0.04));
        colls.addToCollection(new Contracts(colls.getFromServices(3), "Giorgos Parasxos", "51862875", "2020-12-11", "Cash", 675, 321, 12, (float) 0.05));
        colls.addToCollection(new Contracts(colls.getFromServices(4), "Arhs Poulios", "23412352", "2020-12-11", "Card", 321, 13, 32, (float) 0.22));
        colls.addToCollection(new Contracts(colls.getFromServices(4), "Akhs Glykakis", "243516", "2020-12-11", "Cash", 31, 133, 321, (float) 0.12));
        colls.addToCollection(new Contracts(colls.getFromServices(5), "Natalia Gorlia", "42124154", "2020-12-11", "Cash", 1000, 122, 0, (float) 0.03));
        colls.addToCollection(new Contracts(colls.getFromServices(5), "Giorgos Basileas", "1235462346", "2020-12-11", "Cash", 23, 12, 123, (float) 0.0)); //Initializing of contracts ends here

        PrintThis.printMenu(); //Printing menu
        choice = sc.nextInt(); //User choice
        while (choice != 0) { //Exit the program with the number 0
            switch (choice) {
                case 1:
                    PrintThis.printServ(colls); //Function for printing the services
                    break;
                case 2:
                    System.out.println("Choose Service by typing service number: ");
                    PrintThis.printServ(colls);
                    int serv = sc.nextInt(); //service number
                    if (colls.getServiceType(colls.getFromServices(serv)).equals("Data Service")) //checking if the chosen service is a data service
                        Contracts.createDataCont(colls.getFromServices(serv), colls); //calling the function that creates a data contract object
                    else
                        Contracts.createTalkCon(colls.getFromServices(serv), colls); //calling the function that creates a non data contract object
                    break;
                case 3:
                    System.out.println("Print 1 for Data Service contracts");
                    System.out.println("Print 2 for Card Service contracts");
                    System.out.println("Print 3 for Non Card Service contracts");
                    serv = sc.nextInt(); //User choice for service type
                    PrintThis.printContbyType(serv, colls); //func for printing the contracts depending on the service type
                    break;
                case 4:
                    PrintThis.printCon(colls);
                    System.out.println("Choose contract id to update stats: ");
                    int con = sc.nextInt(); //id of the contract that stats are getting updated
                    Contracts.setStats(colls.getFromContracts(con)); //func for setting stats
                    System.out.println(colls.getFromContracts(con)); //print the contract
                    break;
                case 5:
                    PrintThis.printCon(colls);
                    System.out.println("Choose contract id to calculate cost: ");
                    con = sc.nextInt(); //id of the contract which its cost is going to be calculated
                    System.out.println(colls.getFromContracts(con)); //print the contract
                    System.out.println("Contract total cost: " + Contracts.getCost(colls, colls.getFromContracts(con), Contracts.getContractService(colls.getFromContracts(con)))); //Contracts.getCost returns the cost of any contract
                    break;
                case 6:
                    PrintThis.printCon(colls);
                    System.out.println("Choose contract id to calculate rest of free data, or SMS and Minutes to cell and base phones, or the remaining bugdet: ");
                    con=sc.nextInt(); //id of the contract which its free stuff is going to be calculated


                default:
                    System.out.println("Invalid choice, please choose a valid choice from the menu!"); //case of invalid input
            }
            PrintThis.printMenu();
            choice = sc.nextInt();
        }
    }
}
