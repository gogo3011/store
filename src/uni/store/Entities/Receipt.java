package uni.store.Entities;

import uni.store.Utils.MathUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Receipt implements Serializable {
    final private String text;
    // TODO find a way to write, save and load these static values
    private static int receiptsCreated = 0;
    private static double totalTurnover = 0.0;

    public Receipt(Cart cart, CashRegister cashRegister){
        String textTmp;
        double total = MathUtils.round(cart.calculateTotal(), 2);
        textTmp = "Store: " + cashRegister.getStore().getStoreName() + '\n'
                + "Date: " + LocalDateTime.now() + '\n'
                + "Cash Register №" +  cashRegister.toString() + '\n';
        textTmp += cart.getCartItems().values().stream().map(CartItem::toString)
                .collect(Collectors.joining("\n")) + '\n';
        textTmp += "Total: " + total;
        text = textTmp;
        receiptsCreated++;
        totalTurnover += total;
    }

    @Override
    public String toString(){
        return text;
    }


    public static int getReceiptsCreated() {
        return receiptsCreated;
    }

    public static double getTotalTurnover() {
        return totalTurnover;
    }
}
