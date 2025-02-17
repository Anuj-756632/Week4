package extractionproblems.extractlinkfromtext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFromText {

    // Method to extract links from a web page
    public static void extractLinks(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string
        String text = "Visit https://www.google.com and http://example.org for more info.";
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
        String regex = "https?://(www\\.)?([a-zA-Z0-9.-]+)";
        // Calling method extractLinks
        extractLinks(regex);
    }
}
