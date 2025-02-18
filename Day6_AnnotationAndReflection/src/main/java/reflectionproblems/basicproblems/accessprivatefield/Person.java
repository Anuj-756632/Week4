package reflectionproblems.basicproblems.accessprivatefield;


import java.lang.reflect.Field;

public class Person {
    private int age;

    // Constructor to initialize age
    public Person(int age) {
        this.age = age;
    }

    // Method to display the age
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}
class AccessPrivateField {

    public static void main(String[] args) {
        try {
            // Create an instance of Person with initial age
            Person person = new Person(25);

            // Display initial age using the displayAge method
            System.out.println("Initial value of age:");
            person.displayAge();

            // Get the 'age' field from the Person class using Reflection
            Field ageField = Person.class.getDeclaredField("age");

            // Make the private field accessible
            ageField.setAccessible(true);

            // Modify the value of the private 'age' field
            ageField.set(person, 30);  // Change age to 30

            // Display the modified age using the displayAge method
            System.out.println("\nModified value of age:");
            person.displayAge();

            // Retrieve the value of the 'age' field and print it
            int newAge = (int) ageField.get(person);
            System.out.println("\nRetrieved value of age: " + newAge);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
