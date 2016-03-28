package com.company;

import java.io.*;
import java.util.*;

public class SaveArray {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "EN"));
        Scanner input = new Scanner(System.in);
        List<Double> doublesListArray = new ArrayList<>();
        doublesListArray.add(1.2);
        doublesListArray.add(3.4);
        doublesListArray.add(5.6);

        try {
            FileOutputStream doublesList = new FileOutputStream("doubles.list");
            ObjectOutputStream save = new ObjectOutputStream(doublesList);

            save.writeObject(doublesListArray);
            save.flush();

            ObjectInputStream load = new ObjectInputStream(new FileInputStream("doubles.list"));
            try {
                System.out.println(load.readObject());
            } catch (ClassNotFoundException classNotFoundEx) {
                System.out.print("Error: Class not found.");
            }
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.print("Error: File not found.");
        } catch (IOException inputOutputEx) {
            System.out.print("Error: Invalid file.");
        }
    }
}