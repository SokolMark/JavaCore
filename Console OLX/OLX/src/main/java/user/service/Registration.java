package user.service;

import user.User;
import user.UserStorage;
import Exception.LongInputException;

import java.util.Scanner;

public class Registration {

    private final Scanner sc = new Scanner(System.in);

    private final UserStorage userStorage;

    public Registration(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User registerNewUser() {

        System.out.println("Registration");

        String name;
        String password;
        String email;

        while (true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            try {
                Validator.checkLengthNameCharacters(name);
                break;
            } catch (LongInputException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();

        while (true) {
            System.out.print("Enter your password: ");
            password = sc.nextLine();
            try {
                Validator.checkLengthPasswordCharacters(password);
                break;
            } catch (LongInputException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();

        while (true) {
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            try {
                Validator.checkLengthEmailCharacters(email);
                break;
            } catch (LongInputException e) {
                System.out.println(e.getMessage());
            }
        }

        User user = new User(name, password, email);

        userStorage.addUser(user);

        System.out.println("You have successfully registered: " + userStorage.getUsers());

        return user;
    }
}
