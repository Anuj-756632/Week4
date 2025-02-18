package reflectionproblems.intermediateproblems.retrieveannotationatruntime;

import java.lang.annotation.*;
import java.lang.reflect.*;

import java.lang.annotation.*;

// Define the @Author annotation
@Retention(RetentionPolicy.RUNTIME)  // Ensure the annotation is available at runtime
@Target(ElementType.TYPE)
public// This annotation is applicable to classes only
@interface Author {
    String name();  // Define a single attribute 'name' for the author
}
// Apply the @Author annotation to the class
@Author(name = "John Doe")
class Book {
    // Some fields and methods related to the book
    public void displayInfo() {
        System.out.println("This is a book class.");
    }
}

public class AnnotationAtRunTime {

        public static void main(String[] args) {
            try {
                // Get the class object of the Book class
                Class<?> bookClass = Book.class;

                // Check if the @Author annotation is present on the class
                if (bookClass.isAnnotationPresent(Author.class)) {
                    // Retrieve the @Author annotation
                    Author authorAnnotation = bookClass.getAnnotation(Author.class);

                    // Retrieve the 'name' element from the annotation
                    String authorName = authorAnnotation.name();

                    // Display the annotation value (author's name)
                    System.out.println("Author Name: " + authorName);
                } else {
                    System.out.println("No @Author annotation present.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
