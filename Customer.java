
import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private int pin;

    private ArrayList<Account> customerAcc = new ArrayList<>();

    public void addAccount(Account account){
        customerAcc.add(account);
    }

    public void removeAccount(Account account){
        customerAcc.remove(account);
    }
    public Account getSingleAccount(int accNo){
        Account foundAcc = null;
        for (Account account : customerAcc){
            if (account.getAccNum() == accNo){
                foundAcc = account;
                break;
            }
        }
        return foundAcc;
    }

    @Override
    public String toString(){
        return String.format("Customer's Name: %s\n Pin: %d\n", firstName, pin);
    }

    public ArrayList<Account> getAllAccount(){
        return customerAcc;
    }

    public int getPin() {
        return pin;
    }

    public String getFirstName() {
        return firstName;
    }
    public Customer(String firstName, String lastName, int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }
}
