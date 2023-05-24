package org.example;

import java.io.*;

public class Main {

    private static String path = "C:\\Javafiles\\DataAnalisysPeact\\src\\main\\resources\\med.txt";

    public static void main(String[] args) {
        System.out.println(readFile(path));
    }

    private static String readFile(String path) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}