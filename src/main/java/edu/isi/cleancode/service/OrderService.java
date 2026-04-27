package edu.isi.cleancode.service;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

public class OrderService {

    private TaxCalculator taxCalculator = new TaxCalculator();
    private ShippingCalculator shippingCalculator = new ShippingCalculator();

    public String generateSummary(Order order) {
        double subtotal = 0;
        for (OrderItem item : order.getItems()) {
            subtotal += item.subtotal();
        }

        double shipping = shippingCalculator.calculate(order.getCountryCode(), order.isPriority(), subtotal);
        double taxes = taxCalculator.calculate(order.getCountryCode(), subtotal);
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

        return round2(subtotal + shippingCalculator.calculate(order.getCountryCode(), order.isPriority(), subtotal)
                                + taxCalculator.calculate(order.getCountryCode(), subtotal));
    }

    private double round2(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}