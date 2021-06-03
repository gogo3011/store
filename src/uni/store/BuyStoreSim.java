package uni.store;

import uni.store.Entities.*;
import uni.store.Utils.ProductFactory;

import java.util.ArrayList;
import java.util.List;

public class BuyStoreSim {
    private BuyStoreSim(){}
    public static void startDemo() {
        Store store = new Store("demo", 0.03, 0.02, 5, 0.10);
        store.addProducts(ProductFactory.generateProductsFromJSON());
        store.addCashier(new Cashier(1, "Nithin", 200.0));
        List<AIClient> clients = new ArrayList<AIClient>();
        for (int i = 0; i < 10; i++) {
            clients.add(new AIClient(200, store));
        }
        clients.parallelStream().forEach(AIClient::pickAProduct);
        clients.parallelStream().forEach(c -> {
            new CashRegisterThread(new CashRegister(new Cashier(1, "Nithin", 200.0), store), c.getCart()).start();
        });
        store.getReceipts().forEach(System.out::println);
    }
}
