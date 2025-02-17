package advancedproblems.findrepeatingwordsinasentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatWordsInSentence {

    // Method to find repeating words
    public static void findRepeatingWords(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string
        String text = "This is is a repeated repeated word test.";
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
        String regex = "\\b(\\w+)\\s+\\1\\b";
        // Calling method findRepeatingWords
        findRepeatingWords(regex);
    }
}
