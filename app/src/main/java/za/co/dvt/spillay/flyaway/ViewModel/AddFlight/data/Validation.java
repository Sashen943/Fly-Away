package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Spillay
 */

public class Validation {

    private static final String DATE = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    private static final String REFERENCE_NUMBER = "^[A-Za-z0-9]{6}";
    private static final String TIME = "^([0-1]?[0-9]|[2][0-3]):([0-5][0-9])(:[0-5][0-9])?$";
    private static final String CITY = "\\w*\\s*";

    // Validates flight reference number
    public static boolean validateFlightReferenceNumber(String referenceNumber) {
        Pattern pattern = Pattern.compile(REFERENCE_NUMBER);
        Matcher matcher = pattern.matcher(referenceNumber);
        return matcher.matches();
    }

    // Validates flight date
    public static boolean validateFlightDate(String date) {
        Pattern pattern = Pattern.compile(DATE);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    // Validates flights time
    public static boolean validateFlightTime(String time) {
        Pattern pattern = Pattern.compile(TIME);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    // Validates flights city name
    public static boolean validateCity(String city) {
        Pattern pattern = Pattern.compile(CITY);
        Matcher matcher = pattern.matcher(city);
        if (matcher.matches() && city.length() > 2) {
            return matcher.matches();
        } else {
            return matcher.matches();
        }
    }


}
