
import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();
    public void addCustomer(Customer customer){
        customers.add(customer);
//        return customer;
    }
    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }
    public Customer getSingleCustomer(int pin){
        Customer foundCustomer = null;
        for (Customer customer : customers){
            if (customer.getPin() == pin){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public ArrayList<Customer> getAllCustomer(){
        return customers;
    }

}
