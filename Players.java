import java.util.ArrayList;
import java.util.List;

public abstract class Players {
    private String Name;
    private int NewPosition;
    private int Money = 15000;
    private String Processing;
    private int Jail;
    private int FreeParking;
    public int Bankrupt;
    public int Recursion;
    public Players(){}

    public Players(String name, int newPosition, int money, String processing,int jail,int freeParking,int bankrupt,int recursion) {
        Name = name;
        NewPosition = newPosition;
        Money = money;
        Processing = processing;
        Jail =jail;
        FreeParking = freeParking;
        Bankrupt = bankrupt;
        Recursion = recursion;
    }
    abstract ArrayList<String> split();

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public void setNewPosition(int newPosition) {NewPosition = newPosition;}

    public void setMoney(int money) {Money = money;}

    public void setProcessing(String processing) {Processing = processing;}

    public int getNewPosition() {return NewPosition;}

    public int getMoney() {return Money;}

    public String getProcessing() {return Processing;}

    public void setJail(int jail) {Jail = jail;}

    public int getJail() {return Jail;}

    public void setFreeParking(int freeParking) {FreeParking = freeParking;}

    public int getFreeParking() {return FreeParking;}

}
