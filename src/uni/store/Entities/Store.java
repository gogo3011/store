package uni.store.Entities;

public class Store {
    private String storeName;
    private double percentMarkupEdible;
    private double percentMarkupNonEdible;
    private int daysTillExpirationDiscount;
    private double percentExpirationDiscount;

    public Store(String storeName, double percentMarkupEdible, double percentMarkupNonEdible, int daysTillExpirationDiscount, double percentExpirationDiscount) {
        this.storeName = storeName;
        this.percentMarkupEdible = percentMarkupEdible;
        this.percentMarkupNonEdible = percentMarkupNonEdible;
        this.daysTillExpirationDiscount = daysTillExpirationDiscount;
        this.percentExpirationDiscount = percentExpirationDiscount;
    }

    public double getPercentMarkupNonEdible() {
        return percentMarkupNonEdible;
    }

    public void setPercentMarkupNonEdible(double percentMarkupNonEdible) {
        this.percentMarkupNonEdible = percentMarkupNonEdible;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public double getPercentMarkupEdible() {
        return percentMarkupEdible;
    }

    public void setPercentMarkupEdible(double percentMarkupEdible) {
        this.percentMarkupEdible = percentMarkupEdible;
    }

    public int getDaysTillExpirationDiscount() {
        return daysTillExpirationDiscount;
    }

    public void setDaysTillExpirationDiscount(int daysTillExpirationDiscount) {
        this.daysTillExpirationDiscount = daysTillExpirationDiscount;
    }

    public double getPercentExpirationDiscount() {
        return percentExpirationDiscount;
    }

    public void setPercentExpirationDiscount(double percentExpirationDiscount) {
        this.percentExpirationDiscount = percentExpirationDiscount;
    }
}
