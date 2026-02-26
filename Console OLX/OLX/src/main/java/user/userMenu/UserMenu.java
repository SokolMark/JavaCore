package user.userMenu;

import user.User;
import user.UserStorage;

import java.util.Scanner;

public class UserMenu {
    private final Scanner sc = new Scanner(System.in);

    UserStorage userStorage;

    public UserMenu(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void showUserMenu(User user) {

        while (true) {
            System.out.println("Hello " + user.getLogin());

            System.out.println("1. - Search items");
            System.out.println("2. - Take a look into your cart");
            System.out.println("3. - Create an advertisement");
            System.out.println("4. - Your Profile");
            System.out.println("5. - Log out");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: return;
            }

        }
    }
}
