/*
 * Author: polarcode
 * Description: This program reads a CSV file, validates the input data, and outputs the data to standard output.
 * It performs validation on fields like id, name, birthday, gender, and phone number based on specific rules.
 * The validated data is output along with error messages for invalid data. The header of the CSV file is excluded
 * from validation.
 *
 * SAMPLE INPUT: writers.csv
 * id,name,birthday,gender,phone-number
 * 1,Liam,1980/02/29,male,09011112222
 * 2,Austin,1994/10/10,female,08033334444
 * 3,"Jonathan,Jr",1989/01/23,female,0355556666
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        String csvFilePath = "writers.csv"; //File Path of CSV file.

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String header = br.readLine(); // Read and print the header
            System.out.println(header); //print the header as-is.
            br.lines()
                    .map(line -> line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1))
                    .map(Main::validateFields) //Validate each field in the line.
                    .forEach(System.out::println); //Print the validated line.
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while reading the CSV file", e);
        }
    }

    private static String validateFields(String[] fields) {
        StringBuilder outputLine = new StringBuilder();

        for (int i = 0; i < fields.length; i++) { //We loop through the fields on the line.
            String fieldValue = fields[i];
            String validatedValue = Validation.validateField(i, fieldValue);
            if (i > 0)
                outputLine.append(",");
            outputLine.append(validatedValue);
        }
        return outputLine.toString(); //return the validated line.
    }
}