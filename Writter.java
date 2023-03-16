import java.io.FileWriter;
import java.io.IOException;

public class Writter {

    public static String CompleteOutput;


    public void write(String output) throws IOException {
        if(CompleteOutput==null) {
            CompleteOutput = output;}
        else{CompleteOutput = CompleteOutput+"\n"+output;}
    }

    public void WriteTxtFile() throws IOException {
        FileWriter monitoring = new FileWriter("output.txt");
        monitoring.write(CompleteOutput);
        monitoring.close();
    }

    void show(Players player1, Players player2,int player1money,int player2money) throws IOException {
        write("-------------------------------------------------------------------------------------------------------------------------");
        write("Player 1\t"+player1.getMoney()+"\t"+"have: " +player1.getProcessing().replaceFirst(",",""));
        write("Player 2\t"+player2.getMoney()+"\t"+"have: " +player2.getProcessing().replaceFirst(",",""));
        write("Banker\t"+(130000-(player1.getMoney()+player2.getMoney())));
        if(player1.getMoney()>player2.getMoney()){write("Winner Player 1");}
        else{write("Winner Player 2");}
        write("-------------------------------------------------------------------------------------------------------------------------");

    }




}
