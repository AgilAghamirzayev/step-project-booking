package console;

import controller.BookingController;
import controller.FlightsController;
import controller.UserController;
import dao.FlightsDAO;
import service.FlightsService;
import java.util.Scanner;

public class Core{

    private static Scanner scanner = new Scanner(System.in);

    UserController userController = new UserController();
    FlightsDAO flightsDAO = new FlightsDAO();
    FlightsService flightsService = new FlightsService(flightsDAO);
    FlightsController flightsController = new FlightsController(flightsService);
    BookingController bookingController = new BookingController(flightsController,userController);

    BookingMenu bookingMenu = new BookingMenu();
    UserMenu userMenu = new UserMenu();

    public void bookingChoose()  {
        boolean exit = false;
            while (!exit) {
                System.out.println(bookingMenu.show());
                String a = scanner.nextLine();
                switch (a) {
                    case "1":
                        flightsController.showTimetable();
                        break;
                    case "2":
                        flightsController.search();
                        break;
                    case "3":
                        bookingController.makeBooking();
                        break;
                    case "4":
                        bookingController.showMyBooking();
                        break;
                    case "5":
                        bookingController.cancelBooking();
                        break;
                    case "6":
                        exit=true;
                        userChoose();
                        break;
                    default:
                        System.out.println("Choose only possible command");
                }
            }
}

    public void userChoose() {
        boolean exit = false;
        while (!exit) {
                System.out.println(userMenu.show());
                String  a = scanner.nextLine();
                switch (a) {
                    case "1":
                        if (userController.login()) {
                            bookingChoose();
                        } else {
                            userChoose();
                        }
                        break;
                    case "2":
                        userController.register();
                        break;
                    case "3":
                        System.out.println("Thanks for using my app :). See you see");
                        exit = true;
                        break;
                    default:
                        System.out.println("Choose only possible command");
                }
            }

    }

}
