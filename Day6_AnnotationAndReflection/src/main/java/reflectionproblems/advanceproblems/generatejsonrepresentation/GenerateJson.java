package reflectionproblems.advanceproblems.generatejsonrepresentation;

import java.lang.reflect.Field;
class Person {
    private String name;
    private int age;

    // Constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}

public class GenerateJson {

        // Method to convert an object to a JSON-like string
        public static String toJson(Object obj) {
            StringBuilder json = new StringBuilder();
            json.append("{");

            try {
                // Get the class of the object
                Class<?> objClass = obj.getClass();

                // Get all fields of the class
                Field[] fields = objClass.getDeclaredFields();

                // Iterate through fields and build the JSON string
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);  // Make private fields accessible

                    // Get the value of the field in the object
                    Object value = field.get(obj);

                    // Add field name and value to JSON string
                    json.append("\"").append(field.getName()).append("\": ");

                    // If the value is a String, enclose it in quotes
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }

                    // Add a comma if it's not the last field
                    if (i < fields.length - 1) {
                        json.append(", ");
                    }
                }

                json.append("}");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return json.toString();
        }

        public static void main(String[] args) {
            // Create a Person object
            Person person = new Person("John Doe", 25);

            // Convert the Person object to a JSON-like string
            String jsonString = toJson(person);

            // Print the JSON-like string
            System.out.println(jsonString);
        }

}
