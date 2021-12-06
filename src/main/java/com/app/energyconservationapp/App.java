package com.app.energyconservationapp;



import Objects.*;
import databaseTest.dbTest;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class App {
    private ArrayList<Student> students;
    private ArrayList<Landlord> landlords;
    private ArrayList<Building> buildings;
    private ArrayList<Ownership> ownerships;
    private ArrayList<Contract> contracts;
    private ArrayList<Room> rooms;
    private ArrayList<Lease> leases;
    private ArrayList<Appliance> appliances;
    private ArrayList<BelongsTo> belongsToArrayList;
    private ArrayList<Contains> containsArrayList;

    public App() {
        this.students = new ArrayList<>();
        this.landlords = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.ownerships = new ArrayList<>();
        this.contracts = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.leases = new ArrayList<>();
        this.appliances = new ArrayList<>();
        this.belongsToArrayList = new ArrayList<>();
        this.containsArrayList = new ArrayList<>();

    }

   public boolean checkStudent(String username, String password){
        return true;
   }



    //We moeten een exception throwen als meerdere vakjes gekozen worden bij de methodes of een manier vinden om te programmeren dat er maar 1 vakje gekozen kan worden!!




    public static void main(String[] args) {

        dbTest dbStream = new dbTest();
        App app = new App();
        app.students = dbStream.databaseReadStudent();
        app.landlords = dbStream.databaseReadLandlord();
        app.rooms = dbStream.databaseReadRoom();
        app.leases = dbStream.databaseReadLease();
        app.buildings = dbStream.databaseReadBuilding();
        app.appliances = dbStream.databaseReadAppliance();
        app.belongsToArrayList = dbStream.databaseReadBelongsTo();
        app.containsArrayList = dbStream.databaseReadContains();
        app.contracts = dbStream.databaseReadContract();
        app.ownerships = dbStream.databaseReadOwnership();




        System.out.println(app.students);
        System.out.println(app.landlords);
        System.out.println(app.rooms);
        System.out.println(app.leases);
        System.out.println(app.buildings);
        System.out.println(app.appliances);
        System.out.println(app.belongsToArrayList);
        System.out.println(app.containsArrayList);
        System.out.println(app.contracts);
        System.out.println(app.ownerships);

    }


}



