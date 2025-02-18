package reflectionproblems.intermediateproblems.accessandmodifystaticfield;

import java.lang.reflect.Field;
class Configuration {

    // Private static field
    private static String API_KEY = "default_api_key";

    // Method to display the current API_KEY value
    public static void displayAPIKey() {
        System.out.println("API Key: " + API_KEY);
    }
}
public class ModifyStaticField {

        public static void main(String[] args) {
            try {
                // Get the Class object for Configuration class
                Class<?> configClass = Configuration.class;

                // Get the private static field 'API_KEY'
                Field apiKeyField = configClass.getDeclaredField("API_KEY");

                // Make the private static field accessible
                apiKeyField.setAccessible(true);

                // Modify the value of the static field 'API_KEY'
                apiKeyField.set(null, "new_api_key_12345");  // 'null' because it's a static field

                // Call the method to display the modified API_KEY
                Configuration.displayAPIKey();  // Output the updated API_KEY value

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
}
