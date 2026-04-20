package user.service;

import org.junit.jupiter.api.Test;
import Exception.LongInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    void testLoginLengthException() {
        Exception exception = assertThrows(LongInputException.class, () -> {
            Validator.checkLengthNameCharacters("login that contains more than 20 characters");
        });
    }

    @Test
    void testPasswordLengthException() {
        Exception exception = assertThrows(LongInputException.class, () -> {
            Validator.checkLengthPasswordCharacters("password that contains more than 30 characters");
        });
    }

    @Test
    void testEmailLengthException() {
        Exception exception = assertThrows(LongInputException.class, () -> {
            Validator.checkLengthEmailCharacters("email address that contains more than 50 characters");
        });
    }
}
