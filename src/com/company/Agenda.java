package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Agenda {

    HashMap<String, String> myContact = new HashMap<>();
    String[] arrayContacto;

    String inputFilename = "src/com/company/input.csv";
    String outputFilename = "src/com/company/output.csv";

    public Agenda() {}

    public void cargrContactosFile() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilename));
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                arrayContacto = line.split(",");
                myContact.put(arrayContacto[0], arrayContacto[1]);
            }

        } catch (IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public void mostrar() {
        for (Map.Entry<String, String> entry : myContact.entrySet() ) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Listado");
            System.out.println(key + " " + value);
        }
    }

    public void addContacto() {
        System.out.println("Metodo addContacto");
        myContact.put("45223563", "Rosy Lara");
    }

    public void actualizarContactosFile() {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));
            String line;

            for (Map.Entry<String, String> entry : myContact.entrySet() ) {
                String key = entry.getKey();
                String value = entry.getValue();

                line = key + "," + value;
                bufferedWriter.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
}
