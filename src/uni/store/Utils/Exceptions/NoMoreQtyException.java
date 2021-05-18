package uni.store.Utils.Exceptions;

import uni.store.Entities.Product;

public class NoMoreQtyException extends Exception{
    public NoMoreQtyException(Product product) {
        super("No more qty available: " + product.getName());
    }
}
