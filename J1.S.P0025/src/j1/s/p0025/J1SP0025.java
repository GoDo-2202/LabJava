/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0025;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class J1SP0025 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        normalizeText();
    }

    private static void normalizeText() throws IOException {
        //Step 1: Read file input.txt
        String text = readFile();
        //Step 2: Normalize text and sentences
        text = normalizeDocument(text);
        //Step 3: Write file output.txt
        System.out.println(text);
        writeFile(text);
    }

    private static String readFile() throws IOException {
        String direction = "src/Data/input.txt";
        String text = "";
        BufferedReader bufferedReader = null;
        try {
            File file = new File(direction);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            text = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
            while (text != null) {
                return text;
            }
        } catch (Exception e) {
            System.out.println("Error read file: " + e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return null;
    }

    private static String normalizeDocument(String text) {
        CheckValidate checkValidate = new CheckValidate();
        return checkValidate.formatText(text);
    }

    private static void writeFile(String text) {
        String direction = "src/Data/output.txt";
        try {
            File file = new File(direction);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error write file: " + e);
        }
    }

}
