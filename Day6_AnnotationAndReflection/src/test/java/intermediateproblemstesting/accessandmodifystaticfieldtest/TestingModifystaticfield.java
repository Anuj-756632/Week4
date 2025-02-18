package intermediateproblemstesting.accessandmodifystaticfieldtest;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.internal.Configuration;

public class TestingModifystaticfield {

        @BeforeEach
        public void setUp() throws NoSuchFieldException, IllegalAccessException {
            // Reset the API_KEY to its default value before each test
            Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            apiKeyField.set(null, "default_api_key");
        }

        @Test
        public void testModifyStaticField() {
            try {
                // Get the Class object for Configuration class
                Class<?> configClass = Configuration.class;

                // Get the private static field 'API_KEY'
                Field apiKeyField = configClass.getDeclaredField("API_KEY");

                // Make the private static field accessible
                apiKeyField.setAccessible(true);

                // Modify the value of the static field 'API_KEY'
                apiKeyField.set(null, "new_api_key_12345");  // 'null' because it's a static field

                // Capture the output of the displayAPIKey method
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
//                Configuration.displayAPIKey();
                String output = outputStream.toString().trim();

                // Verify that the API_KEY is modified correctly
                assertEquals("API Key: new_api_key_12345", output);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        }

}
