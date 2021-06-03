package uni.store.Entities;

import uni.store.Utils.Exceptions.NoEnoughBalanceException;
import uni.store.Utils.Exceptions.NoMoreQtyException;

public abstract class Client {
    private double balance;
    private Cart cart;
    private Store store;

    public Client(double balance, Store store) {
        this.balance = balance;
        this.store = store;
        cart = new Cart(this, store);
    }

    public void giveMoney(double money) throws NoEnoughBalanceException {
        if(money > this.balance)
            throw new NoEnoughBalanceException( this.balance - money);
        this.balance -= money;
    }

    public double getBalance(){
        return balance;
    }

    public void addToCart(Product product) throws NoMoreQtyException {
        cart.addProductToCart(product);
    }

    public Store getStore(){
        return store;
    }

    public Cart getCart() {
        return cart;
    }
}
