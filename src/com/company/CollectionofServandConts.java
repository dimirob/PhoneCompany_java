package com.company;
import java.util.ArrayList;
public class CollectionofServandConts {
    private ArrayList<Services> serviceArray; //ArrayList gia tis diathesimes yphresies
    private ArrayList<Contracts> contractArray; //ArrayList gia ta energa sumvolaia
    public CollectionofServandConts(){
        this.serviceArray=new ArrayList<Services>();
        this.contractArray=new ArrayList<Contracts>();
    }
    public void addToCollection(Services serv){
        this.serviceArray.add(serv);
    }
    public void addToCollection(Contracts cont){
        this.contractArray.add(cont);
    }
    public Services getFromServices(int i){
        return this.serviceArray.get(i);
    }
    public Contracts getFromContracts(int i){
        return this.contractArray.get(i);
    }
    public int getServicesLength(){
        return this.serviceArray.size();
    }
    public int getContractLength(){
        return this.contractArray.size();
    }
    public String getServiceType(Services serv){
        return serv.getType();
    }
    public int getConId(Contracts con){
        return this.contractArray.indexOf(con);
    }
    public int getServId(Services serv){
        return this.serviceArray.indexOf(serv);
    }
}
