import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player2 extends Players{

    public Player2() {
    }

    public Player2(String name, int newPosition, int money, String processing,int jail,int freeparking,int bankrupt,int recursion) {
        super("Player 2", newPosition, money, processing,jail,freeparking,bankrupt,recursion);
    }

    @Override
    ArrayList<String> split() {
        List<String> processing = new ArrayList<String>(Arrays.asList(getProcessing().split(",")));
        return (ArrayList<String>) processing;
    }

}
