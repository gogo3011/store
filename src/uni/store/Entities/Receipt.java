package uni.store.Entities;

import uni.store.Utils.MathUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Receipt implements Serializable {
    final private String text;
    // TODO find a way to save and load these static values
    private static int receiptsCreated = 0;
    private static double totalTurnover = 0.0;

    public Receipt(Cart cart, CashRegister cashRegister){
        StringBuilder textTmp = new StringBuilder();
        double total = MathUtils.round(cart.calculateTotal(), 2);
        textTmp.append("Store: ").append(cashRegister.getStore().getStoreName()).append('\n')
                .append("Date: ").append(LocalDateTime.now()).append('\n')
                .append("Cash Register №").append(cashRegister).append('\n')
                .append(cart.getCartItems().values().stream().map(CartItem::toString).collect(Collectors.joining("\n")))
                .append('\n')
                .append("Total: " + total);
        text = textTmp.toString();
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
