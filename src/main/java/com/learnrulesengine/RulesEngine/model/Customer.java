package com.learnrulesengine.RulesEngine.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String type;

    private double purchaseAmount;

    private int discount;

    public Customer(){

    }

    public Customer(int discount, double purchaseAmount, String type) {
        this.discount = discount;
        this.purchaseAmount = purchaseAmount;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "type='" + type + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", discount=" + discount +
                '}';
    }
}
