//Creating a public class called Cabin to access directly from main method from CruiseShip_Task_2 class
public class Cabin {
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
