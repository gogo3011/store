package uni.store.Entities;

import uni.store.Services.PriceCalculator;
import uni.store.Utils.Exceptions.NoMoreQtyException;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double pricePerPs;
    private long qty;
    private ProductType productType;
    private LocalDate expireDate;

    public Product(int id, String name, double pricePerPs, long qty, ProductType productType, LocalDate expireDate) {
        this.id = id;
        this.name = name;
        this.pricePerPs = pricePerPs;
        setQty(qty);
        this.productType = productType;
        this.expireDate = expireDate;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        if(qty >= 0)
            this.qty = qty;
    }

    public void reduceQty() throws NoMoreQtyException {
        if(qty > 0)
            qty--;
        else
            throw new NoMoreQtyException(this);
    }

    public void reduceQty(int qtyToReduce) throws NoMoreQtyException {
        if(qty - qtyToReduce > 0)
            qty -= qtyToReduce;
        else
            throw new NoMoreQtyException(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerPs() {
        return pricePerPs;
    }

    public void setPricePerPs(double pricePerPs) {
        this.pricePerPs = pricePerPs;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        final Product cmp = (Product) obj;
        return (this.id == cmp.id) && this.name.equals(cmp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pricePerPs);
    }

    @Override
    public String toString() {
        return name + " " + qty;
    }

}
