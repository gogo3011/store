package uni.store.Services;

import uni.store.Entities.Product;
import uni.store.Entities.Store;
import uni.store.Utils.Exceptions.ProductExpiredException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PriceCalculator {
    private PriceCalculator(){}
    public static double calculateSellPrice(Product product, Store store) throws ProductExpiredException{
        double price = product.getPricePerPs();
        switch (product.getProductType()){
            case EDIBLE -> price += price * store.getPercentMarkupEdible();
            case NOT_EDIBLE -> price += price * store.getPercentMarkupNonEdible();
        }
        long daysTillExpiration = ChronoUnit.DAYS.between(LocalDate.now(), product.getExpireDate());
        if(daysTillExpiration < 0)
            throw new ProductExpiredException(product, daysTillExpiration);
        if(daysTillExpiration < store.getDaysTillExpirationDiscount())
            price -= price * store.getPercentExpirationDiscount();
        return price;
    }
}