package advanceproblems.dependencyinjectionusingreflection;


import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionproblems.advanceproblems.dependencyinjectionusingreflection.DatabaseService;
import reflectionproblems.advanceproblems.dependencyinjectionusingreflection.EmailService;
import reflectionproblems.advanceproblems.dependencyinjectionusingreflection.SimpleDIContainer;
import reflectionproblems.advanceproblems.dependencyinjectionusingreflection.UserService;

public class TestingDIContainer {

        private SimpleDIContainer diContainer;
        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() throws Exception {
            diContainer = new SimpleDIContainer();
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Register services with the container
            diContainer.register(DatabaseService.class);
            diContainer.register(EmailService.class);
            diContainer.register(UserService.class);
        }

        @Test
        public void testDependencyInjection() throws Exception {
            // Create an instance of UserService
            UserService userService = new UserService();

            // Inject dependencies into UserService
            diContainer.inject(userService);

            // Call the createUser method, which uses the injected services
            userService.createUser("john_doe");

            // Capture the output
            String output = outputStream.toString();

            // Verify the output
            assertTrue(output.contains("Creating user: john_doe"));
            assertTrue(output.contains("Connected to the database."));
            assertTrue(output.contains("Sending email to john_doe: Welcome to our service, john_doe!"));
        }
}
