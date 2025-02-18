package reflectionproblems.advanceproblems.methodexecutiontiming;

import java.lang.reflect.*;
class Calculator {

    public int add(int a, int b) {
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        return a + b;
    }

    public int subtract(int a, int b) {
        try { Thread.sleep(200); } catch (InterruptedException e) {}
        return a - b;
    }

    public int multiply(int a, int b) {
        try { Thread.sleep(300); } catch (InterruptedException e) {}
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        try { Thread.sleep(400); } catch (InterruptedException e) {}
        return a / b;
    }
}

public class ExecutionTime {

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
