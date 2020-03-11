import console.Choose;
import dao.UserDAO;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws InterruptedException, IllegalMonitorStateException, IOException, ClassNotFoundException {
        Choose choose = new Choose();
        choose.user_choose();

    }
}
