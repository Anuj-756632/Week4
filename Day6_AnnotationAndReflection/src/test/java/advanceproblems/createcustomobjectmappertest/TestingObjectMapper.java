package advanceproblems.createcustomobjectmappertest;

import reflectionproblems.basicproblems.invokeprivatemethod.Calculator;

import java.lang.reflect.*;
public class TestingObjectMapper {

    public class MethodExecutionTimer {

        public static void measureExecutionTime(Object target) {
            // Get all methods of the class
            Method[] methods = target.getClass().getDeclaredMethods();

            // Iterate through each method
            for (Method method : methods) {
                try {
                    // Measure the start time
                    long startTime = System.currentTimeMillis();

                    // Invoke the method (we pass null for arguments here, you can modify for real use)
                    method.setAccessible(true); // Ensure private methods can be accessed
                    Object result = method.invoke(target, 10, 5); // Arguments for the method (e.g., 10, 5)

                    // Measure the end time
                    long endTime = System.currentTimeMillis();

                    // Calculate and print the execution time
                    System.out.println("Method: " + method.getName() + " executed in " + (endTime - startTime) + " ms");

                } catch (Exception e) {
                    System.out.println("Error while invoking method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            // Create a Calculator instance
            Calculator calculator = new Calculator();

            // Measure execution times for all methods in Calculator
            measureExecutionTime(calculator);
        }
    }

}
