import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class PropertyJsonReader {
    public ArrayList<Integer> LandIDList = new ArrayList<>();
    public ArrayList<String> LandNameList = new ArrayList<>();
    public ArrayList<Integer> LandCostList = new ArrayList<>();

    public ArrayList<Integer> RailRoadsIDList = new ArrayList<>();
    public ArrayList<String> RailRoadsNameList = new ArrayList<>();
    public ArrayList<Integer> RailRoadsCostList = new ArrayList<>();

    public ArrayList<Integer> CompanyIDList = new ArrayList<>();
    public ArrayList<String> CompanyNameList = new ArrayList<>();
    public ArrayList<Integer> CompanyCostList = new ArrayList<>();
	 
     public PropertyJsonReader(){
         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("property.json")){
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             JSONArray Land = (JSONArray) jsonfile.get("1");
             for(Object i:Land){

				 LandIDList.add(Integer.parseInt((String)((JSONObject)i).get("id")));
				 LandNameList.add((String)((JSONObject)i).get("name"));
				 LandCostList.add(Integer.parseInt((String)((JSONObject)i).get("cost")));
				 
                 
             }
             JSONArray RailRoad = (JSONArray) jsonfile.get("2");
             for(Object i:RailRoad){

                 RailRoadsIDList.add(Integer.parseInt((String)((JSONObject)i).get("id")));
                 RailRoadsNameList.add((String)((JSONObject)i).get("name"));
                 RailRoadsCostList.add(Integer.parseInt((String)((JSONObject)i).get("cost")));
             }
			 
             JSONArray Company = (JSONArray) jsonfile.get("3");
             for(Object i:Company){

                 CompanyIDList.add(Integer.parseInt((String)((JSONObject)i).get("id")));
                 CompanyNameList.add((String)((JSONObject)i).get("name"));
                 CompanyCostList.add(Integer.parseInt((String)((JSONObject)i).get("cost")));
             }
             
         } catch (IOException e){
             e.printStackTrace();
         } catch (ParseException e){
             e.printStackTrace();
         }
     }

}