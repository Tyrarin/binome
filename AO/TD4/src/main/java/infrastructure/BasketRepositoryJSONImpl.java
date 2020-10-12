import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;


public class BasketRepositoryJSONImpl implements BasketRepository{
    BasketRepositoryJSONImpl(){
        
    }

    public void save(Basket basket){

    //Create main object of JSON file
        JSONObject main = new JSONObject();
        JSONObject basketRepo = new JSONObject();

        JSONArray commandLines = new JSONArray();

        for(commandLine command : basket.getCommandList()){
            JSONObject newLine = new JSONObject();
            newLine.put("id",command.getRef().getId());
            newLine.put("name",command.getRef().getName());
            newLine.put("description",command.getRef().getDescription());
            newLine.put("price",command.getRef().getPrice());
            newLine.put("quantity",command.getQuantity());
            commandLines.add(newLine);
        }

        basketRepo.put("commandLines",commandLines);
        basketRepo.put("isValidate",basket.isValidate());

        main.put(basket.getId(),basketRepo);

       //Write JSON file
       try (FileWriter file = new FileWriter("save.json")) {

           file.write(main.toJSONString());
           file.flush();

       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public Basket load(String id){
        JSONParser jsonParser = new JSONParser();
        Basket loadBasket;
        try (FileReader reader = new FileReader("save.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject json = (JSONObject) obj;
            JSONObject basket = (JSONObject) json.get(id);
            JSONArray basketList = (JSONArray) basket.get("commandLines");
            HashSet<commandLine> list = new HashSet<>();

            for(int i = 0 ; i < basketList.size() ; i++){
                JSONObject el = (JSONObject) basketList.get(i);
                Reference ref = new Reference(
                    (String) el.get("id"),
                    (String) el.get("name"),
                    (String) el.get("description"),
                    ((Long) el.get("price")).intValue()
                );

                list.add(new commandLine(ref,(int) ((Long) el.get("quantity")).intValue()));
            }

            return loadBasket = new Basket(id,list,(boolean) basket.get("isValidate"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

            return null;
    }

    private static void parseEmployeeObject(JSONObject employee, String id , boolean validate) 
    {
        // //Get employee object within list
        // JSONObject employeeObject = (JSONObject) employee.get("employee");
         
        // //Get employee first name
        // String firstName = (String) employeeObject.get("firstName");    
        // System.out.println(firstName);
         
        // //Get employee last name
        // String lastName = (String) employeeObject.get("lastName");  
        // System.out.println(lastName);
         
        // //Get employee website name
        // String website = (String) employeeObject.get("website");    
        // System.out.println(website + "\n");


    }
}