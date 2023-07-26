import java.util.Scanner;

public class PasswordGenerator {
    public String generatePassword(int digit){
        String lower_cases = "qwertyuiopasdfghjklzxcvbnm";
        String upper_cases = "QWERTYUIOPASDFGHJKLZXCVBNM";

        String password = "";
        for(int i = 0; i < digit; i++){
            int rand = (int)(3 * Math.random());

            switch(rand){
                case 0:
                    password += String.valueOf((int)(10 * Math.random()));
                    break;
                case 1:
                    rand = (int)(lower_cases.length() * Math.random());
                    password += String.valueOf(lower_cases.charAt(rand));
                    break;
                case 2:
                    rand = (int)(upper_cases.length() * Math.random());
                    password += String.valueOf(upper_cases.charAt(rand));
                    break;
            }
        }
        return password;
    }
}
