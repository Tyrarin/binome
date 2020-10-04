package src;

import java.util.Objects;

/**
 * Value Object
 */
public class Reference {
    
    private String id;
    private String name;
    private String description;
    private int price;


    Reference(String id , String name , String description , int price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // GETTERS

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPrice(){
        return this.price;
    }

    // GETTERS

    @Override
    public boolean equals(Object other) {
        if (other instanceof Reference) {
            Reference otherReference = (Reference) other;
            boolean equals = this.getId().compareTo(otherReference.getId()) == 0;
            return equals;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Reference id= " + id + " name= " + name + " description= " + description;
    }


}
