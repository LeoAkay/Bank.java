import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Bank extends Main {
    HashMap<Integer,User> account = new HashMap<>();
    String name;
    private int generateID(){
        int min = 10000, max = 99999;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public void run() {

        while (true) {
            System.out.println("Welcome to EMUBank");
            System.out.println("Are you a new customer? If yes press Y else press N.");
            char exscust = input.next().charAt(0);
            if (exscust == 'Y') {
                System.out.println("Please enter your name: ");
                name = input.next();
                int id=generateID();
                System.out.println("Your account number is: " + id);
                System.out.print("Enter your initial balance: ");
                double amount = input.nextDouble();
                System.out.print("Enter currency: ");
                String currency = input.next();
                User user=new User(name,id,amount,currency);
                account.put(id, user);
                System.out.println("Account created successfully!");
            }

            System.out.println("To log-in enter your accountID: ");
            int accountid = input.nextInt();
            User existing_user= account.get(accountid);
            if (account.containsKey(accountid)) {
                System.out.println("Welcome " + existing_user.getName());
                System.out.println("Your current balance: "+existing_user.getBalance()+existing_user.getCurrency());
                System.out.println("For Cash Withdraw press 2 and For Cash Deposit press 3.\nPress 0 to Exit!\nEnter operation number: ");
                int op = input.nextInt();
                ATM atm1 = new ATM(existing_user);
                while (true) {
                    if (op == 1) {
                        atm1.Check_balance();
                        System.out.println("Would you like to continue? \npress 1 for Checking balance, press 2 for withdraw money and press 3 for deposit.\nPress 0 to Exit!");
                        op = input.nextInt();
                    }
                    if (op == 2) {
                        System.out.print("Please enter the desired withdraw amount: ");
                        double amount1 = input.nextDouble();
                        atm1.Withdraw(amount1);
                        System.out.println("Would you like to continue? \npress 1 for Checking balance, press 2 for withdraw money and press 3 for deposit.\nPress 0 to Exit!");
                        op = input.nextInt();
                    }
                    if (op == 3) {
                        atm1.cashDeposit();
                        System.out.println("Would you like to continue? \npress 1 for Checking balance, press 2 for withdraw money and press 3 for deposit.\nPress 0 to Exit!");
                        op = input.nextInt();
                    } else run();
                }
            }
        }
    }
}