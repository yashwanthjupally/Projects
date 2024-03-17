import java.util.Scanner;

class ATM{
    float Balance;
    int PIN = 5624;
    int max_attempts = 3;
    int incorrect = 0;

    public void checkPin(){
        while(incorrect < max_attempts) {
            System.out.println("Enter your Pin: ");
            Scanner sc = new Scanner(System.in);
            int EnteredPin = sc.nextInt();
            if (EnteredPin == PIN) {
                menu();
            } else {
                incorrect += 1;
                System.out.println("Please Enter the correct Pin");
            }
        }
    }
    public void menu(){
        System.out.println("Enter your choice: ");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
           balance();
        }
        else if (opt == 2) {
            withdraw();
        }
        else if (opt == 3) {
            deposit();
        }
        else if (opt == 4) {
            System.exit(0);
        }
        else{
            System.out.println("Enter a valid choice");
        }
    }

    public void balance() {
        System.out.println("Balance: " + Balance);
        menu();
    }
    public void withdraw() {
        System.out.println("Enter the amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        if(amount > Balance){
            System.out.println("Insufficient funds");
        }
        else{
            Balance = Balance - amount;
            System.out.println("Money withdraw successfully");
        }
        menu();
    }
    public void deposit() {
        System.out.println("Enter the amount: ");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        Balance = Balance + amount;
        System.out.println("Money deposited successfully");
        menu();
    }
}


public class Main {
    public static void main(String[] args) {

        ATM obj = new ATM();
        obj.checkPin();
    }
}