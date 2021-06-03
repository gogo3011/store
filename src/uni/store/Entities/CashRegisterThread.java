package uni.store.Entities;

public class CashRegisterThread extends Thread{
    final private CashRegister register;
    final private Cart cart;

    public CashRegisterThread(CashRegister register, Cart cart) {
        this.register = register;
        this.cart = cart;
    }

    @Override
    public void run() {
        System.out.println(register.makePurchase(cart));
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
