import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player1 extends Players{

    public Player1() {
    }

    public Player1(String name, int newPosition, int money, String processing,int jail,int freeparking,int bankrupt,int recursion) {
        super(name, newPosition, money, processing,jail,freeparking,bankrupt,recursion);
    }

    @Override
    ArrayList<String> split() {
        List<String> processing = new ArrayList<String>(Arrays.asList(getProcessing().split(",")));
        return (ArrayList<String>) processing;
    }

}
