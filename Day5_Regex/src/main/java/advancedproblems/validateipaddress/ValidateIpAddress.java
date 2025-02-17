package advancedproblems.validateipaddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIpAddress {

    // Method to validate IP Address
    public static String validateIPAddress(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input string to check
        String input = "176.16.17.32";
        String[] parts = input.split("\\.");
        // Create matcher object
        Matcher matcher = pattern.matcher(input);
        // Find matches
        if(!matcher.matches())
        {
            return "InValid IP Address";
        }
        for(String part : parts)
        {
            int num = Integer.parseInt(part);
            if(num < 0 || num > 255)
            {
                return "Invalid IP Address";
            }
        }
        return "Valid IP Address";
    }
    // Main method
    public static void main(String[] args)
    {
        // Define the regex pattern
        String regex = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$";
        // Calling method validateUserName
        String result = validateIPAddress(regex);
        System.out.println(result);
    }
}
