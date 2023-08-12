/*
 * Validation Class
 * Author: Alejo Rostata
 * Description: This class provides validation logic for the fields in a CSV file. It performs checks for id, name,
 * birthday, gender, and phone number based on specific rules. If the validation fails, appropriate error messages
 * are returned. If validation passes, the original value is returned.
 */

import java.util.regex.Pattern;

public class Validation {

    //Based on the outline, we only have 3 different error message. It's better to put it into string array.
    private static final String[] validationErrors = {
            "Error required",
            "Error limit over",
            "Error format"
    };

    //I usually used lambda, it's beautiful, short and clean.
    public static String validateField(int index, String value) {
        return switch (index) {
            case 0 -> // id
                    value.matches("\\d+") ? value : validationErrors[2];
            case 1 -> { // name
                if (value.isEmpty())
                    yield validationErrors[0];
                yield value.length() > 100 ? validationErrors[1] : value;
            }
            case 2 -> { // birthday
                if (value.isEmpty())
                    yield validationErrors[0];
                yield Pattern.matches("\\d{4}(/|-)\\d{2}(/|-)\\d{2}", value) ? value : validationErrors[2];
            }
            case 3 -> // gender
                    (!value.isEmpty() && value.matches("(?i)male|female")) ? value : validationErrors[2];
            case 4 -> { // phone-number
                if (value.isEmpty())
                    yield validationErrors[0];
                yield Pattern.matches("\\d{3}(-|\\s)?\\d{3,4}(-|\\s)?\\d{4}|\\d{4}-\\d{2}-\\d{4}|\\d{10,11}", value) ? value : validationErrors[2];
            }
            default -> value;
        };
    }
}
