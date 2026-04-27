package edu.isi.cleancode.validation;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {
    public List<String> validate(Order order) {
        List<String> errors = new ArrayList<>();
        if (order == null) {
            errors.add("La orden no puede ser nula");
            return errors;
        }
        if (order.getId() == null || order.getId().isBlank()) {
            errors.add("El ID de la orden es obligatorio");
        }
        if (order.getCustomerName() == null || order.getCustomerName().isBlank()) {
            errors.add("El nombre del cliente es obligatorio");
        }
        if (order.getCountryCode() == null || order.getCountryCode().isBlank()) {
            errors.add("El código de país es obligatorio");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            errors.add("La orden debe tener al menos un producto");
        } else {
            for (int i = 0; i < order.getItems().size(); i++) {
                OrderItem item = order.getItems().get(i);
                if (item.getQuantity() <= 0) {
                    errors.add("El producto #" + (i + 1) + " tiene cantidad inválida");
                }
                if (item.getUnitPrice() <= 0) {
                    errors.add("El producto #" + (i + 1) + " tiene precio inválido");
                }
            }
        }
        return errors;
    }

    public boolean isValid(Order order) {
        return validate(order).isEmpty();
    }
}
