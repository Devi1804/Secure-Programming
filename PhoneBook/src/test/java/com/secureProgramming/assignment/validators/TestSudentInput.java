package com.secureProgramming.assignment.validators;

import com.secureProgramming.assignment.InputValidators.ValidateName;
import com.secureProgramming.assignment.InputValidators.ValidateNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSudentInput {

    @Test
    public void validNameTest() {
        List<String> valid = Arrays.asList(
                "Bruce Schneier",
                "Robert, Patricia",
                "Christopher O’Daniel-Joseph",
                "Paul");


        for (String str : valid) {
            assertTrue(ValidateName.isValidName(str), "Expected valid name: " + str);
        }

    }

    @Test
    public void invalidNameTest(){
        List<String> inValid = Arrays.asList(
                "1234 James",
                "O’’Malley, Thomas."
        );

        for (String str : inValid) {
            assertFalse(ValidateName.isValidName(str), "Expected valid name: " + str);
        }
    }

    @Test
    public void validNumberTest() {
        List<String> valid = Arrays.asList(
                "+1(703)111-2121",
                "+32 (21) 212-2324",
                "12345.12345"
        );

        for (String str : valid) {
            assertTrue(ValidateNumber.isValidNumber(str), "Expected valid number: " + str);
        }
    }

    @Test
    public void invalidNumberTest() {
        List<String> inValid = Arrays.asList(
                "Nr 102-123-1234",
                "123 TEST",
                "+1234 (201) 123-1234",
                "(001) 123-1234",
                "(703) 123-1234 ext 204");

        for (String str : inValid) {
            assertFalse(ValidateNumber.isValidNumber(str), "Expected valid number: " + str);
        }
    }
}
