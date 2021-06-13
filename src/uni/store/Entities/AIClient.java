package uni.store.Entities;

import uni.store.Utils.Exceptions.NoMoreQtyException;
import uni.store.Utils.MathUtils;

import java.util.List;

public class AIClient extends Client{
    public AIClient(double balance, Store store) {
        super(balance,store);
    }

    public void pickAProduct() {
        for (int i = 0; i < 1 + MathUtils.getRandomInt(3); i++) {
            List<Product> productsAvailable = getStore().getProducts();
            int max = productsAvailable.size();
            for (int count = 0; count < 3; count++) {
                try {
                    Product product = productsAvailable.get(MathUtils.getRandomInt(max));
                    addToCart(product);
                    break;
                } catch (NoMoreQtyException ignored) {

                }
            }
        }
    }
}
