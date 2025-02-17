package extractionproblems.extractemailedressfromtext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractEmails {

    // Method to extract all email addresses from a text
    public static void extractEmailAddresses(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string to extract email addresses
        String text = "Contact us at support@example.com and info@company.org";
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
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        // Calling method extractEmailAddresses
        extractEmailAddresses(regex);
    }
}
