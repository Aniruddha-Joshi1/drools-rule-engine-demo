package com.learnrulesengine.RulesEngine.model;

import com.learnrulesengine.RulesEngine.DTO.CustomerDTO;
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

    private String status;

    public Customer(){

    }

    public Customer(CustomerDTO customer){
        this.discount = customer.getDiscount();
        this.purchaseAmount = customer.getPurchaseAmount();
        this.type = customer.getType();
        this.status = customer.getStatus();
    }

    public Customer(int discount, double purchaseAmount, String type, String status) {
        this.discount = discount;
        this.purchaseAmount = purchaseAmount;
        this.type = type;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
