package basicproblemstesting.dynamicallycreateobjecttest;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestingCreateObject {

        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        public void testCreateObjectUsingReflection() {
            try {
                // Load the Student class dynamically using Reflection
                Class<?> studentClass = Class.forName("Student");

                // Get the constructor of the Student class that takes a String and an int as parameters
                Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

                // Create a new instance of Student dynamically using the constructor
                Object studentInstance = constructor.newInstance("John Doe", 20);

                // Call the displayInfo method on the dynamically created object
                studentClass.getMethod("displayInfo").invoke(studentInstance);

                // Verify that the output is as expected
                String expectedOutput = "Name: John Doe\nAge: 20\n";
                assertEquals(expectedOutput, outputStream.toString());

            } catch (Exception e) {
                fail("Exception occurred: " + e.getMessage());
            }
        }

}
