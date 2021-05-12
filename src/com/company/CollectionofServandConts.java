package com.company;
import java.util.ArrayList;
public class CollectionofServandConts {
    private ArrayList<Services> serviceArray; //ArrayList for Services
    private ArrayList<Contracts> contractArray; //Arraylist for the live contracts
    public CollectionofServandConts(){
        this.serviceArray=new ArrayList<Services>();
        this.contractArray=new ArrayList<Contracts>();
    }
    public void addToCollection(Services serv){
        this.serviceArray.add(serv);
    }//func for adding a Service to the arrayList
    public void addToCollection(Contracts cont){
        this.contractArray.add(cont);
    }//func for adding a Contract to the arrayList
    public Services getFromServices(int i){
        return this.serviceArray.get(i);
    }//Getter for services
    public Contracts getFromContracts(int i){
        return this.contractArray.get(i);
    }//Getter for contracts
    public int getServicesLength(){
        return this.serviceArray.size();
    }//Getter for the length of the Services arraylist
    public int getContractLength(){
        return this.contractArray.size();
    }//Getter for the length of the Contracts arraylist
    public int getConId(Contracts con){
        return this.contractArray.indexOf(con);
    }//Getter for the Contract id
}
