package reflectionproblems.advanceproblems.createacustomobjectmapper;
import java.lang.reflect.Field;
import java.util.Map;
class Person {
    private String name;
    private int age;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to display Person's info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class CreateObjectMapper {

        // Method to map values from the Map to the object's fields using Reflection
        public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
            try {
                // Create a new instance of the class
                T instance = clazz.getDeclaredConstructor().newInstance();

                // Iterate through the Map and set field values dynamically
                for (Map.Entry<String, Object> entry : properties.entrySet()) {
                    // Get the field by name from the class
                    Field field = clazz.getDeclaredField(entry.getKey());

                    // Make the field accessible if it's private
                    field.setAccessible(true);

                    // Set the value of the field
                    field.set(instance, entry.getValue());
                }

                return instance;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

}
