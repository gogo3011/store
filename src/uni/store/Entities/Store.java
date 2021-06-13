package uni.store.Entities;

import uni.store.Services.PriceCalculatorAbstract;
import uni.store.Utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String storeName;
    private final List<Product> products;
    private final List<Employee> employees;
    private final List<CashRegister> cashRegisters;
    private final List<Cart> soldCarts;
    private final List<Receipt> receipts;
    private double percentMarkupEdible;
    private double percentMarkupNonEdible;
    private int daysTillExpirationDiscount;
    private double percentExpirationDiscount;
    private final PriceCalculatorAbstract priceCalculatorAbstract;

    public Store(String storeName, double percentMarkupEdible, double percentMarkupNonEdible, int daysTillExpirationDiscount, double percentExpirationDiscount, List<Product> products, List<Employee> employees,
                 List<CashRegister> cashRegisters, PriceCalculatorAbstract priceCalculatorAbstract) {
        this.storeName = storeName;
        this.percentMarkupEdible = percentMarkupEdible;
        this.percentMarkupNonEdible = percentMarkupNonEdible;
        this.daysTillExpirationDiscount = daysTillExpirationDiscount;
        this.percentExpirationDiscount = percentExpirationDiscount;
        this.products = products;
        this.employees = employees;
        this.cashRegisters = cashRegisters;
        this.soldCarts = new ArrayList<>();
        this.receipts = new ArrayList<>();
        this.priceCalculatorAbstract = priceCalculatorAbstract;
    }

    public Store(String storeName, double percentMarkupEdible, double percentMarkupNonEdible, int daysTillExpirationDiscount, double percentExpirationDiscount, PriceCalculatorAbstract priceCalculatorAbstract) {
        this(storeName, percentMarkupEdible, percentMarkupNonEdible, daysTillExpirationDiscount, percentExpirationDiscount,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), priceCalculatorAbstract);
    }

    public double getPercentMarkupNonEdible() {
        return percentMarkupNonEdible;
    }

    public void setPercentMarkupNonEdible(double percentMarkupNonEdible) {
        this.percentMarkupNonEdible = percentMarkupNonEdible;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public double getPercentMarkupEdible() {
        return percentMarkupEdible;
    }

    public void setPercentMarkupEdible(double percentMarkupEdible) {
        this.percentMarkupEdible = percentMarkupEdible;
    }

    public int getDaysTillExpirationDiscount() {
        return daysTillExpirationDiscount;
    }

    public void setDaysTillExpirationDiscount(int daysTillExpirationDiscount) {
        this.daysTillExpirationDiscount = daysTillExpirationDiscount;
    }

    public double getPercentExpirationDiscount() {
        return percentExpirationDiscount;
    }

    public void setPercentExpirationDiscount(double percentExpirationDiscount) {
        this.percentExpirationDiscount = percentExpirationDiscount;
    }

    public boolean addProduct(Product product){
        return products.add(product);
    }

    public List<Cart> getSoldCarts() {
        return soldCarts;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public boolean addProducts(List<Product> products){
        return this.products.addAll(products);
    }

    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }

    public Product getProduct(int index){
        return products.get(index);
    }

    public boolean addCashier(Cashier cashier) {
        addEmployee(cashier);
        return cashRegisters.add(new CashRegister(cashier, this));
    }

    public void makeASale(Client client) {
        makeASale(client.getCart());
    }

    public void makeASale(Cart cart){
        CashRegisterThread crt = new CashRegisterThread(cashRegisters.get(MathUtils.getRandomInt(cashRegisters.size())), cart);
        crt.start();
        soldCarts.add(cart);
        receipts.add(new Receipt(cart, cashRegisters.get(0)));
    }

    public double calculateAllSalaries() {
        return employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
    }

    public double calculateTurnOver() {
        return soldCarts.stream().map(Cart::calculateTotal).reduce(0.0, Double::sum);
    }

    public ArrayList<Product> getProducts(){
        return new ArrayList<>(products);
    }

    public PriceCalculatorAbstract getPriceCalculator() {
        return priceCalculatorAbstract;
    }
}
