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

    BookingMenu booking_menu = new BookingMenu();
    UserMenu userMenu = new UserMenu();

    public void booking_choose()  {
        boolean exit = false;
            while (!exit) {
                System.out.println(booking_menu.show());
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
                        user_choose();
                        break;
                    default:
                        System.out.println("Choose only possible command");
                }
            }
}

    public void user_choose() {
        boolean exit = false;
        while (!exit) {
                System.out.println(userMenu.show());
                String  a = scanner.nextLine();
                switch (a) {
                    case "1":
                        if (userController.login()) {
                            booking_choose();
                        } else {
                            user_choose();
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
