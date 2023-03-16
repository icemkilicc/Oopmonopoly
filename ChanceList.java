public class ChanceList {
    public static int cardnumber =-1;
    ListJsonReader cardlist = new ListJsonReader();
    Land landc = new Land();
    communityChestList Chest = new communityChestList();

    public String CardFunc(Players playingName,Players waitingName,int dice,Players player1,Players player2){
        cardnumber++;
        if(cardnumber>5){
            cardnumber=cardnumber-5;
        }

        if(cardnumber==0){
            playingName.setNewPosition(1);
            playingName.setMoney(playingName.getMoney()+200);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Advance to Go (Collect $200) ";
        }
        else if(cardnumber==1){
            if(playingName.getNewPosition()>27){
                playingName.setMoney(playingName.getMoney()+200);
            }
            playingName.setNewPosition(27);
            String PlusOutput = landc.Game(playingName,waitingName,"Leicester Square",27,2600,dice);
            String[] parts = PlusOutput.split(String.valueOf(player2.getMoney()));
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Advance to Leicester Square "+parts[1].trim();
        }
        else if(cardnumber==2){
            playingName.setNewPosition(playingName.getNewPosition()-3);
            if(playingName.getNewPosition()==5){
                playingName.setMoney(playingName.getMoney()-100);
                String output = playingName.getName()+" paid Tax ";
                return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Go back 3 spaces "+output;
            }
            if(playingName.getNewPosition()==20){
                String PlusOutput = landc.Game(playingName,waitingName,"Vine Street",20,2000,dice);
                String[] parts = PlusOutput.split(String.valueOf(player2.getMoney()));
                return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Go back 3 spaces "+parts[1].trim();
            }
            if(playingName.getNewPosition()==34){
                String output = Chest.CardFunc(playingName,waitingName,dice,player1,player2);
                String[] parts = output.split(String.valueOf(player2.getMoney()));
                return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Go back 3 spaces "+parts[1].trim();
            }
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Go back 3 spaces ";
        }
        else if(cardnumber==3){
            playingName.setMoney(playingName.getMoney()-15);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Pay poor tax of $15 ";
        }
        else if(cardnumber==4){
            playingName.setMoney(playingName.getMoney()+150);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Your building loan matures - collect $150 ";
        }
        else if(cardnumber==5){
            playingName.setMoney(playingName.getMoney()+100);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw You have won a crossword competition - collect $100 ";
        }
        return null;
    }
}
