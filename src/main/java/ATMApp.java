import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ATMApp {
    public static void main(String[] args){
        //Create a test user
        //UserAccount user1 = new UserAccount("1234567890", "1234", 1000.00);

        try{
            Gson gson = new Gson();
            InputStream inputStream = ATMApp.class.getClassLoader().getResourceAsStream("accounts.json");
            if (inputStream == null){
                System.out.println("acounts.json file not found!");
                return;
            }
            Reader reader = new InputStreamReader(inputStream);
            UserAccount user = gson.fromJson(reader, UserAccount.class);
            reader.close();

            ATM atm = new ATM(user);
            atm.start();
        } catch (Exception e){
            System.out.println("Enter Loading account data: " + e.getMessage());
        }



//        ATM atm = new ATM(user1);
//        atm.start();
    }
}
