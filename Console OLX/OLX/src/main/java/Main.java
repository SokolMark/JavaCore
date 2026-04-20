import Product.ProductMenu;
import Product.ProductStorage;
import mainMenu.MainMenu;
import user.service.Login;
import user.service.Registration;
import user.UserStorage;
import user.userMenu.UserMenu;

public class Main {
    public static void main(String[] args) {
        UserStorage userStorage = new UserStorage();

        Registration reg = new Registration(userStorage);
        Login log = new Login(userStorage);

        ProductStorage storage = new ProductStorage();
        ProductMenu productMenu = new ProductMenu(storage);

        UserMenu userMenu = new UserMenu(userStorage, productMenu);

        MainMenu mainMenu = new MainMenu(reg, log, userMenu);

        mainMenu.showManeMenu();
    }
}
