/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0010;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J1SP0010 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        linearSearch();
    }

    private static void linearSearch() {
        //Step1: Display a screen to ask users to enter a number of array and a search number
        System.out.println("Enter number of array:");
        int sizeOfArray = inputPositiveDecimalNumber();
        //Step2: Display a screen to ask users to enter a search number
        System.out.println("Enter search value:");
        int searchNumber = inputPositiveDecimalNumber();
        //Step2: Generate random integer in number range for each array element
        int[] array = {2,2,5,2,6,9,9,8,9,8};    //test
//        int[] array = genRandomNumberArray(sizeOfArray);
        //Step3: Display the array
        displayArray(array);
        //Step4: Display the index of search number in array
        displaySearchNumber(array, searchNumber);
    }

    private static int inputPositiveDecimalNumber() {
        Scanner scanner = new Scanner(System.in);
        int size;
        //the loop runs until user input correctly
        while (true) {            
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size > 0) {
                    return size;
                }
                else 
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input a positive decimal number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    private static int[] genRandomNumberArray(int sizeOfArray) {
        Random random = new Random();
        int[] array = new int[sizeOfArray];
        //the loop runs the first index to last index in the array
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(sizeOfArray) + 1;
        }
        return array;
    }

    private static void displayArray(int[] array) {
        System.out.print("The array: [");
        //the loop runs the first index to last index in the array
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i] + "]");
            }
            else System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

    private static void displaySearchNumber(int[] array, int searchNumber) {
        //the loop runs the first index to last index in the array
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNumber) {
                System.out.println("Found " + searchNumber + " at index: " + i);
            }
        }
    }
    
}
