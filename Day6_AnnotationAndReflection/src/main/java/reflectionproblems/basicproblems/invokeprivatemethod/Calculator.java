package reflectionproblems.basicproblems.invokeprivatemethod;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {

    // Private method to multiply two integers
    private int multiply(int a, int b) {
        return a * b;
    }
}
class CalculatorUsingReflection {

    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the private method 'multiply' from the Calculator class
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private method and get the result
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);  // Multiplying 5 and 10

            // Display the result
            System.out.println("Result of multiplication: " + result);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
