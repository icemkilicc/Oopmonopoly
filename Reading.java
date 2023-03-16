import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Reading {
    public void Reader(String txt) throws IOException {
        File myObj = new File(txt);
        Scanner myReader = new Scanner(myObj);

        Writter writter = new Writter();
        Playing Game = new Playing();


        Player1 player1 = new Player1("Player 1", 1,15000,"",0,1,0,1);
        Player2 player2 = new Player2("Player 2", 1,15000,"",0,1,0,1);
        Players playing = null;
        Players waiting = null;

        while (myReader.hasNext()) {
            String commandline = myReader.nextLine();
            if(Objects.equals(commandline, "show()")){
                writter.show(player1,player2,player1.getMoney(),player2.getMoney());
            }
            else{
                String[] parts = commandline.split(";");
                int dice = Integer.parseInt(parts[1]);

                if (Objects.equals(parts[0], "Player 1")){
                    playing = player1;
                    waiting = player2;
                    if(playing.Recursion%2==0){
                        Game.Play(playing,waiting,player1,player2,dice);
                    }
                    if(playing.getJail()%4==0&&playing.getFreeParking()%2!=0){
                        player1.setNewPosition(dice + player1.getNewPosition());
                    }
                    if(player1.getNewPosition()>40){
                        player1.setMoney(player1.getMoney()+200);
                        player1.setNewPosition(player1.getNewPosition()-40);
                    }
                }
                else {
                    playing = player2;
                    waiting = player1;
                    if(playing.Recursion%2==0){
                        Game.Play(playing,waiting,player1,player2,dice);
                    }
                    if(playing.getJail()%4==0&&playing.getFreeParking()%2!=0) {
                        player2.setNewPosition(dice + player2.getNewPosition());
                    }
                    if(player2.getNewPosition()>40){
                        player2.setMoney(player2.getMoney()+200);
                        player2.setNewPosition(player2.getNewPosition()-40);
                    }
                }
                int player1money = player1.getMoney();
                int player2money = player2.getMoney();


                Game.Play(playing,waiting,player1,player2,dice);
                if(player1.getMoney()<=0||player2.getMoney()<=0||player1.Bankrupt==1||player2.Bankrupt==1){
                    writter.show(player1,player2,player1money,player2money);
                    break;
                }
                if(!myReader.hasNext()){
                    writter.show(player1,player2,player1.getMoney(),player2.getMoney());
                }
            }
        }
        writter.WriteTxtFile();
    }
}

