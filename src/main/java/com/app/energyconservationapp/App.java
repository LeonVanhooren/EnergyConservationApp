package com.app.energyconservationapp;



import Objects.*;
import databaseTest.dbTest;

import java.util.ArrayList;


public class App {
    private ArrayList<Student> students;
    private ArrayList<Landlord> landlords;
    private ArrayList<Building> buildings;
    private ArrayList<Ownership> ownerships;
    private ArrayList<Contract> contracts;
    private ArrayList<Room> rooms;
    private ArrayList<Lease> leases;
    private ArrayList<StudentPassword> studentPasswords;
    private ArrayList<LandlordPassword> landlordPasswords;

    public App() {
        this.students = new ArrayList<>();
        this.landlords = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.ownerships = new ArrayList<>();
        this.contracts = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.leases = new ArrayList<>();
        this.studentPasswords = new ArrayList<>();
        this.landlordPasswords = new ArrayList<>();


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

        System.out.println(app.students);
        System.out.println(app.landlords);
        System.out.println(app.rooms);
        System.out.println(app.leases);

    }


}



