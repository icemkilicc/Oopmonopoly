public class communityChestList {
    public static int cardnumber =-1;
    ListJsonReader cardlist = new ListJsonReader();

    public String CardFunc(Players playingName,Players waitingName,int dice,Players player1,Players player2){
        cardnumber++;
        if(cardnumber>10){
            cardnumber=cardnumber-10;
        }

        if(cardnumber==0){
            playingName.setNewPosition(1);
            playingName.setMoney(playingName.getMoney()+200);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest -advance to go ";
        }
        else if(cardnumber==1){
            playingName.setMoney(playingName.getMoney()+75);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Bank error in your favor - collect $75 ";
        }
        else if(cardnumber==2){
            playingName.setMoney(playingName.getMoney()-50);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Doctor's fees - Pay $50 ";
        }
        else if(cardnumber==3){
            playingName.setMoney(playingName.getMoney()+10);
            waitingName.setMoney(waitingName.getMoney()-10);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest It is your birthday Collect $10 from each player ";
        }
        else if(cardnumber==4){
            playingName.setMoney(playingName.getMoney()+50);
            waitingName.setMoney(waitingName.getMoney()-50);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Grand Opera Night - collect $50 from every player for opening night seats ";
        }
        else if(cardnumber==5){
            playingName.setMoney(playingName.getMoney()+20);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Income Tax refund - collect $20 ";
        }
        else if(cardnumber==6){
            playingName.setMoney(playingName.getMoney()+100);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Life Insurance Matures - collect $100 ";
        }
        else if(cardnumber==7){
            playingName.setMoney(playingName.getMoney()-100);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Pay Hospital Fees of $100 ";
        }
        else if(cardnumber==8){
            playingName.setMoney(playingName.getMoney()-50);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest Pay School Fees of $50 ";
        }
        else if(cardnumber==9){
            playingName.setMoney(playingName.getMoney()+100);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" draw Community Chest You inherit $100 ";
        }
        else if(cardnumber==10){
            playingName.setMoney(playingName.getMoney()+50);
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playingName.getName()+" From sale of stock you get $50 ";
        }
        cardnumber++;

        return null;
    }
}
