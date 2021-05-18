package uni.store.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Receipt implements Serializable {
    private String text;
    public Receipt(Cart cart, CashRegister cashRegister){
        text = cart.getStore().getStoreName() + '\n'
                + "Date: " + LocalDateTime.now().toString() + '\n'
                + cashRegister.toString() + '\n';

    }
}
