
import java.util.Scanner;

public class Account {
    private int accNum;
    private int balance;
    private static int numOfAc = 1000;
    private Scanner scnr = new Scanner(System.in);

    public void deposit(){
        System.out.println("Please enter deposit amount");
        int depositAmt = Integer.parseInt(scnr.nextLine());
        if (depositAmt >= 0){
            balance += depositAmt;
            System.out.println("You have deposited " + "$"+ depositAmt);
            System.out.println("You now have a balance of " + "$" + balance);
        }else {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
        }
    }
    public void withdraw(){
        System.out.println("Enter the amount of withdrawal");
        int withdrawAmt = Integer.parseInt(scnr.nextLine());

        if (withdrawAmt > balance){
            System.out.println("You have insufficient funds");
        }else {
            balance -= withdrawAmt;
            System.out.println("You have withdrawn " + "$" + withdrawAmt);
            System.out.println("You now have a balance of " + "$" + balance);
        }
    }

    @Override
    public String toString(){
        return String.format("Account Number: %d\nBalance: $%d\n", accNum, balance);
    }
    public Account(int depositAmt){
        if (depositAmt >= 0) {
            balance = depositAmt;
            accNum = numOfAc++;
        } else {
            System.out.println("Invalid initial deposit amount. Please enter a positive number.");
        }

    }

    public int getAccNum() {
        return accNum;
    }

    public int getBalance() {
        return balance;
    }
}
