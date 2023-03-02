import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class CruiseShip_Task_2 {

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

        SurName[] SName = new SurName[12];
        SName[0] = new SurName();
        SName[1] = new SurName();
        SName[2] = new SurName();
        SName[3] = new SurName();
        SName[4] = new SurName();
        SName[5] = new SurName();
        SName[6] = new SurName();
        SName[7] = new SurName();
        SName[8] = new SurName();
        SName[9] = new SurName();
        SName[10] = new SurName();
        SName[11] = new SurName();
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
                System.out.println("T: Expenses for the cabins");
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
                        AddACustomer(cruiseShip, cabinNumber, SName);
                        break;
                    case "V":
                        ViewAllCabins(cruiseShip, SName);
                        break;
                    case "E":
                        EmptyCabins(cruiseShip);
                        break;
                    case "D":
                        DeleteCustomer(cruiseShip, cabinNumber, SName);
                        break;
                    case "T":
                        CabinExpenses(cruiseShip);
                        break;
                    case "F":
                        FIndCustomer(cruiseShip);
                        break;
                    case "S":
                        StoreDataIntoFile(cruiseShip, SName);
                        break;
                    case "L":
                        LoadDataFromFile(cruiseShip, SName);
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
    private static void AddACustomer(Cabin[]  cruiseShip, int cabinNumber, SurName[] SName) {
        String cabinID;
        String surnameID;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter room number (1-12): ");
        cabinNumber = userInput.nextInt() - 1;
        System.out.println("Enter First Name for cabin " + (cabinNumber + 1) + " : ");
        cabinID = userInput.next();
        cruiseShip[cabinNumber].setID(cabinID);
        System.out.println("Enter Surname for cabin " + (cabinNumber + 1) + " : ");
        surnameID = userInput.next();
        SName[cabinNumber].createID(surnameID);
    }

    //ViewAllCabins method to show all the cabins, the cabins' area occupied or not
    private static void ViewAllCabins(Cabin[] cruiseShip, SurName[] SName) {
        for (int y = 0; y < cruiseShip.length; y++)
            System.out.println("Cabin " + (y + 1) + " occupied by " + cruiseShip[y].getID() + " " + SName[y].callID());
    }

    //EmptyCabins method which shows all the empty cabins
    private static void EmptyCabins(Cabin[] cruiseShip) {
        for (int y = 0; y < cruiseShip.length; y++) {
            if (cruiseShip[y].getID().equals("----")) {
                System.out.println("Cabin " + (y + 1) + " is empty");
            }
            else {
                System.out.println("Cabin " + (y + 1) + " is Full");
            }
        }
    }

    //DeleteCustomer method which remove data from each index from the array as the user wanted
    private static void DeleteCustomer(Cabin[] cruiseShip, int cabinNumber, SurName[] SName) {
        Scanner delete = new Scanner(System.in);
        System.out.println("Enter cabin number to delete(1-12):");
        cabinNumber = delete.nextInt() - 1;
        cruiseShip[cabinNumber].setID("----");
        SName[cabinNumber].createID("----");
        System.out.println("Data has been Deleted..! ");
    }

    private static void CabinExpenses(Cabin[] cruiseShip) {
        int expense;
        double money = 250.00;
        Scanner select = new Scanner(System.in);
        System.out.println("Select the options,\n");
        System.out.println("1) Expenses per passenger");
        System.out.println("2) Total Expenses of all passengers");
        expense = select.nextInt();
        if (expense == 1) {
            System.out.println("Expenses per passenger: $ "+money);
        }
        if (expense == 2) {
            System.out.println("Total Expenses of all passengers: $ "+(money*cruiseShip.length*3));
        }
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
                System.out.println("The Cabin "+cabinID+" in is Cabin number: " + (y + 1));
                Search = true;
            }
        }
        if (Search == false) {
            System.out.println("There are no Cabins Booked with that name\n");
        }
    }

    //StoreDataIntoFile method to store the current data runs in the program into a text file called StoreDataFile.txt
    private static void StoreDataIntoFile(Cabin[] cruiseShip, SurName[] SName) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("../SD 2 - Coursework - Task 2/StoreDataFile.txt"))) {
            int y;
            for (y = 0; y < cruiseShip.length; y++)
                out.println(cruiseShip[y].getID() + " " + SName[y].callID());
        }
        System.out.println("All Store Data have been Saved...");
    }

    //LoadDataFromFile method to load data from a text file called StoreDataFile.txt to run the program
    private static void LoadDataFromFile(Cabin[] cruiseShip, SurName[] SName) throws IOException {
        FileInputStream FileStream = new FileInputStream("../SD 2 - Coursework - Task 2/StoreDataFile.txt");
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

    //Creating a public class called SurName to access directly from main method
    public static class SurName {
        private String centralName;
        int guestsInCabinSurName;

        public SurName() { centralName = "----"; }

        public void createID(String fullName) {centralName = fullName; }

        public String callID() { return centralName; }
    }
}
