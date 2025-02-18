package advanceproblems.methodexecutiontimingtest;


import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionproblems.advanceproblems.methodexecutiontiming.ExecutionTime;
import reflectionproblems.basicproblems.invokeprivatemethod.Calculator;

public class TestingExecutionTime {

        private Calculator calculator;
        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() {
            calculator = new Calculator();
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        public void testMeasureExecutionTime() {
            // Measure execution times for all methods in Calculator
            ExecutionTime.measureExecutionTime(calculator);

            // Capture the output
            String output = outputStream.toString();

            // Verify that the output contains execution time measurements for all methods
            assertTrue(output.contains("Method: add executed in"));
            assertTrue(output.contains("Method: subtract executed in"));
            assertTrue(output.contains("Method: multiply executed in"));
            assertTrue(output.contains("Method: divide executed in"));
        }
}
