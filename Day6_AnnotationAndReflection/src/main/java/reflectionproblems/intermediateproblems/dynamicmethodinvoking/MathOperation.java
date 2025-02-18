package reflectionproblems.intermediateproblems.dynamicmethodinvoking;
import java.lang.reflect.*;
import java.util.Scanner;
public class MathOperation {

        // Method to add two numbers
        public int add(int a, int b) {
            return a + b;
        }

        // Method to subtract two numbers
        public int subtract(int a, int b) {
            return a - b;
        }

        // Method to multiply two numbers
        public int multiply(int a, int b) {
            return a * b;
        }
}

class ReflectionExample {

    public static void main(String[] args) {
        try {
            // Create an instance of MathOperations
            MathOperation mathOps = new MathOperation();

            // Get the class of MathOperations
            Class<?> mathClass = MathOperation.class;

            // Get user input for the operation they want to perform
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the operation (add, subtract, multiply): ");
            String operation = scanner.nextLine();

            // Get the method dynamically based on the user's input
            Method method = mathClass.getMethod(operation, int.class, int.class);

            // Get input for the two numbers
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Dynamically invoke the method and display the result
            int result = (int) method.invoke(mathOps, num1, num2);
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

