package uni.store.Entities;

import uni.store.Services.PriceCalculator;
import uni.store.Utils.Exceptions.NoMoreQtyException;
import uni.store.Utils.Exceptions.ProductExpiredException;

import java.util.ArrayList;

public class Cart {
    private Client owner;
    private Store store;
    private ArrayList<Product> products;

    public Cart(Client owner, Store store) {
        this.owner = owner;
        this.store = store;
    }

    public void addProductToCart(Product product){
        try {
            product.reduceQty();
            products.add(product);
        } catch (NoMoreQtyException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Client getOwner() {
        return owner;
    }

    public Store getStore() {
        return store;
    }

    public double calculateTotal(){
        double total = 0.0;
        for (Product p: products) {
            try{
                total += PriceCalculator.calculateSellPrice(p, store);
            } catch (ProductExpiredException e) {
                e.printStackTrace();
            }
        }
        return total;
    }
}
