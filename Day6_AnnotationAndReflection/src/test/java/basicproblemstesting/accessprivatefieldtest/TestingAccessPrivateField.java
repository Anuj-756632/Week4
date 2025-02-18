package basicproblemstesting.accessprivatefieldtest;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionproblems.basicproblems.accessprivatefield.Person;

public class TestingAccessPrivateField {

        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        public void testAccessAndModifyPrivateField() {
            try {
                // Create an instance of Person with initial age
                Person person = new Person(25);

                // Display initial age using the displayAge method
                System.out.println("Initial value of age:");
                person.displayAge();

                // Capture the initial output
                String initialOutput = outputStream.toString();
                outputStream.reset();

                // Get the 'age' field from the Person class using Reflection
                Field ageField = Person.class.getDeclaredField("age");

                // Make the private field accessible
                ageField.setAccessible(true);

                // Modify the value of the private 'age' field
                ageField.set(person, 30);  // Change age to 30

                // Display the modified age using the displayAge method
                System.out.println("\nModified value of age:");
                person.displayAge();

                // Capture the modified output
                String modifiedOutput = outputStream.toString();
                outputStream.reset();

                // Retrieve the value of the 'age' field and print it
                int newAge = (int) ageField.get(person);
                System.out.println("\nRetrieved value of age: " + newAge);

                // Capture the retrieved output
                String retrievedOutput = outputStream.toString();

                // Verify the initial, modified, and retrieved outputs
                String expectedInitialOutput = "Initial value of age:\nAge: 25\n";
                String expectedModifiedOutput = "\nModified value of age:\nAge: 30\n";
                String expectedRetrievedOutput = "\nRetrieved value of age: 30\n";

                assertEquals(expectedInitialOutput, initialOutput);
                assertEquals(expectedModifiedOutput, modifiedOutput);
                assertEquals(expectedRetrievedOutput, retrievedOutput);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        }

}
