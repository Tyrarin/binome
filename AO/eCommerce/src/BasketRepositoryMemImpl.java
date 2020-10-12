
public class BasketRepositoryMemImpl implements BasketRepository{
    private Basket b;
    BasketRepositoryMemImpl(){

    }

    public void save(Basket basket){
        this.b = basket;
    }

    public Basket load(String id){
        return this.b;
    }
}