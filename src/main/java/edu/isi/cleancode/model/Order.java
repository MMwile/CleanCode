package edu.isi.cleancode.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerName;
    private final List<OrderItem> items = new ArrayList<>();
    private String countryCode;
    private boolean priority;

    public Order(String id, String customerName, String countryCode, boolean priority) {
        this.id = id;
        this.customerName = customerName;
        this.countryCode = countryCode;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean isPriority() {
        return priority;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }
}
