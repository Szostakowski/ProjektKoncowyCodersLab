package pages;

import java.util.Arrays;
import java.util.List;

public class UserLogInPage {

    static List<String> usersLog = Arrays.asList
            ("rafal.szostakowski@gmail.com", "ed@gmail.com", "edi@gmail.com", "edd@gmail.com");

    public static String getUserLog() {
        int u = 0;
        System.out.println("logowanie dla: "+usersLog.get(u));
        return usersLog.get(u);
    }

}


