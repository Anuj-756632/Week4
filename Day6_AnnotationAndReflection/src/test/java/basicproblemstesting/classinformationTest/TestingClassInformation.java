package basicproblemstesting.classinformationTest;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestingClassInformation {

        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        public void testClassInformation() {
            String className = "java.util.ArrayList";  // Example class name

            try {
                // Load the class using reflection
                Class<?> clazz = Class.forName(className);

                // Display the class name
                System.out.println("Class Name: " + clazz.getName());

                // Display the constructors
                System.out.println("\nConstructors:");
                Constructor<?>[] constructors = clazz.getConstructors();
                for (Constructor<?> constructor : constructors) {
                    System.out.println(constructor);
                }

                // Display the fields
                System.out.println("\nFields:");
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    System.out.println(field);
                }

                // Display the methods
                System.out.println("\nMethods:");
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    System.out.println(method);
                }

                // Capture the output
                String output = outputStream.toString();

                // Verify the class name is displayed correctly
                assertTrue(output.contains("Class Name: " + className));

                // Verify constructors are displayed
                assertTrue(output.contains("Constructors:"));

                // Verify fields are displayed
                assertTrue(output.contains("Fields:"));

                // Verify methods are displayed
                assertTrue(output.contains("Methods:"));

            } catch (ClassNotFoundException e) {
                fail("Class not found: " + e.getMessage());
            }
        }
}
