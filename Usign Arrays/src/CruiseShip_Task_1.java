import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class CruiseShip_Task_1 {

//Creating two variable which belongs to the class
    private static boolean Ship = true;
    private static boolean Menu = true;

//Creating a main method with exception
    public static void main(String[] args) throws IOException {

//Creating a Scanner and an array called cruiseShip
        Scanner userInput = new Scanner(System.in);
        Cabin[] cruiseShip = new Cabin[12];
        cruiseShip[0] = new Cabin();
        cruiseShip[1] = new Cabin();
        cruiseShip[2] = new Cabin();
        cruiseShip[3] = new Cabin();
        cruiseShip[4] = new Cabin();
        cruiseShip[5] = new Cabin();
        cruiseShip[6] = new Cabin();
        cruiseShip[7] = new Cabin();
        cruiseShip[8] = new Cabin();
        cruiseShip[9] = new Cabin();
        cruiseShip[10] = new Cabin();
        cruiseShip[11] = new Cabin();
        int cabinNumber = 0;

//Call configure method to run the array
        configure(cruiseShip);

//Use while True to run the program as a loop until it becomes false
        while (Ship) {
            while (Menu) {
//Display the options which need to select
                System.out.println("Cruise Ship Boarding\n");
                System.out.println("Please select the options below\n");
                System.out.println("A: Add a customer to cabin");
                System.out.println("V: View All cabins");
                System.out.println("E: Display Empty cabins");
                System.out.println("D: Delete customer from cabin");
                System.out.println("F: Find cabin from customer name");
                System.out.println("S: Store program data into file");
                System.out.println("L: Load program data from file");
                System.out.println("O: View passengers Ordered alphabetically by name\n");
                System.out.println("Select an Option: ");

//Creating a variable called Choice
                String Choice = userInput.next();
//Make it uppercase, either user input lowercase or uppercase input program works for both of types
                Choice = Choice.toUpperCase();

//Use switch case loop to call the relevant method when call
                switch (Choice) {
                    case "A":
                        AddACustomer(cruiseShip, cabinNumber);
                        break;
                    case "V":
                        ViewAllCabins(cruiseShip);
                        break;
                    case "E":
                        EmptyCabins(cruiseShip);
                        break;
                    case "D":
                        DeleteCustomer(cruiseShip, cabinNumber);
                        break;
                    case "F":
                        FIndCustomer(cruiseShip);
                        break;
                    case "S":
                        StoreDataIntoFile(cruiseShip);
                        break;
                    case "L":
                        LoadDataFromFile(cruiseShip);
                        break;
                    case "O":
                        SortPassengers(cruiseShip);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
//Each time after each method done showing a message to stop the program or continue it
                System.out.println("\n");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                if (userInput.nextInt() == 1) {
                    Menu = true;
                } else {
                    Menu = false;
                }
            }
//Message which display to terminate the program
            Menu = true;
            System.out.println("\n");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            if (userInput.nextInt() == 1) {
                Ship = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }
    }
//Configure method which writes blank in every index in array
    private static void configure(Cabin[] cruiseShip) {
        for (int y = 0; y < cruiseShip.length; y++)
            cruiseShip[y].setID("----");
    }

//AddCustomer method which ask from the user to input the customer name in each cabin
    private static void AddACustomer(Cabin[] cruiseShip, int cabinNumber) {
        String cabinID;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter room number (1-12): ");
        cabinNumber = userInput.nextInt() - 1;
        System.out.println("Enter name for cabin " + (cabinNumber + 1) + " : ");
        cabinID = userInput.next();
        cruiseShip[cabinNumber].setID(cabinID);
    }

//ViewAllCabins method to show all the cabins, the cabins' area occupied or not
    private static void ViewAllCabins(Cabin[] cruiseShip) {
        for (int y = 0; y < cruiseShip.length; y++)
            System.out.println("Cabin " + (y + 1) + " occupied by " + cruiseShip[y].getID());
    }

//EmptyCabins method which shows all the empty cabins
    private static void EmptyCabins(Cabin[] cruiseShip) {
        for (int y = 0; y < cruiseShip.length; y++) {
            if (cruiseShip[y].getID().equals("----")) {
                System.out.println("Cabin " + (y + 1) + " is empty");
            }
        }
        System.out.println("All Cabins are Full");
    }

//DeleteCustomer method which remove data from each index from the array as the user wanted
    private static void DeleteCustomer(Cabin[] cruiseShip, int cabinNumber) {
        Scanner delete = new Scanner(System.in);
        System.out.println("Enter cabin number to delete(1-12):");
        cabinNumber = delete.nextInt() - 1;
        cruiseShip[cabinNumber].setID("----");
        System.out.println("Data has been Deleted..! ");
    }

//FindCustomer method to find the customer room by searching the name
    private static void FIndCustomer(Cabin[] cruiseShip) {
        String cabinID;
        Scanner find = new Scanner(System.in);
        System.out.println("Enter name to Search : ");
        cabinID = find.next();
        int y;
        boolean Search = false;
        for (y = 0; y < cruiseShip.length; y++) {
            if (cabinID.equals(cruiseShip[y].getID())) {
                System.out.println("The Cabin that matches is Cabin number: " + (y + 1));
                Search = true;
            }
        }
        if (Search == false) {
            System.out.println("There are no Cabins Booked with that name\n");
        }
    }

//StoreDataIntoFile method to store the current data runs in the program into a text file called StoreDataFile.txt
    private static void StoreDataIntoFile(Cabin[] cruiseShip) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("../SD 2 - Coursework - Task 1/StoreDataFile.txt"))) {
            int y;
            for (y = 0; y < cruiseShip.length; y++)
                out.println(cruiseShip[y].getID());
        }
        System.out.println("All Store Data have been Saved...");
    }

//LoadDataFromFile method to load data from a text file called StoreDataFile.txt to run the program
    private static void LoadDataFromFile(Cabin[] cruiseShip) throws IOException {
        FileInputStream FileStream = new FileInputStream("../SD 2 - Coursework - Task 1/StoreDataFile.txt");
        BufferedReader Reader = new BufferedReader(new InputStreamReader(FileStream));
        for (int j = 0; j < cruiseShip.length; j++) {
            cruiseShip[j].setID(Reader.readLine());
        }
        System.out.println("All Store Data have been Loaded...");
    }

//SortPassengers method to sort the passengers order by alphabetical order
    private static void SortPassengers(Cabin[] cruiseShip) {
        String[] Passengers = new String[cruiseShip.length];
        for (int j = 0; j < cruiseShip.length; j++) {
            Passengers[j] = cruiseShip[j].getID();
        }

        int n = cruiseShip.length;
        System.out.println(" ");
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // to compare one string with other strings
                if (Passengers[i].compareTo(Passengers[j]) > 0) {
                    // swapping
                    temp = Passengers[i];
                    Passengers[i] = Passengers[j];
                    Passengers[j] = temp;
                }
            }
        }
        // print output array
        for (int i = 0; i < n; i++) {
            System.out.println(Passengers[i]);
        }
    }



    //Creating a public class called Cabin to access directly from main method
    public static class Cabin {
        private String primeName;
        int guestsInCabin;

        public Cabin() {
            primeName = "k";
        }

        public void setID(String testName) {
            primeName = testName;
        }

        public String getID() {
            return primeName;
        }
    }
}
