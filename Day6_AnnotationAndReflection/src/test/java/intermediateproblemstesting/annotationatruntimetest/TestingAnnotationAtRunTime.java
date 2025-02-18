package intermediateproblemstesting.annotationatruntimetest;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflectionproblems.intermediateproblems.retrieveannotationatruntime.Author;

import java.awt.print.Book;

public class TestingAnnotationAtRunTime {
        @Test
        public void testAnnotationRetrieval() {
            try {
                // Get the class object of the Book class
                Class<?> bookClass = Book.class;

                // Check if the @Author annotation is present on the class
                assertTrue(bookClass.isAnnotationPresent(Author.class), "Book class should have @Author annotation");

                // Retrieve the @Author annotation
                Author authorAnnotation = bookClass.getAnnotation(Author.class);

                // Retrieve the 'name' element from the annotation
                String authorName = authorAnnotation.name();

                // Verify the annotation value (author's name)
                assertEquals("John Doe", authorName, "Author name should be 'John Doe'");

            } catch (Exception e) {
                fail("Exception occurred: " + e.getMessage());
            }
        }
}
