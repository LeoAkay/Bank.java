public class ATM extends Main {
    User user;

    ATM(User user){
        this.user=user;
    }
    public void Check_balance(){
        System.out.println(user.getBalance()+" "+user.getCurrency()+" Available in your account.");
    }
    public void cashDeposit(){
        System.out.println("Enter the deposited amount: ");
        double amount=input.nextDouble();
        if(amount>0){
            user.setBalance(user.getBalance()+amount);
            System.out.println("Your current balance is: "+user.getBalance()+" "+user.getCurrency());
        }else{
            System.out.println("You have entered wrong amount!");
        }

    }
    public void Withdraw(double amount){
        if(amount<=user.getBalance()){
            user.setBalance(user.getBalance()-amount);
            System.out.println("The withdrawn amount is: "+amount+" "+user.getCurrency());
            System.out.println("Current balance is: "+user.getBalance()+" "+user.getCurrency());
        }
        else{
            System.out.println("You have entered invalid amount");
        }
    }
}
