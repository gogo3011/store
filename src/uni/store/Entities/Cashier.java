package uni.store.Entities;

public class Cashier extends Employee{
    public Cashier(int id, String name, double salary) {
        super(id, name, salary);
    }

    public Cashier(Employee employee) {
        super(employee);
    }
}
