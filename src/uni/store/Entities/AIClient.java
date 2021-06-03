package uni.store.Entities;

import uni.store.Utils.Exceptions.NoMoreQtyException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AIClient extends Client{
    public AIClient(double balance, Store store) {
        super(balance,store);
    }

    public void pickAProduct() {
        for (int i = 0; i < 1 + getRandomInt(4); i++) {

            List<Product> productsAvailable = getStore().getProducts();
            int max = productsAvailable.size();
            for (int count = 0; count < 3; count++) {
                try {
                    Product product = productsAvailable.get(getRandomInt(max));
                    addToCart(product);
                    break;
                } catch (NoMoreQtyException ignored) {

                }
            }
        }
    }

    private static int getRandomInt(int max){
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
