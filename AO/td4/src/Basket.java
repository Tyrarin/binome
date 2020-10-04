package src;

import java.util.HashMap;

public class Basket {
    
    private HashMap<String,commandLine> commandList;
    private int amount;
    private boolean isValidate;

    Basket(){
        this.commandList = new HashMap<>();
        this.amount = 0;

        this.isValidate = false;
    }

    // GETTERS 

    public int getAmount(){
        return this.amount;
    }

    public boolean isValidate(){
        return this.isValidate;
    }

    // GETTERS

    public void basketValidate(){
        this.isValidate = true;
    }

    private boolean inBasket(Reference ref){
        for (commandLine command : this.commandList.values()) {
            if (command.getRef().equals(ref)) {
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

        this.commandList.put(ref.getId(), 
        new commandLine(ref, quantity));

        this.amount += commandList.get(ref.getId()).getAmount();

    }

    public void removeReference(Reference ref){

        if(this.isValidate()){
            throw new IllegalAccessError("This basket can't be modified !");
        }



        if(commandList.get(ref.getId()) != null){
            this.amount -= commandList.get(ref.getId()).getAmount();
            commandList.remove(ref.getId());
        }
        else{
            throw new IllegalAccessError("This reference isnt in basket , so cant remove it");
        }

    }

    public String toString(){
        return "Le total est " + this.getAmount();
    }
}
