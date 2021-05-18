package uni.store.Utils.Exceptions;

import uni.store.Entities.Product;

public class ProductExpiredException extends Exception{
    public ProductExpiredException(Product product, long days) {
        super("Product " + product.getName() + " has expired since " + -days + ".");
    }
}
