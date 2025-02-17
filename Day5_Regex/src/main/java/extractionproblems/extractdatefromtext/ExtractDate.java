package extractionproblems.extractdatefromtext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraxctDate {
    // Method to extract all dates from a text
    public static void extractDates(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string to extract dates
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        // Create matcher object
        Matcher matcher = pattern.matcher(text);
        // Find matches
        while(matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
    // Main method
    public static void main(String[] args)
    {
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        // Calling method extractEmailAddresses
        extractDates(regex);
    }
}
