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
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
class ShopManager {

    void createProduct(ArrayList<Fruit> listFruit) {
        CheckValidate checkValidate = new CheckValidate();
        while (true) {
            System.out.println("Input id fruit: ");
            int fruitId = checkValidate.inputIntegerNumber();
            // check id exit
            if (!checkValidate.checkIdExit(listFruit, fruitId)) {
                System.out.println("Fruit id has exit!!!");
                return;
            }
            System.out.println("Input name fruit: ");
            String fruitName = checkValidate.inputString();
            System.out.println("Input price: ");
            float price = checkValidate.inputFloatNumber();
            System.out.println("Input quantity: ");
            int quantity = checkValidate.inputIntegerNumber();
            System.out.println("Input origin: ");
            String origin = checkValidate.inputString();
            listFruit.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            if (!checkValidate.inputYesNo()) {
                return;
            }
        }
    }

    void viewOrder(Hashtable<String, ArrayList<Order>> listOrder) {
        Set<String> keySet = listOrder.keySet();
        //travel each element in the set
        for (String name : keySet) {
            System.out.println("Customer: " + name);
            ArrayList<Order> list = listOrder.get(name);
            displayListOrder(list);
        }
    }

    void shopping(ArrayList<Fruit> listFruit, Hashtable<String, ArrayList<Order>> listOrder) {
        ArrayList<Order> list = new ArrayList<>();
        CheckValidate checkValidate = new CheckValidate();
        int id;
        int quantity;
        //Condition: list empty
        if (listFruit.isEmpty()) {
            System.out.println("Store haven't product.");
        }
        //the loop run until user dont want buy
        while (true) {
            displayListFruit(listFruit);
            System.out.println("Choose product you want to buy: ");
            id = checkValidate.chooseFruitId(listFruit);
            Fruit fruit = getProductById(listFruit, id);
            System.out.println("You selected: " + fruit.getFruitName());
            System.out.println("Please input quantity: ");
            quantity = checkValidate.chooseQuantity(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            //Condition: Product have in order
            if (!checkValidate.productIsExit(list, fruit.getFruitName())) {
                updateOrder(list, fruit.getFruitName(), quantity);
            } else {
                list.add(new Order(fruit.getFruitName(), quantity, fruit.getPrice()));
            }
            //Condition: User want to buy or exit
            if (!checkValidate.inputYesNo()) {
                break;
            }
        }
        displayListOrder(list);
        System.out.println("Input your name: ");
        String name = checkValidate.inputString();
        listOrder.put(name, list);
    }

    void displayListFruit(ArrayList<Fruit> listFruit) {
        char dollar = '$';
        System.out.format("%-20s%-20s%-20s%-20s%-20s\n",
                "Fruit id", "Fruit name", "Price", "Quantity", "Origin");
        for (int i = 0; i < listFruit.size(); i++) {
            //Condition : enought product in store
            if (listFruit.get(i).getQuantity() != 0) {
                System.out.format("%-20d%-20s%.0f%-19c%-20d%-20s\n",
                        listFruit.get(i).getFruitId(),
                        listFruit.get(i).getFruitName(),
                        listFruit.get(i).getPrice(),
                        dollar,
                        listFruit.get(i).getQuantity(),
                        listFruit.get(i).getOrigin());
            }
        }
    }

    private void displayListOrder(ArrayList<Order> listOrder) {
        float total = 0;
        int count = 1;
        char dollar = '$';
        System.out.format("%-20s%-20s%-20s%-20s\n",
                "Product", "Quantity", "Price", "Amount");
        for (int i = 0; i < listOrder.size(); i++) {
            System.out.format("%d.%-20s%-20d%.0f%-19c%.0f\n",
                    count++,
                    listOrder.get(i).getFruitName(),
                    listOrder.get(i).getQuantity(),
                    listOrder.get(i).getPrice(),
                    dollar,
                    listOrder.get(i).getAmount());
            total += listOrder.get(i).getAmount();
        }
        System.out.println("Total: " + total);
    }

    private Fruit getProductById(ArrayList<Fruit> listFruit, int id) {
        //travel each element in the array
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitId() == id) {
                return fruit;
            }
        }
        return null;
    }

    private void updateOrder(ArrayList<Order> list, String fruitName, int quantity) {
        //travel each element in the array
        for (Order order : list) {
            order.setQuantity(order.getQuantity() + quantity);
        }
    }

//    public static void main(String[] args) {
//        Hashtable<String, ArrayList<Order>> hashtable = new Hashtable<>();
//        ArrayList<Order> list = new ArrayList<>();
//        ArrayList<Fruit> listFruits = new ArrayList<>();
//        listFruits.add(new Fruit(1, "Banana", 5, 10, "Vietnam"));
//        listFruits.add(new Fruit(2, "Linh", 5, 8, "Vietnam"));
//        listFruits.add(new Fruit(3, "Dinh", 5, 5, "Vietnam"));
//        ShopManager shopManager = new ShopManager();
//        shopManager.shopping(listFruits, hashtable);
//        shopManager.viewOrder(hashtable);
//        shopManager.shopping(listFruits, hashtable);
//        shopManager.viewOrder(hashtable);
//    }
}
