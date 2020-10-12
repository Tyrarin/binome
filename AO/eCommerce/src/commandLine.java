public class commandLine {
    private Reference ref;
    private int quantity;

    commandLine(Reference ref , int quantity){
        this.ref =ref;
        this.quantity = quantity;
    }
    

    // GETTERS 

    public Reference getRef(){
        return this.ref;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public int getAmount(){
        return this.ref.getPrice() * this.quantity;
    }


    // GETTERS

}
