import java.io.IOException;

public interface BasketRepository {
    public void save(Basket basket);
    public Basket load(String id);
}