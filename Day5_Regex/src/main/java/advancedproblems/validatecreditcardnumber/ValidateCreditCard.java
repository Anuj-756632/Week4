package advancedproblems.validatecreditcardnumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCard {
    // Method to validate Credit Card Number For Visa
    public static String validateCreditCardNumberForVisa(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input string to check
        String input = "4234 1234 1234 1234";
        // Create matcher object
        Matcher matcher = pattern.matcher(input);
        // Find matches
        if(!matcher.matches())
        {
            return "Invalid Visa Credit Card Number";
        }
        return "Valid Visa Credit Card Number";
    }

    // Method to validate Credit Card Number For Master Card
    public static String validateCreditCardNumberForMasterCard(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input string to check
        String input = "5235 1234 1234 1234";
        // Create matcher object
        Matcher matcher = pattern.matcher(input);
        // Find matches
        if(!matcher.matches())
        {
            return "Invalid MasterCard Credit Card Number";
        }
        return "Valid MasterCard Credit Card Number";
    }
    // Main method
    public static void main(String[] args)
    {
        // Define the regex pattern for Visa
        String regexForVisa = "^([4][0-9]{3}\\ ){1}([0-9]{4}\\ ){2}[0-9]{4}$";
        // Calling method validateCreditCardNumberForVisa
        String result1 = validateCreditCardNumberForVisa(regexForVisa);
        System.out.println(result1);

        // Define the regex pattern for MasterCard
        String regexForMasterCard = "^([5][0-9]{3}\\ ){1}([0-9]{4}\\ ){2}[0-9]{4}$";
        // Calling method validateCreditCardNumberForMasterCard
        String result2 = validateCreditCardNumberForMasterCard(regexForMasterCard);
        System.out.println(result2);
    }
}
