package uni.store.Utils.Exceptions;

public class NoEnoughBalanceException extends Exception{
    public NoEnoughBalanceException(double money) {
        super("Client doesn't have enough money in his bank account. " + -money + "short!");
    }
}
