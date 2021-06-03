package uni.store.Entities;

import uni.store.Utils.Exceptions.NoMoreQtyException;
import uni.store.Services.PriceCalculator;
import uni.store.Utils.Exceptions.ProductExpiredException;

public class CartItem{
    final private Product product;
    final private Store store;
    private int qty = 0;

    public CartItem(Product product, Store store) throws NoMoreQtyException{
        this.product = product;
        this.store = store;
        increaseQty();
    }

    public CartItem(Product product, Store store, int qty) throws NoMoreQtyException{
        this(product, store);
        setQty(qty);
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;
        final CartItem cmp = (CartItem) obj;
        return product.equals(cmp.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        try {
            product.reduceQty(qty);
            this.qty = qty;
        } catch (NoMoreQtyException e) {
            e.printStackTrace();
        }
    }

    public void increaseQty(){
        try {
            product.reduceQty();
            qty++;
        } catch (NoMoreQtyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        try {
            return product.getName() + "      x" + qty + " = " + qty * PriceCalculator.calculateSellPrice(product, store);
        } catch (ProductExpiredException e) {
            e.printStackTrace();
        }
        return "";
    }
}
