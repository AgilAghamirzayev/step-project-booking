package menu;

public class UserMenu implements Menu{
    @Override
    public String show() {
        String user_menu =
                        "________________________________________\n" +
                        "|              Welcome!!!               |\n" +
                        " ---------------------------------------\n" +
                        "| 1 -> Log In                           |\n"+
                        "| 2 -> Create new account               |\n"+
                        "| 3 -> Exit                             |\n"+
                        "|_______________________________________|\n";

        return user_menu;
    }
}
