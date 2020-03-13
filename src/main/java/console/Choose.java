package console;

import menu.BookingMenu;
import menu.UserMenu;
import java.util.Scanner;

public class Choose {
    BookingMenu booking_menu = new BookingMenu();
    UserMenu userMenu = new UserMenu();
    Core core = new Core();

    public void booking_choose()  {
        boolean exit = true;
        while (exit) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(booking_menu.show());
                int a = scanner.nextInt();
                switch (a) {
                    case 1:
                        core.showTimetable();
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
                        scanner.close();
                        exit = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Enter a valid command: " + a);
                }
            } catch (Exception e){
                System.out.println("Choose only possible command");
            }

        }
    }

    public void user_choose() {
        boolean exit = true;
            while (exit) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println(userMenu.show());
                    int a = scanner.nextInt();
                    switch (a) {
                        case 1:
                            core.login();
                            break;
                        case 2:
                            core.createNewAccount();
                            break;
                        case 3:
                            scanner.close();
                            exit = false;
                            break;
                        default:
                            throw new IllegalArgumentException("Enter a valid order: " + a);
                    }
                }  catch (Exception e){
                    System.out.println("Choose only possible command");
                }
            }
    }
}
