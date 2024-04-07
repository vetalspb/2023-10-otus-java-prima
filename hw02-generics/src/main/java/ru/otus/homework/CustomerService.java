package homework;

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class CustomerService {

    private final TreeMap<Customer, String> customers = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> firstEntry = customers.firstEntry();
        if (firstEntry == null) {
            return null;
        }

        Customer customer = new Customer(firstEntry.getKey().getId(), firstEntry.getKey().getName(), firstEntry.getKey().getScores());
        return Map.entry(customer, firstEntry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> customerEntry = customers.higherEntry(customer);
        if (customerEntry == null) {
            return null;
        }
        Customer newCustomer = new Customer(customerEntry.getKey().getId(), customerEntry.getKey().getName(), customerEntry.getKey().getScores());
        return Map.entry(newCustomer, customerEntry.getValue());
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }
}
