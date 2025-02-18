package reflectionproblems.advanceproblems.dependencyinjectionusingreflection;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

public class SimpleDIContainer {

    // A map to hold registered services
    private Map<Class<?>, Object> serviceRegistry = new HashMap<>();

    // Register a class in the container (creates an instance of the class)
    public void register(Class<?> serviceClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // Create an instance of the service class and store it in the registry
        Object serviceInstance = serviceClass.getDeclaredConstructor().newInstance();
        serviceRegistry.put(serviceClass, serviceInstance);
    }

    // Inject dependencies into the provided object
    public void inject(Object target) throws IllegalAccessException {
        // Get all declared fields of the target class
        Field[] fields = target.getClass().getDeclaredFields();

        // Iterate through fields and check for the @Inject annotation
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                // Make the field accessible if it is private
                field.setAccessible(true);

                // Get the type of the field and look for a registered service of that type
                Object dependency = serviceRegistry.get(field.getType());

                if (dependency == null) {
                    throw new RuntimeException("No service found for type: " + field.getType());
                }

                // Inject the dependency into the field
                field.set(target, dependency);
            }
        }
    }
}
public class DatabaseService {
    public void connect() {
        System.out.println("Connected to the database.");
    }
}

public class EmailService {
    public void sendEmail(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

public class UserService {

    @Inject
    private DatabaseService databaseService;

    @Inject
    private EmailService emailService;

    public void createUser(String username) {
        System.out.println("Creating user: " + username);
        databaseService.connect();
        emailService.sendEmail(username, "Welcome to our service, " + username + "!");
    }
}

public class DIContainer {

    public static void main(String[] args) {
        try {
            // Create the DI container
            SimpleDIContainer diContainer = new SimpleDIContainer();

            // Register services with the container
            diContainer.register(DatabaseService.class);
            diContainer.register(EmailService.class);
            diContainer.register(UserService.class);

            // Create an instance of UserService
            UserService userService = new UserService();

            // Inject dependencies into UserService
            diContainer.inject(userService);

            // Call the createUser method, which uses the injected services
            userService.createUser("john_doe");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
