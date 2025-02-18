package basicproblemstesting.calculatorusingreflectiontest;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionproblems.basicproblems.invokeprivatemethod.Calculator;

public class TestingCalculator {
        private Calculator calculator;

        @BeforeEach
        public void setUp() {
            calculator = new Calculator();
        }

        @Test
        public void testMultiplyUsingReflection() {
            try {
                // Get the private method 'multiply' from the Calculator class
                Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

                // Make the private method accessible
                multiplyMethod.setAccessible(true);

                // Invoke the private method and get the result
                int result = (int) multiplyMethod.invoke(calculator, 5, 10);  // Multiplying 5 and 10

                // Verify the result
                assertEquals(50, result);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        }
}
