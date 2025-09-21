
package CSVfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

/**
 * The following class reads CSV files already existent. This is adapted specifically to the teacher's example, but the method used is the same for any CSV file reader.
 * @author Jesús Martínez
 */
public class ReadCSV {
    public static void main(String[] args) {
        // Storages the filepath of the previous CSV file created.
        String filePath = "uniappteachers.csv";

        // Reads the CSV file with the CSVReader function from the OpenCSV library. Declaring "reader" as the reference for the file.
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // This is used to print to content of the CSV file.
            System.out.println("CSV content:\n");

            // A while condition to read each row of the CSV file. The nextLine variable is defined by the next element of the CSV file (previously declared as "reader"), as long it is not null.
            while ((nextLine = reader.readNext()) != null) {

                // nextLine is an array with the content of each row.
                System.out.println("Name: " + nextLine[0]
                        + " | Age: " + nextLine[1]
                        + " | Course: " + nextLine[2]);
            }

            // The following catches works for exception handling:
        } catch (IOException e) {

            // It displays the trace of the execution to locate the error.
            e.printStackTrace();

        } catch (CsvValidationException e) {

            // It displays a runtime exception message in case that something wrong happened with the CSV file.
            throw new RuntimeException(e);
        }
    }
}