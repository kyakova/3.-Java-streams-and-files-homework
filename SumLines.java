package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;


public class SumLines {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "EN"));

        try (BufferedReader reader = new BufferedReader(new FileReader("resource.txt"))) {
            String line = reader.readLine();

            while (line != null) {
                int symbolTotalCount = 0;
                for (int i = 0; i < line.length(); i++) {
                    symbolTotalCount += line.charAt(i);
                }
                System.out.println(symbolTotalCount);

                line = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException fnfex) {
            System.out.print("File not found.");
        } catch (IOException ioex) {
            System.out.print("Invalid file.");
        }
    }
}