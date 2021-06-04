package uni.store.Services;

import uni.store.Entities.CartItem;
import uni.store.Entities.Product;
import uni.store.Entities.Store;
import uni.store.Utils.Exceptions.ProductExpiredException;

public abstract class PriceCalculatorAbstract {
    public abstract double calculateSellPrice(Product product, Store store) throws ProductExpiredException;

    public double calculateSellPrice(CartItem item, Store store) throws ProductExpiredException {
        double price = calculateSellPrice(item.getProduct(), store);
        return price * item.getQty();
    }
}
