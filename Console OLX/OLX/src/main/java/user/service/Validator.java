package user.service;

import Exception.LongInputException;

public class Validator {

    public static void checkLengthNameCharacters(String name) throws LongInputException {

        if (name.length() > 20) {
            throw new LongInputException("Your name contains more than 20 characters");
        }
    }

    public static void checkLengthPasswordCharacters(String password) throws LongInputException {

        if (password.length() > 30) {
            throw new LongInputException("Your password contains more than 30 characters");
        }
    }

    public static void checkLengthEmailCharacters(String email) throws LongInputException {

        if (email.length() > 50) {
            throw new LongInputException("Your email contains more than 50 characters");
        }
    }
}
