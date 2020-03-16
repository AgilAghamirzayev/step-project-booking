package console;

public class UserMenu implements Menu{
    @Override
    public String show() {

        return "________________________________________\n" +
        "|              Welcome!!!               |\n" +
        " ---------------------------------------\n" +
        "| 1 -> Log In                           |\n"+
        "| 2 -> Create new account               |\n"+
        "| 3 -> Exit                             |\n"+
        "|_______________________________________|\n";
    }
}
