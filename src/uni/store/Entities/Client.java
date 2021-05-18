package uni.store.Entities;

import uni.store.Utils.Exceptions.NoEnoughBalanceException;

public class Client {
    private double balance;

    public Client(double balance) {
        this.balance = balance;
    }

    public void giveMoney(double money) throws NoEnoughBalanceException {
        if(money > this.balance)
            throw new NoEnoughBalanceException( this.balance - money);
        this.balance -= money;
    }
}
