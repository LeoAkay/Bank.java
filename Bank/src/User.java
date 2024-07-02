public class User {
    private String name;
    private int accountID;
    private double balance;
    private String currency;

    public User(String name,int accountID,double balance,String currency){
        this.name=name;
        this.accountID=accountID;
        this.balance=balance;
        this.currency=currency;
    }
    public String getName(){
        return name;
    }
    public int getAccountID(){
        return accountID;
    }
    public double getBalance(){
        return  balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public String getCurrency(){
        return currency;
    }
}
