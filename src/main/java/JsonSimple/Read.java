
package JsonSimple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileReader;
import java.io.IOException;

/**
 * The following class reads JSON files already existent. This is adapted specifically to the student's example, but the method used is the same for any JSON file reader.
 * @author Jesús Martínez
 */
    public class Read {

        public static void main(String[] args) {

            // We use the FileReader function to read the JSON file, referencing it as "reader". In this example, we make use of the previously created "uniapp.json".
            try (FileReader reader = new FileReader("uniapp.json")) {

                // The Jsoner.deserialize function works to read and obtain the data to convert it into Java language.
                JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);

                // It prints the JSON content into the console.
                System.out.println("JSON content:\n");

                // Reads the values of the student and their age with the jsonObject.get function.
                System.out.println("Name: "+jsonObject.get("studentName")+"\nAge: "+jsonObject.get("age"));

                // Loops the array to read each element that belongs into it. It is referenced as "msg" and use the .get to obtain the name of the JsonArray that we want to use.
                // In this case, we use the uniapp array.
                JsonArray msg = (JsonArray) jsonObject.get("uniapp");

                // We use the "for" condition to iterate the array and display each element of it.
                for (Object o : msg) {
                    System.out.print(" | ");
                    System.out.print(o);
                }

                // The following catch works for exception handling:
            } catch (IOException | JsonException e) {

                // It displays a runtime exception message in case something wrong happens.
                throw new RuntimeException(e);
            }

        }

    }

