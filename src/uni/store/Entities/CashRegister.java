package uni.store.Entities;

import uni.store.Utils.Exceptions.NoEnoughBalanceException;

public class CashRegister {
    private int id;
    private Cashier cashier;

    public CashRegister(Cashier cashier) {
        this.cashier = cashier;
    }

    public void makePurchase(Cart cart) {
        try{
            cart.getOwner().giveMoney(cart.calculateTotal());
        } catch (NoEnoughBalanceException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return id + " by " + cashier.getName();
    }
}
