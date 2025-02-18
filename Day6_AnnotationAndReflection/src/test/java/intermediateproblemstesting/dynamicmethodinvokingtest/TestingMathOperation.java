package intermediateproblemstesting.dynamicmethodinvokingtest;


import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionproblems.intermediateproblems.dynamicmethodinvoking.MathOperation;

public class TestingMathOperation {

    public class ReflectionExampleTest {

        private MathOperation mathOps;

        @BeforeEach
        public void setUp() {
            mathOps = new MathOperation();
        }

        @Test
        public void testAddMethod() throws Exception {
            Method method = MathOperation.class.getMethod("add", int.class, int.class);
            int result = (int) method.invoke(mathOps, 10, 5);
            assertEquals(15, result);
        }

        @Test
        public void testSubtractMethod() throws Exception {
            Method method = MathOperation.class.getMethod("subtract", int.class, int.class);
            int result = (int) method.invoke(mathOps, 10, 5);
            assertEquals(5, result);
        }

        @Test
        public void testMultiplyMethod() throws Exception {
            Method method = MathOperation.class.getMethod("multiply", int.class, int.class);
            int result = (int) method.invoke(mathOps, 10, 5);
            assertEquals(50, result);
        }
    }

}
