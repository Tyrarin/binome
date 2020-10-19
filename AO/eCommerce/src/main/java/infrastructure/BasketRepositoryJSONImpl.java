
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import java.util.*;

@SuppressWarnings("unchecked")
public class BasketRepositoryJSONImpl implements BasketRepository{
    
    public BasketRepositoryJSONImpl(){

    }

    public void save(Basket basket){
        JSONObject main = new JSONObject();
        JSONObject basketRepo = new JSONObject();

        JSONArray commandLines = new JSONArray();
        JSONObject newLine;

        for (Map.Entry<Reference,Integer> el : basket.getCommandList().entrySet()) {
            newLine = new JSONObject();
            newLine.put("id", el.getKey().getId());
            newLine.put("name",el.getKey().getName());
            newLine.put("description", el.getKey().getDescription());
            newLine.put("price", el.getKey().getPrice());
            newLine.put("quantity",el.getValue().intValue());

            commandLines.add(newLine);
        }

        basketRepo.put("commandLines",commandLines);
        basketRepo.put("isValidate", basket.isValidate());

        main.put(basket.getId(), basketRepo);

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
            Map<Reference,Integer> list = new HashMap<>();

            for(int i = 0 ; i < basketList.size() ; i++){
                JSONObject el = (JSONObject) basketList.get(i);
                Reference ref = new Reference(
                    (String) el.get("id"),
                    (String) el.get("name"),
                    (String) el.get("description"),
                    ((Long) el.get("price")).intValue()
                );
                list.put(ref, ((Long) el.get("quantity")).intValue() );
                System.out.println(ref.toString());
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

}
