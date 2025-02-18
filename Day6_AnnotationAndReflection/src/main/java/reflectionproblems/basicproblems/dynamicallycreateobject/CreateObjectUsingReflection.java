package reflectionproblems.basicproblems.dynamicallycreateobject;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    // Constructor to initialize name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student's information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class CreateObjectUsingReflection {

    public static void main(String[] args) {
        try {
            // Load the Student class dynamically using Reflection
            Class<?> studentClass = Class.forName("Student");

            // Get the constructor of the Student class that takes a String and an int as parameters
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Create a new instance of Student dynamically using the constructor
            Object studentInstance = constructor.newInstance("John Doe", 20);

            // Call the displayInfo method on the dynamically created object
            studentClass.getMethod("displayInfo").invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
