import java.util.Scanner;


public class ATM {
    private UserAccount user;
    private Scanner scanner;

    public ATM(UserAccount user){
        this.user = user;
        this.scanner = new Scanner(System.in);

    }

    public void start(){
        System.out.println("Welcome to the ATM!");
        if(authenticate()){
            showMenu();
        } else {
            System.out.println("Authentication failed. !..");
        }
    }

    private boolean authenticate(){
        System.out.println("Enter Pin");
        String inputPin = scanner.nextLine();
        return user.validatePin(inputPin);
    }

    private void showMenu(){
        int choice =-1;
        while (choice != 4){
            System.out.println("\n -- ATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Current Balance: $" + user.getBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    user.deposit(deposit);
                    break;
                case 3:
                    System.out.println("Enter Amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    user.withdraw(withdraw);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }

        }
    }
}
