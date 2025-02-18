package reflectionproblems.advanceproblems.customloggingproxyusingreflection;
import java.lang.reflect.*;

public interface Greeting {
    void sayHello();
}
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}
public class DynamicProxy {

        // Method to create a proxy instance that logs method calls
        public static Object createLoggingProxy(Object target) {
            // Return a proxy instance that implements the same interface as the target
            return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // Log method name before executing
                            System.out.println("Calling method: " + method.getName());

                            // Call the method on the actual target object
                            return method.invoke(target, args);
                        }
                    }
            );
        }

        public static void main(String[] args) {
            // Create a GreetingImpl object
            Greeting greeting = new GreetingImpl();

            // Create a logging proxy for the Greeting object
            Greeting proxyGreeting = (Greeting) createLoggingProxy(greeting);

            // Call the sayHello method on the proxy object
            proxyGreeting.sayHello();  // This will log the method name before execution
        }
}
