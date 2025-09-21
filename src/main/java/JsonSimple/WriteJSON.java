package JsonSimple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The following class creates and writes JSON files. This is adapted specifically to the student's example, but the method used is the same for any JSON file creator and writer.
 * @author Jesús Martínez
 */
public class WriteJSON {

    public static void main(String[] args) {

        // We use the JsonObjects function to add elements individually to the JSON files.
        // In this, we function .put to add them individually, defining the key or identifiable first, and then the element. In this example, we add the student name and their age.
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("studentName", "Jesus Martinez");
        jsonObject.put("age", "21");

        // We use the JsonArray function to add elements in a group to the JSON files.
        // In this, we use the function .add to add the elements into a JSON array. In this example, we add the grades of the student.
        JsonArray grades = new JsonArray();
        grades.add("Spanish: 96");
        grades.add("Math I: 86");
        grades.add("English II: 90");

        // In this function .put, we add the array grades, referencing them as "uniapp".
        jsonObject.put("uniapp", grades);

        // We create the file with the FileWriter function. In this example, we define the filepath in the root, and the name as "uniappstudents.json".
        try (FileWriter fileWriter = new FileWriter("uniappstudents.json")) {

            // We use the Jsoner function from the JsonSimple library to transform the previous text into a JSON object syntax. This is written in the fileWriter variable.
            Jsoner.serialize(jsonObject, fileWriter);

            // The following catch works for exception handling:
        } catch (IOException e) {

            // It displays a runtime exception message in case something wrong happens.
            throw new RuntimeException(e);
        }

    }

}
