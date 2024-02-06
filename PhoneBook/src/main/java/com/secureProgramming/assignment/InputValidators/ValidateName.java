package com.secureProgramming.assignment.InputValidators;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateName {

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[A-Z]([a-zA-Z]*?\\’?[a-zA-Z]+?\\,?[ ]?\\-?\\.?){1,3}$"
    );

    public static boolean isValidName(String name) {
        Matcher nameMatcher = NAME_PATTERN.matcher(name);
        boolean validName = nameMatcher.matches();

        if (!validName) {
            System.err.println("Invalid Name format!");
        }

        return validName;
    }
}
