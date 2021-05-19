package uni.store.Entities;

import uni.store.Services.PriceCalculator;
import uni.store.Utils.Exceptions.NoMoreQtyException;
import uni.store.Utils.Exceptions.ProductExpiredException;

import java.util.HashMap;

public class Cart {
    private Client owner;
    private Store store;
    private HashMap<CartItem, CartItem> cartItems;

    public Cart(Client owner, Store store) {
        this.owner = owner;
        this.store = store;
        cartItems = new HashMap<>();
    }

    public void addProductToCart(Product product) throws NoMoreQtyException{
        CartItem item = new CartItem(product);
        CartItem el = cartItems.get(item);
        if (el != null) {
            el.increaseQty();
        } else {
            cartItems.put(item, item);
        }
    }

    public HashMap<CartItem, CartItem> getCartItems() {
        return cartItems;
    }

    public Client getOwner() {
        return owner;
    }

    public Store getStore() {
        return store;
    }

    public double calculateTotal() {
        return cartItems.values().stream().map(cartItem -> {
            double sum = 0.0;
            try {
                sum = PriceCalculator.calculateSellPrice(cartItem, store);
            } catch (ProductExpiredException e) {
                e.printStackTrace();
            }
            return sum;
        }).reduce(0.0, Double::sum);
    }
}
