package advanceproblems.generatejsonrepresentationtest;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflectionproblems.advanceproblems.generatejsonrepresentation.GenerateJson;
import reflectionproblems.basicproblems.accessprivatefield.Person;

public class TestingGeneratorJson {

        @Test
        public void testToJson() {
            // Create a Person object
            Person person = new Person(25);

            // Convert the Person object to a JSON-like string
            String jsonString = GenerateJson.toJson(person);

            // Verify the JSON-like string
            String expectedJson = "{\"name\": \"John Doe\", \"age\": 25}";
            assertEquals(expectedJson, jsonString);
        }

}
