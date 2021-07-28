package uni.store;

import uni.store.Entities.*;
import uni.store.Services.PriceCalculatorImpl;
import uni.store.Services.PriceCalculatorAbstract;
import uni.store.Utils.FileHelper;
import uni.store.Utils.ProductFactory;

import java.util.ArrayList;
import java.util.List;

public class BuyStoreSim {
    private BuyStoreSim(){}
    public static void startDemo() {
        PriceCalculatorAbstract pci = new PriceCalculatorImpl();
        Store store = new Store("demo", 0.03, 0.02, 5, 0.10, pci);
        store.addProducts(ProductFactory.generateProductsFromJSON());
        store.addCashier(new Cashier(1, "Nithin", 200.0));
        store.addCashier(new Cashier(2, "Donka", 500.0));
        List<AIClient> clients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            clients.add(new AIClient(200.0, store));
        }
        clients.forEach(AIClient::pickAProduct);
        clients.forEach(store::makeASale);
        store.getReceipts().forEach(System.out::println);
        store.getReceipts().forEach(FileHelper::writeToFile);
        System.out.println(store.calculateAllSalaries());
    }
}
