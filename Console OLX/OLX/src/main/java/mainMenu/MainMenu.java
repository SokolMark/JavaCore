package mainMenu;

import user.service.Login;
import user.service.Registration;
import user.User;
import user.userMenu.UserMenu;

import java.util.Scanner;

public class MainMenu {
    private final Scanner sc = new Scanner(System.in);

    public Registration reg;
    public Login log;
    public UserMenu userMenu;

    public MainMenu(Registration reg, Login log, UserMenu userMenu) {
        this.reg = reg;
        this.log = log;
        this.userMenu = userMenu;
    }

    public void showManeMenu() {
        while (true) {
            System.out.println("Welcome to the OLX");
            System.out.println("1. Create a new Profile");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> {
                    User currentRegUser = reg.registerNewUser();
                    if (currentRegUser == null) {
                        System.out.println("User is null");
                        break;
                    }
                    userMenu.showUserMenu(currentRegUser);
                }
                case 2 -> {
                    User currentLogUser = log.logUser();
                    if (currentLogUser == null) {
                        System.out.println("You wasted 3 attempts to log in.");
                        break;
                    }
                    userMenu.showUserMenu(currentLogUser);
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
