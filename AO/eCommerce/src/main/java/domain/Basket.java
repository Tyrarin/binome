
import java.util.*;

public class Basket {
    
    private Map<Reference,Integer> commandList;
    private boolean isValidate;
    private String id;

    public Basket(){

    }

    public Basket(String id){
        this.commandList = new HashMap<Reference,Integer>();
        this.isValidate = false;
        this.id = id;
    }

    public Basket(String id , Map<Reference,Integer> list , boolean validate){
        this.commandList = list;
        this.isValidate = validate;
        this.id = id;
    }

    // GETTERS 

    public String getId(){
        return this.id;
    }

    public boolean isValidate(){
        return this.isValidate;
    }

    public int getAmount(){
        int amount = 0;
        for (Map.Entry<Reference,Integer> m : this.commandList.entrySet()) {
            amount += m.getKey().getPrice() * m.getValue().intValue();
        }
        return amount;
    }

    public Map<Reference,Integer> getCommandList(){
        return this.commandList;
    }

    // GETTERS

    public void basketValidate(){
        this.isValidate = true;
    }

    private boolean inBasket(Reference ref){
        for (Map.Entry<Reference,Integer> m : this.commandList.entrySet()) {
            if(m.getKey().equals(ref)){
                return true;
            }
        }

        return false;
    }

    public void addReference(Reference ref , int quantity){
        if(this.inBasket(ref)){
            throw new IllegalArgumentException("This reference is already in basket");
        }

        if(this.isValidate()){
            throw new IllegalAccessError("This basket can't be modified !");
        }

        this.commandList.put(ref,quantity);

    }

    public void removeReference(Reference ref){

        if(this.isValidate()){
            throw new IllegalAccessError("This basket can't be modified !");
        }

        if(!inBasket(ref)){
            throw new IllegalAccessError("This reference isnt in basket , so cant remove it");
        }

        this.commandList.remove(ref);
    }
    
    public String toString(){
        return "Total of amount in Basket is " + this.getAmount();
    }

}
