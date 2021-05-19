package uni.store.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Receipt implements Serializable {
    final private String text;
    public Receipt(Cart cart, CashRegister cashRegister){
        String textTmp;
        textTmp = cart.getStore().getStoreName() + '\n'
                + "Date: " + LocalDateTime.now() + '\n'
                + cashRegister.toString() + '\n';
        textTmp += cart.getCartItems().values().stream().map(CartItem::toString)
                .collect(Collectors.joining("\n"));
        text = textTmp;
    }
}
