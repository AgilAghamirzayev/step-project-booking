package console;

import dao.UserDAO;
import menu.BookingMenu;
import menu.UserMenu;

import java.io.IOException;
import java.util.Scanner;

public class Choose {
    UserDAO userDAO = new UserDAO();
    BookingMenu booking_menu = new BookingMenu();
    UserMenu userMenu = new UserMenu();
    Core core = new Core();


    public void booking_choose() throws InterruptedException, IOException, ClassNotFoundException {
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(booking_menu.show());
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("===================================     TIMETABLE    =======================================");
                    System.out.println("| ID|  |       AIRLINES       |  |  FLY FROM  |  |   FLY TO   |  |   DATE-TIME    |  |SEATS|");
                    System.out.println("============================================================================================");
                    core.showTimetable();
                    System.out.println("============================================================================================");
                    break;
                case 2:
                    core.searchFlight();
                    break;
                case 3:
                    core.makeBooking();
                    break;
                case 4:
                    core.showMyBooking();
                    break;
                case 5:
                    core.cancelMyBooking();
                    break;
                case 6:
                    user_choose();
                    break;
                case 7:
                    exit = false;

                    break;
                default:
                    System.out.println("Choose valid order");
                    booking_choose();
            }
        }
    }

    public void user_choose() throws InterruptedException, IOException, ClassNotFoundException {
        boolean exit = true;
            while (exit) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(userMenu.show());
                switch (scanner.nextInt()) {
                    case 1:
                        core.login();
                        userDAO.getUsers().forEach(System.out::println);
                        booking_choose();
                        exit=false;
                        break;
                    case 2:
                        core.createNewAccount();
                        userDAO.getUsers().forEach(System.out::println);
                        break;
                    case 3:
                        exit=false;
                        break;
                    default:
                        System.out.println("Choose valid order");
                        user_choose();
                }
            }
    }
}
