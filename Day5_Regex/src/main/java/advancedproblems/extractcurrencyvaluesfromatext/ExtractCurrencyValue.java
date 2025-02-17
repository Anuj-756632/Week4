package advancedproblems.extractcurrencyvaluesfromatext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValue {

    // Method to extract currency values
    public static void extractCurrencyValues(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string
        String text = "The price is $45.99, and the discount is 10.50.";
        // Create matcher object
        Matcher matcher = pattern.matcher(text);
        // Find matches
        while (matcher.find())
        {
            System.out.println(matcher.group());
        }
    }

    // Main method
    public static void main(String[] args)
    {
        String regex = "\\$?\\d+\\.\\d{2}";
        // Calling method extractCurrencyValues
        extractCurrencyValues(regex);
    }
}
