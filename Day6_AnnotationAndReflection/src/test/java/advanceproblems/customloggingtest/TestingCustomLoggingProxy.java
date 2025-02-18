package advanceproblems.customloggingtest;


import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionproblems.advanceproblems.customloggingproxyusingreflection.DynamicProxy;
import reflectionproblems.advanceproblems.customloggingproxyusingreflection.Greeting;
import reflectionproblems.advanceproblems.customloggingproxyusingreflection.GreetingImpl;

public class TestingCustomLoggingProxy {

        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        public void testLoggingProxy() {
            // Create a GreetingImpl object
            Greeting greeting = new GreetingImpl();

            // Create a logging proxy for the Greeting object
            Greeting proxyGreeting = (Greeting) DynamicProxy.createLoggingProxy(greeting);

            // Call the sayHello method on the proxy object
            proxyGreeting.sayHello();  // This will log the method name before execution

            // Capture the output
            String output = outputStream.toString();

            // Verify that the method name is logged correctly
            assertTrue(output.contains("Calling method: sayHello"));
            assertTrue(output.contains("Hello, World!"));
        }

}
