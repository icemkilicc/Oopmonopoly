import java.util.Objects;

public class Company extends Property{
    @Override
    String Game(Players playingName,Players waitingName,String propertiesName, int PropertiesID, int propertiesCost,int dice) {
        Players p1;
        Players p2;
        if(Objects.equals(playingName.getName(),"Player 1")){
            p1 = playingName;
            p2 = waitingName;
        }
        else{
            p1 = waitingName;
            p2 = playingName;
        }
        if(playingName.split().contains(propertiesName)){
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+playingName.getName()+" has "+propertiesName;

        }
        else if(waitingName.split().contains(propertiesName)){
            //Rival have
            int rent = dice*4;
            if(playingName.getMoney()>rent){
                playingName.setMoney(playingName.getMoney()-rent);
                waitingName.setMoney(waitingName.getMoney()+rent);
                return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+playingName.getName()+" paid rent for "+propertiesName;
            }
                    }
        else{
            //Nobody have
            if(playingName.getMoney()>=propertiesCost){
                playingName.setMoney(playingName.getMoney()-propertiesCost);
                playingName.setProcessing(playingName.getProcessing()+","+propertiesName);
                return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+playingName.getName()+" bought "+propertiesName;
            }
        }
        playingName.Bankrupt++;
        return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+playingName.getName()+" goes bankrupt ";
    }
}
