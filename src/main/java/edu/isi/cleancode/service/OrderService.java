package edu.isi.cleancode.service;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

public class OrderService {

    public String generateSummary(Order order) {
        double subtotal = 0;
        for (OrderItem item : order.getItems()) {
            subtotal += item.subtotal();
        }

        double shipping = calculateShipping(order, subtotal);
        double taxes = calculateTaxes(order, subtotal);
        double total = subtotal + shipping + taxes;

        return "Order " + order.getId() + " for " + order.getCustomerName()
            + " | subtotal=" + round2(subtotal)
            + " | shipping=" + round2(shipping)
            + " | taxes=" + round2(taxes)
            + " | total=" + round2(total);
    }

    public double calculateTotal(Order order) {
        double subtotal = 0;
        for (OrderItem item : order.getItems()) {
            subtotal += item.subtotal();
        }

        return round2(subtotal + calculateShipping(order, subtotal) + calculateTaxes(order, subtotal));
    }

    // Deliberately basic implementation so students can improve readability and extensibility.
    public double calculateShipping(Order order, double subtotal) {
        if (order.isPriority()) {
            if ("PE".equals(order.getCountryCode())) {
                return 15.0;
            }
            return 25.0;
        }

        if (subtotal > 100) {
            return 0;
        }

        if ("PE".equals(order.getCountryCode())) {
            return 10.0;
        }
        return 20.0;
    }

    public double calculateTaxes(Order order, double subtotal) {
        if ("HN".equals(order.getCountryCode())) {
            return round2(subtotal * 0.15);
        }
        if ("PE".equals(order.getCountryCode())) {
            return round2(subtotal * 0.18);
        }
        if ("CL".equals(order.getCountryCode())) {
            return round2(subtotal * 0.19);
        }
        return round2(subtotal * 0.15);
    }

    private double round2(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
