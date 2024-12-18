import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Bank bank = new Bank();


    public void displayMenu(){
        while (true){
            System.out.println("******* MENU *******");
            System.out.println();
            System.out.println("Please make a selection");
            System.out.println("1) Access Account");
            System.out.println("2) Open a New Account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Exit");
            System.out.print(">>");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    accessAccount();
                    break;
                case 2:
                    openNewAccount();
                    break;
                case 3:
                    closeAllAccounts();
                    break;
                case 4:
                    System.out.println("Thanks for using BSU Banking App");
                    System.out.println("Goodbye. Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void accessAccount(){
        System.out.println("Please enter your PIN:");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = bank.getSingleCustomer(pin);
        if (customer != null){
            System.out.println("*****Active Accounts*******");
            System.out.println("Welcome " + customer.getFirstName());
            for (Account account1 : customer.getAllAccount()){
                System.out.println(account1.toString());
            }
            System.out.println("Please enter the account no of the account you would like to access:");
            int accNo = Integer.parseInt(scanner.nextLine());
            Account account = customer.getSingleAccount(accNo);
            if (account == null){
                System.out.println("Invalid PIN. Please try again.");
                displayMenu();
            }else {
                while (true){
                    System.out.println("Please make a selection");
                    System.out.println("1) Make a deposit");
                    System.out.println("2) Make a withdrawal");
                    System.out.println("3) See account balance");
                    System.out.println("4) Close account");
                    System.out.println("5) Exit");

                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            account.deposit();
                            break;
                        case 2:
                            account.withdraw();
                            break;
                        case 3:
                            System.out.println("Account " + account.getAccNum() + " balance: " + account.getBalance());
                            break;
                        case 4:
                            customer.removeAccount(account);
                            System.out.println("Account number " + account.getAccNum() + " closed ");
                            return;
                        case 5:
                            return;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }else {
            System.out.println("Invalid PIN. Please try again.");
            displayMenu();
        }
    }
    private Customer createNewCustomer(){
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name");
        String lastName = scanner.nextLine();
        System.out.println("Please enter a 4 digit PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());

        Customer newCustomer = new Customer(firstName, lastName, pin);
        bank.addCustomer(newCustomer);
        System.out.println("New customer added successfully.");
        return newCustomer;

    }
    private void openNewAccount(){
        System.out.println("Are you a new customer");
        System.out.println("1) Yes");
        System.out.println("2) No");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                Customer newCustomer = createNewCustomer();
                System.out.println("Please enter deposit amount");
                int depositAmt1 = Integer.parseInt(scanner.nextLine());
                Account newAccount1 = new Account(depositAmt1);
                newCustomer.addAccount(newAccount1);
                System.out.println("New Account Opened: " + newAccount1.getAccNum());
                break;
            case 2:
                System.out.println("Please enter PIN");
                int pin = Integer.parseInt(scanner.nextLine());
                Customer existingCustomer = bank.getSingleCustomer(pin);
                if ( existingCustomer == null){
                    System.out.println("Customer not found.");
                    displayMenu();
                }else {
                    System.out.println("Please enter deposit amount");
                    int depositAmt = Integer.parseInt(scanner.nextLine());
                    Account newAccount = new Account(depositAmt);
                    existingCustomer.addAccount(newAccount);
                    System.out.println("New Account Opened: " + newAccount.getAccNum());
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    private void closeAllAccounts(){
        System.out.println("Please enter PIN");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer existingCustomer = bank.getSingleCustomer(pin);
        if (existingCustomer == null){
            System.out.println("Customer not found.");
            displayMenu();
        }else {
            bank.removeCustomer(existingCustomer);
            System.out.println("You have been removed from the bank registry ");
        }
    }
}
