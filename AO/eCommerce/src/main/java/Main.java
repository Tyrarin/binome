
import java.util.*;

class Main {
    public static void main (String[] args){

         Reference r1 = new Reference("first", "first", "bla", 1);
         Reference r2 = new Reference("second", "second", "blabla", 2);

         Basket b = new Basket("Premier");
         b.addReference(r1, 5);
         b.addReference(r2, 10);

         BasketRepositoryJSONImpl repo = new BasketRepositoryJSONImpl();
         b.removeReference(r2);
         repo.save(b);


         Basket newB = repo.load("Premier");

         System.out.println(newB.toString());
    }
 }
