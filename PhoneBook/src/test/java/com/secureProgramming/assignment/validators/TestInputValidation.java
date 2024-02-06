package com.secureProgramming.assignment.validators;

import com.secureProgramming.assignment.InputValidators.ValidateName;
import com.secureProgramming.assignment.InputValidators.ValidateNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInputValidation {

    @Test
    public void nameValidationNominalTest() {
        //Including names provided in the assignment doc:
        List<String> names = Arrays.asList(
                "Cher",
                "John O’Malley-Smith",
                "O’Malley, John F.",
                "Schneier, Bruce Wayne",
                "Schneier, Bruce",
                "Bruce Schneier");
        for(String str : names){
            assertTrue(ValidateName.isValidName(str), "Expected valid name: " + str);
        }
    }

    @Test
    public void nameValidationNegativeTest() {
        List<String> names = Arrays.asList(
                "select * from users;",
                "Brad Everett Samuel Smith",
                "<Script>alert(“XSS”)</Script>",
                "L33t Hacker",
                "Ron O’Henry-Smith-Barnes",
                "Ron O’’Henry");

        for (String str : names) {
            assertFalse(ValidateName.isValidName(str), "Expected invalid name format: " + str);
        }
    }

    @Test
    public void numberValidationNominalTest(){
        List<String> numbers = Arrays.asList(
                "011 1 703 111 1234",
                "12345.12345",
                "011 701 111 1234",
                "1(703)123-1234",
                "+32 (21) 212-2324",
                "+1(703)111-2121",
                "123-1234",
                "(703)111-2121",
                "12345"
        );

        for(String str : numbers){
            assertTrue(ValidateNumber.isValidNumber(str), "Expected invalid number format: " + str);
        }
    }

    @Test
    public void numberValidationNegativeTest(){
        List<String> numbers = Arrays.asList(
                "(703) 123-1234 ext 204",
                "+01 (703) 123-1234",
                "(001) 123-1234",
                "+1234 (201) 123-1234",
                //"7031111234",
                "<script>alert(“XSS”)</script>",
                "Nr 102-123-1234",
                "1/703/123/1234",
                "123"
        );

        for(String str : numbers){
            assertFalse(ValidateNumber.isValidNumber(str), "Expected invalid number format: " + str);
        }
    }
}
