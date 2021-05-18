package uni.store.Entities;

public class CartItem{
    private Product product;
    private int qty;

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;

        final CartItem cmp = (CartItem) obj;
        return product.equals(cmp.product);
    }
}
