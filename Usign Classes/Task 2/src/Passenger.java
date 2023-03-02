public class Passenger extends CruiseShip_Task_2 {
    private String passengerName;
    private String passengerSurname;
    private double passengerExpenses;

//Constructor
    public Passenger(String firstName, String surName, double price) {
        this.passengerName = firstName;
        this.passengerSurname = surName;
        this.passengerExpenses = price;
    }

//Accessors for above constructors
    public String getPassengerName() {
        return passengerName;
    }
    public String getPassengerSurname() {
        return passengerSurname;
    }
    public double getPassengerExpenses() {
        return passengerExpenses;
    }



    @Override
    public String toString() {
        return passengerName;
    }
}
