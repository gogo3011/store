package uni.store.Entities;

import uni.store.Utils.Exceptions.NoMoreQtyException;

import java.util.Objects;

public class CartItem{
    final private Product product;
    private int qty;

    public CartItem(Product product) throws NoMoreQtyException{
        this.product = product;
        this.product.reduceQty();
    }

    public CartItem(Product product, int qty) throws NoMoreQtyException{
        this(product);
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
        return product.getName() + "      x" + qty;
    }
}
