package edu.isi.cleancode.validation;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

public class OrderValidator {

    public boolean isValid(Order order) {
        if (order == null) {
            return false;
        }

        if (order.getId() == null || order.getId().isBlank()) {
            return false;
        }

        if (order.getCustomerName() == null || order.getCustomerName().isBlank()) {
            return false;
        }

        if (order.getCountryCode() == null || order.getCountryCode().isBlank()) {
            return false;
        }

        if (order.getItems().isEmpty()) {
            return false;
        }

        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() <= 0 || item.getUnitPrice() <= 0) {
                return false;
            }
        }

        return true;
    }
}
