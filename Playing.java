import java.io.IOException;

public class Playing {

    PropertyJsonReader property = new PropertyJsonReader();
    Company company = new Company();
    RailRoads railRoads = new RailRoads();
    Land land = new Land();
    ChanceList chanceList = new ChanceList();
    communityChestList communityChestList = new communityChestList();
    Writter writter = new Writter();

    public void Play(Players playing,Players waiting,Players player1,Players player2,int dice) throws IOException {
        if(playing.getNewPosition()==11){
            //Jail
            if(playing.getJail()==0){
                String output = playing.getName()+"\t"+dice+"\t"+playing.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playing.getName()+" went to jail ";
                writter.write(output);
            }
            else {
                String output = playing.getName()+"\t"+dice+"\t"+playing.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playing.getName()+" in jail (count="+playing.getJail()+")";
                writter.write(output);
            }
            playing.setJail(playing.getJail()+1);
        }
        if(playing.getNewPosition()==31){
            //Go to Jail
            playing.setNewPosition(11);
            String output = playing.getName()+"\t"+dice+"\t"+playing.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playing.getName()+" went to jail ";
            playing.setJail(playing.getJail()+1);
            writter.write(output);
        }
        if(playing.getNewPosition()==21){
            //Free Parking
            String output = playing.getName()+"\t"+dice+"\t"+playing.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playing.getName()+" is in Free Parking ";
            writter.write(output);
            playing.setFreeParking(playing.getFreeParking()+1);
        }
        if(playing.getNewPosition()==1){
            //Go
            String output = playing.getName()+"\t"+dice+"\t"+playing.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playing.getName()+" is in GO square ";
            writter.write(output);
        }
        if(playing.getNewPosition()==5||playing.getNewPosition()==39){
            //Tax
            playing.setMoney(playing.getMoney()-100);
            String output = playing.getName()+"\t"+dice+"\t"+playing.getNewPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+playing.getName()+" paid Tax ";
            writter.write(output);
        }
        if (property.LandIDList.contains(playing.getNewPosition())){
            int IndexOfProperty =  property.LandIDList.indexOf(playing.getNewPosition());
            String output = land.Game(playing,waiting,property.LandNameList.get(IndexOfProperty),property.LandIDList.get(IndexOfProperty),property.LandCostList.get(IndexOfProperty),dice);
            writter.write(output);
        }
        if (property.RailRoadsIDList.contains(playing.getNewPosition())){
            int IndexOfRailRoads = property.RailRoadsIDList.indexOf(playing.getNewPosition());
            String output = railRoads.Game(playing,waiting,property.RailRoadsNameList.get(IndexOfRailRoads),property.RailRoadsIDList.get(IndexOfRailRoads),property.RailRoadsCostList.get(IndexOfRailRoads),dice);
            writter.write(output);
        }
        if (property.CompanyIDList.contains(playing.getNewPosition())){
            int IndexOfCompany = property.CompanyIDList.indexOf(playing.getNewPosition());
            String output = company.Game(playing,waiting,property.CompanyNameList.get(IndexOfCompany),property.CompanyIDList.get(IndexOfCompany),property.CompanyCostList.get(IndexOfCompany),dice);
            writter.write(output);
        }
        if (playing.getNewPosition()==3||playing.getNewPosition()==18||playing.getNewPosition()==34){
            String output = communityChestList.CardFunc(playing,waiting,dice,player1,player2);
            writter.write(output);
        }
        if (playing.getNewPosition()==8||playing.getNewPosition()==23||playing.getNewPosition()==37){
            String output = chanceList.CardFunc(playing,waiting,dice,player1,player2);
            writter.write(output);
        }
    }
}

