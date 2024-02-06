package com.secureProgramming.assignment.InputValidators;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateNumber {

    private static final List<Pattern> PATTERNS = Arrays.asList(
            Pattern.compile("^([1-9]{1}[0-9]{2}[- .]?){2}\\d{4}$"),
            Pattern.compile("^((\\([1-9]{1}[0-9]{2}\\))|[1-9]{1}[0-9]{2})[- .]?\\d{3}[- .]?\\d{4}$"),
            Pattern.compile("^\\d{1}((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"),
            Pattern.compile("^(\\+[1-9]{1}[0-9]?[0-9]?( )?){1}((\\(\\d{2,3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"),
            Pattern.compile("^(\\d{5}[.]?)\\d{5}$"),
            Pattern.compile("^\\d{5}$"),
            Pattern.compile("^([0][1][1])[- .][1]?[- .]?(\\d{3}[- .]?){2}\\d{4}$"),
            Pattern.compile("^([0][0])[- .][1]?[- .]?(\\d{3}[- .]?){2}\\d{4}$"),
            Pattern.compile("^(\\d{3}[-]?)\\d{4}$"),
            Pattern.compile("^\\d{10}$"),
            // North American phone numbers
            Pattern.compile("^(1[ -.])?([2-9][0-9]{2})([ -.])?([2-9][0-9]{2})([ -.])?([0-9]{4})$"),

            // Danish phone numbers
            Pattern.compile("^(\\+?45)?([0-9]{2})([ -.]?)?([0-9]{2})([ -.]?)?([0-9]{2})([ -.]?)?([0-9]{2})$"),

            // 10 digits in two groups of five separated by space or dot
            Pattern.compile("^([2-9][0-9]{4})([ -.])?([0-9]{5})$")
    );
    public static boolean isValidNumber(String phone) {
        for(Pattern pattern : PATTERNS){
            Matcher matcher = pattern.matcher(phone);
            if(matcher.matches()) {
                return true;
            }
        }

        System.err.println("Invalid Phone number format!");
        return false;
    }
}
