package advancedproblems.extractprogramminglanguagenames;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Creating class ExtractLanguagesFromText to extract all programming language names from a text
public class ExtractProgrammingLanguageNamesFromText
{
    // Method to extract all programming language names from a text
    public static void extractLanguages(String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        // Input text string
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
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
        String regex = "\\b(C\\+\\+|Java|Python|JavaScript|Go|C#|Ruby|Swift|Kotlin|PHP|HTML|CSS)\\b";
        // Calling method extractLanguages
        extractLanguages(regex);
    }
}
