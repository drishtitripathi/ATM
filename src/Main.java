import java.util.Scanner;
//class to represent the user's bank account
class BankAccount {
    private long balance;
    public BankAccount(long initialBalance) {
        balance = initialBalance;
    }
    public void checkBalance(){
        System.out.println("Your current balance is "+balance);
    }
    public void deposit(long amount){
        if (amount>0){
            balance += amount;
            System.out.println("Transaction Complete");
        }else {
            System.out.println("Invalid Deposit amount");
        }
    }
    public void withdraw(long amount){
        if (balance>=amount && amount>0){
            balance -= amount;
            System.out.println("Transaction Complete");
        }else if(balance<amount) {
            System.out.println("Withdrawal failed because your current balance is less than the withdrawal amount");
        }else {
            System.out.println("Invalid withdrawal amount");
        }
    }
}
//class to represent the ATM machine
class ATM {
    BankAccount account = new BankAccount(1000);
    void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter amount to withdraw");
                    long amount = sc.nextLong();
                    account.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter amount to deposit");
                    amount = sc.nextLong();
                    account.deposit(amount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thanks for using ATM");
                    System.exit(0);
                default:
                    System.out.println("invalid input");
            }
        }
    }
}
 public class Main {
    public static void main(String[] args) {
       ATM atm = new ATM();
       atm.menu();
    }
 }