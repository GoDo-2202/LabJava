/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import j1.l.p0023.Entity.Fruit;
import j1.l.p0023.Entity.Order;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class J1LP0023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fruitShop();
    }

    private static void fruitShop() {
        ShopManager shopManager = new ShopManager();
        CheckValidate checkValidate = new CheckValidate();
        ArrayList<Fruit> listFruit = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> listOrder = new Hashtable<>();
        //Step 1: Create menu 
        menu();
        //Step 2: Choose option
        //The loop runs until user wants exit program
        while (true) {
            int option = checkValidate.inputIntegerNumber();
            switch (option) {
                case 1:
                    //Step 3: Create product
                    shopManager.createProduct(listFruit);
                    shopManager.displayListFruit(listFruit);
                    break;
                case 2:
                    //Step 4: Create View order
                    shopManager.viewOrder(listOrder);
                    break;
                case 3:
                    //Step 5: Create shopping
                    shopManager.shopping(listFruit, listOrder);
                    break;
                case 4:
                    //Step 6: Exit programing
                    System.out.println("Thanks for using my program!!!");
                    return;
                default:
                    System.out.println("Invalid! Please choose option in below menu:");
                    break;
            }
            menu();
        }
    }

    private static void menu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.println("Please choose option:");
    }
}
