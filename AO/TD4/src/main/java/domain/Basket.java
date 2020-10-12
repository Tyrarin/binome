import java.util.HashSet;

public class Basket {
    
    private HashSet<commandLine> commandList;
    private boolean isValidate;
    private String id;

    Basket(){

    }

    Basket(String id){
        this.commandList = new HashSet<>();
        this.isValidate = false;
        this.id = id;
    }

    Basket(String id , HashSet<commandLine> list , boolean validate){
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
        for(commandLine command : this.commandList){
            amount += command.getAmount();
        }
        return amount;
    }

    public HashSet<commandLine> getCommandList(){
        return this.commandList;
    }

    // GETTERS

    public void basketValidate(){
        this.isValidate = true;
    }

    private boolean inBasket(Reference ref){
        for (commandLine command : this.commandList) {
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

        this.commandList.add(new commandLine(ref, quantity));

    }

    public void removeReference(Reference ref){

        if(this.isValidate()){
            throw new IllegalAccessError("This basket can't be modified !");
        }

        if(!inBasket(ref)){
            throw new IllegalAccessError("This reference isnt in basket , so cant remove it");
        }

        for(commandLine command: this.commandList){
            if(command.getRef().equals(ref)){
                commandList.remove(command);
            }
        }

    }
    public String toString(){
        return "Total of amount in Basket is " + this.getAmount();
    }

}
