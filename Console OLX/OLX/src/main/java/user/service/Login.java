package user.service;

import user.User;
import user.UserStorage;

import java.util.Scanner;

public class Login {

    private final Scanner sc = new Scanner(System.in);

    private UserStorage userStorage;

    public Login(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User logUser() {
        int counter = 0;

        while (counter < 3) {
            System.out.println("Login menu");

            System.out.println("Enter your Login: ");
            String login = sc.nextLine();

            System.out.println("Enter your Password: ");
            String password = sc.nextLine();

            for (User user : userStorage.getUsers()) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    System.out.println("You have logged in");
                    return user;
                }
            }
            System.out.println("The user doesn't exist");
            counter++;
        }
        return null;
    }
}

