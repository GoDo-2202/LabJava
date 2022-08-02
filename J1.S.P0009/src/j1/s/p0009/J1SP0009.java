/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0009;

/**
 *
 * @author Admin
 */
public class J1SP0009 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fibonacci();
    }

    private static void fibonacci() {
        //step1 : Generate fibonacci number to array
        int numberOfFibonacci = 45;
        int[] fibonacciNumbers = initArray(numberOfFibonacci);
        //step2 : gen fibonacci
        generateFibonacci(fibonacciNumbers);
        //step3 : Display fibonacci array
        displayArrayFibonacci(fibonacciNumbers);
    }

    /*
    -The fibonacci number begin number is zero and one
    -All uncalculated Fibonacci numbers will be equal to -1 
     */
    private static int[] initArray(int arraySize) {
        int[] fibonacciNumbers = new int[arraySize];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
        //the loops runs from the thrid index to the last index
        for (int i = 2; i < fibonacciNumbers.length; i++) {
            fibonacciNumbers[i] = -1;
        }
        return fibonacciNumbers;
    }

    private static void generateFibonacci(int[] fibonacciNumbers) {
        calculateFibonacci(fibonacciNumbers, fibonacciNumbers.length - 1);
    }

    /*
    Use recursion method to find 45 sequence Fibonacci 
    */
    private static int calculateFibonacci(int[] fibonacciNumbers, int fibonacciNumber) {
        //Condition: Skip all calculated numbers
        if (fibonacciNumbers[fibonacciNumber] != -1) {
            return fibonacciNumbers[fibonacciNumber];
        }
        //The next number is found by adding up the two numbers before it
        int result = calculateFibonacci(fibonacciNumbers, fibonacciNumber - 1)
                + calculateFibonacci(fibonacciNumbers, fibonacciNumber - 2);

        return fibonacciNumbers[fibonacciNumber] = result;
    }

    private static void displayArrayFibonacci(int[] fibonacciNumbers) {
        int count = 0; //test
        System.out.println("The 45 sequence fibonacci:");
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            //remove comma after the last number
            if (i == fibonacciNumbers.length - 1) {
                count++;
                System.out.print("Number " + count +": ");
                System.out.print(fibonacciNumbers[i]);
            } else {
                count++;
                System.out.print("Number " + count +": ");
                System.out.print(fibonacciNumbers[i] + ", ");
            }
        }
    }

}
