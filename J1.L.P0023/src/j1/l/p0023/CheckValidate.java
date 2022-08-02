/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import j1.l.p0023.Entity.Fruit;
import j1.l.p0023.Entity.Order;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
class CheckValidate {

    Scanner scanner = new Scanner(System.in);

    int inputIntegerNumber() {
        int size;
        //the loop runs until user input correctly
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size > 0) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    boolean checkIdExit(ArrayList<Fruit> listFruit, int fruitId) {
        for (int i = 0; i < listFruit.size(); i++) {
            if (fruitId == listFruit.get(i).getFruitId()) {
                return false;
            }
        }
        return true;
    }

    String inputString() {
        String name;
        //the loop runs until user input correctly
        while (true) {
            try {
                name = scanner.nextLine().trim();
                if (isName(name)) {
                    name = replaceSpace(name);
                    return name;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input please input the alphabet.");
                System.out.println("Input again:");
            }
        }
    }
    
    /*
    Character range in alphabet and spaces occur once or more times
    */
    public boolean isName(String name) {
        String regex = "[a-zA-Z ]+";
        return !("".equals(name)) && Pattern.matches(regex, name);
    }

    /*
    The space has occurs once or more times
    replace all space to one space
    */
    public String replaceSpace(String name) {
        String regex = "\\s+";
        name = name.replaceAll(regex, " ").trim();
        return name;
    }
   
    float inputFloatNumber() {
        float size;
        //the loop runs until user input correctly
        while (true) {
            try {
                size = Float.parseFloat(scanner.nextLine());
                if (size > 0) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input float number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    boolean inputYesNo() {
        System.out.println("Do you want conterniu (Y/N)?");
        while (true) {
            String result = inputString();
            //check value user input equals y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //check value user input equals n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    int chooseFruitId(ArrayList<Fruit> listFruit) {
        int id;
        //the loop runs until user input correctly
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (!checkIdExit(listFruit, id)) {
                    return id;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls choose id fruit have in store.");
                System.out.println("Input again:");
            }
        }
    }

    int chooseQuantity(int i, int quantity) {
        int result;
        //the loop runs until user input correctly
        while (true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result > 0 && result <= quantity) {
                    return result;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number and 0 < input <= quantity.");
                System.out.println("Input again:");
            }
        }
    }
    
    boolean productIsExit(ArrayList<Order> list, String fruitName) {
        for (int i = 0; i < list.size(); i++) {
            if (fruitName.equalsIgnoreCase(list.get(i).getFruitName())) {
                return false;
            }
        }
        return true;
    }
    
    
}
