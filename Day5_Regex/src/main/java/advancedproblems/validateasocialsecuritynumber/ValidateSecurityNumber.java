package advancedproblems.validateasocialsecuritynumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSecurityNumber {

    // Method to validate SSN
    public static void validateSSN(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string
        String text1 = "My SSN is 123-45-6789";
        // Create matcher objects
        Matcher matcher1 = pattern.matcher(text1);
        // Check if SSNs are valid
        if (matcher1.find())
        {
            System.out.println("SSN is valid");
        }
        else
        {
            System.out.println("SSN is invalid");
        }
    }
    // Main method
    public static void main(String[] args)
    {
        String regex = "\\d{3}-\\d{2}-\\d{4}";
        // Calling method validateSSN
        validateSSN(regex);
    }
}
