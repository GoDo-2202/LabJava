/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bublesort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BubleSort {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BubleSortAlgorythm();
    }

    private static int[] generateArray() {
        System.out.println("Enter number of array:");
        int size = inputSizeOfArray();
        int[] array = getElementArray(size);
        return array;
    }

    private static int inputSizeOfArray() {
        //the loop runs until user input correctly
        int size;
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size >= 0) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input size > 0 and integer number");
                System.out.println("Input again: ");
            }
        }
    }

    private static int inputIntNumber() {
        int element;
        //the loop runs until user input correctly
        while (true) {
            try {
                element = Integer.parseInt(scanner.nextLine());
                return element;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number");
                System.out.println("Input again: ");
            }
        }
    }

    /*
    In Array
    - the first loop runs the first index to the last index
    - the seccond loop runs the first index to near the last index
    if condition true swap 2 values next to each other
     */
    private static void testSortArrayByBubleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            // the loops runs from the first index to near last index 
            // and 
            for (int j = 0; j < array.length - i - 1; j++) {
                displayArray(array);
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                    System.out.println("\t" + array[j] + ">" + array[j + 1] + ", swap");
                } else {
                    System.out.println("\t" + array[j] + "<" + array[j + 1] + ", ok");
                }
            }
        }
    }

    private static void sortArrayByBubleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    private static int[] getElementArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        //the loop runs the first index to last index in the array
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = random.nextInt(size) + 1;
        }
        return array;
    }

    private static void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

    private static void BubleSortAlgorythm() {
//        int[] array = generateArray();
        int[] array = {5, 1, 12, -5, 16};  //test
        System.out.print("Unsorted array: ");
        displayArray(array);
        System.out.println("");
        testSortArrayByBubleSort(array); //test
//        sortArrayByBubleSort(array);
        System.out.print("Sorted array: ");
        displayArray(array);
    }

}
