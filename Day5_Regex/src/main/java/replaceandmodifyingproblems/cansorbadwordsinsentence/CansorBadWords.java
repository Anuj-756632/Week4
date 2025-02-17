package replaceandmodifyingproblems.cansorbadwordsinsentence;

public class CansorBadWords {
        // Method to replace bad words
        public static void censorBadWords(String text)
        {
            String regexOfBadWords = "\\b(damn|stupid)\\b";
            String replacedText = text.replaceAll(regexOfBadWords, "****");
            System.out.println("Original Text :- " + text);
            System.out.println("\nAfter Censoring Bad Words Text is :- " + replacedText);
        }
        // Main method
        public static void main(String[] args)
        {
            // Input text string
            String text = "This is a damn bad example with some stupid words.";
            // Calling method censorBadWords
            censorBadWords(text);
        }

}
