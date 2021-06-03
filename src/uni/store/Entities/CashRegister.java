package uni.store.Entities;

import uni.store.Utils.Exceptions.NoEnoughBalanceException;

public class CashRegister{
    private int id;
    private static int lastId = 1;
    private Cashier cashier;
    private Store store;

    public CashRegister(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
        id = lastId++;
    }

    public Receipt makePurchase(Cart cart) {
        try{
            cart.getOwner().giveMoney(cart.calculateTotal());
        } catch (NoEnoughBalanceException e){
            e.printStackTrace();
        }
        return new Receipt(cart, this);
    }

    public Store getStore(){
        return this.store;
    }

    @Override
    public String toString() {
        return id + " serviced by " + cashier.getName();
    }
}
