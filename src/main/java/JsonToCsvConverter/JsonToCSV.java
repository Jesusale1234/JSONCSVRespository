package JsonToCsvConverter;

/**
 * Class that turns a JSON file to a CSV file.
 */
import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Turns the JSON file of a student to a CSV format (one row).
 */
public class JsonToCSV {

    /**
     * Turns a JSON file to a CSV file with a single row.
     *
     * @param jsonFilePath JSON filepath
     * @param csvFilePath  CSV filepath output
     * @throws IOException in case of an error when reading or writing
     */
    public void convert(String jsonFilePath, String csvFilePath) throws IOException {
        // Read the JSON file as string.
        String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONObject root = new JSONObject(content);

        // Obtains the file data of each row.
        String studentName = root.getString("studentName");
        String age = root.getString("age");
        JSONArray subjects = root.getJSONArray("uni app");

        // Turns the array to a combined String using a "for" condition for each element of the array.
        StringBuilder subjectsCombined = new StringBuilder();
        for (int i = 0; i < subjects.length(); i++) {
            subjectsCombined.append(subjects.getString(i));

            // It includes a ";" before a next element is presented in the array to separate them.
            if (i < subjects.length() - 1) {
                subjectsCombined.append("; ");
            }
        }

        // Creates the CSV file.
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // To create the header and write it in the file. In this example, we define "student name", "age", and "grades".
            String[] header = {"student name", "age", "grades"};
            writer.writeNext(header);

            // Writes the elements in the file, separated by student name, age, grades.
            String[] row = {studentName, age, subjectsCombined.toString()};
            writer.writeNext(row);
        }
    }

    public static void main(String[] args) {
        JsonToCSV converter = new JsonToCSV();

       // We use the previous function, defining the filepath of the existing CSV file, and the filepath and file name of the CSV file.
        try {
            converter.convert("uniapp.json", "uniapp_students.csv");
            System.out.println("✅ Conversion successfully done! Check the filepath to see the CSV file.");
        }
        // We use a catch to show us the trace of the possible errors that might occur.
            catch (IOException e) {
            e.printStackTrace();
        }
    }
}