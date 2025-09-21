
package CSVfile;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The following class creates and writes CSV files. This is adapted specifically to the teacher's example, but the method used is the same for any CSV file creator and reader.
 * @author Jesús Martínez
 */
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "uniappteachers.csv"; // To define the filepath and name of the CSV file. If there is not filepath, the file will be localized in the project's root.

        //To write on the file, we make use of the function CSVWriter and FileWriter libraries.
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath)))
        {
            // I defined the header of the CSV file having three elements for the teachers that are put together into a string and written into the file with the function .writeNext().
            String[] header = {"Name", "Age", "Courses"};
            writer.writeNext(header);

            // Then, I defined the content of the rows in the CSV file and wrote them into the file using the previous .writeNext function as well.
            String[] user1 = {"Melanie", "29", "English;Social Sciences"};
            String[] user2 = {"Frank", "33", "Spanish"};
            String[] user3 = {"Eddy", "36", "Math;Physics"};

            writer.writeNext(user1);
            writer.writeNext(user2);
            writer.writeNext(user3);

            // This next part shows a confirmation message of the creation of the file.
            System.out.println("The CSV file was successfully created in: " + filePath);

            // The following catch works for exception handling:
        } catch (IOException e) {
            // The following lines shows us the trace of the program execution, as well as the exact part of the program that has an error with the .getMessage function.
            e.printStackTrace();
            System.out.println("Program Error in: " + e.getMessage());
        }
    }
}