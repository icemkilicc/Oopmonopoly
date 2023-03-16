import java.util.Objects;

public class Land extends Property {
    @Override
    String Game(Players playingName,Players waitingName, String propertiesName, int PropertiesID, int propertiesCost,int dice) {
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
        PropertyJsonReader property = new PropertyJsonReader();
        if(playingName.split().contains(propertiesName)){
            //He have already had this company
            return playingName.getName()+"\t"+dice+"\t"+playingName.getNewPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+playingName.getName()+" has "+propertiesName;
        }
        else if(waitingName.split().contains(propertiesName)){
            //Rival have
            int index = property.LandNameList.indexOf(propertiesName);
            int rent= 0;
            if(property.LandCostList.get(index)<=2000){
                rent = property.LandCostList.get(index)*40/100;
            }
            else if(property.LandCostList.get(index)<=3000&&property.LandCostList.get(index)>2000){
                rent = property.LandCostList.get(index)*30/100;
            }
            else if(property.LandCostList.get(index)<=4000&&property.LandCostList.get(index)>3000){
                rent = property.LandCostList.get(index)*35/100;
            }
            if(playingName.getMoney()>rent){
                waitingName.setMoney(waitingName.getMoney()+rent);
                playingName.setMoney(playingName.getMoney()-rent);
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
