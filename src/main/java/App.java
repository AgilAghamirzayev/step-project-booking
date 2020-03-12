import console.Choose;
import dao.FlightsDAO;
import dao.UserDAO;
import models.Flights;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws InterruptedException, IllegalMonitorStateException, IOException, ClassNotFoundException {
        Choose choose = new Choose();
        FlightsDAO dao = new FlightsDAO();
        //dao.write();
        //dao.getAll();
        choose.user_choose();

    }
}
