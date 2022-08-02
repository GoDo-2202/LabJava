/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023.Entity;

/**
 *
 * @author Admin
 */
public class Order {
    private String fruitName;
    private int quantity;
    private float price;
    private float amount;

    public Order() {
    }

    public Order(String fruitName, int quantity, float price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        amount = price * (float)quantity;
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
