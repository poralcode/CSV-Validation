/*
 * Author: Alejo Rostata
 * Description: This program reads a CSV file, validates the input data, and outputs the data to standard output.
 * It performs validation on fields like id, name, birthday, gender, and phone number based on specific rules.
 * The validated data is output along with error messages for invalid data. The header of the CSV file is excluded
 * from validation.
 * OUTLINE: https://drive.google.com/drive/folders/1n2_GFtIUoR0O2T_m51p6ALWnSkkWJ6_r
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

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\alejo\\IdeaProjects\\CSV-Validation\\out\\production\\CSV-Validation\\writers.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String header = br.readLine(); // Read and print the header
            System.out.println(header); //print the header as-is.
            br.lines()
                    .map(line -> line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1))
                    .map(Main::validateFields) //Validate each field in the line.
                    .forEach(System.out::println); //Print the validated line.
        } catch (IOException e) {
            e.printStackTrace(); //It's usually better to use a more robust logging, but for simplicity we'll just use printStackTrace().
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

