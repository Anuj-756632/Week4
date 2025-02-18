package reflectionproblems.basicproblems.getclassinformation;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInformation {
    public static void main(String[] args) {
        // Take class name as input
        System.out.print("Enter the class name (e.g., java.util.ArrayList): ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();

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

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
