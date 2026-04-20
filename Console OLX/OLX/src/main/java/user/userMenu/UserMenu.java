package user.userMenu;

import Product.ProductMenu;
import user.User;
import user.UserStorage;

import java.util.Scanner;

public class UserMenu {
    private final Scanner sc = new Scanner(System.in);

    UserStorage userStorage;
    ProductMenu productMenu;

    public UserMenu(UserStorage userStorage, ProductMenu productMenu) {
        this.userStorage = userStorage;
        this.productMenu = productMenu;
    }


    public void showUserMenu(User user) {

        while (true) {
            System.out.println("Hello " + user.getLogin());

            System.out.println("1. - Search items");
            System.out.println("2. - Take a look into your cart");
            System.out.println("3. - Create an advertisement");
            System.out.println("4. - Delete an advertisement");
            System.out.println("5. - Your Profile");
            System.out.println("6. - Log out");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    productMenu.createProduct();
                    break;
                case 4:
                    productMenu.removeProduct();
                    break;
                case 5:
                    return;
            }

        }
    }
}
