
public class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    //constructor

    public Account(String accountNumber, String pin, double balance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    //Getter method

    public String AccountNumber(){
        return accountNumber;
    }

    public boolean validatePin(String inputPin){
        return this.pin.equals(inputPin);
    }

    public double getBalance(){
        return balance;
    }

    //Business Logic
    public void deposit(double amount){
        if (amount >0){
            balance +=amount;
            System.out.println("Deposit Successful . New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }

    }

    public void withdraw(double amount){
        if (amount >0 && amount <= balance){
            balance -=amount;
            System.out.println("Withdrawal successful. New Balance: $" + balance);

        }else {
            System.out.println("Insufficient balance or invalid amount ");
        }
    }


}


