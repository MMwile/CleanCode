package edu.isi.cleancode.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

import java.util.List;

class OrderValidatorTest {

    private final OrderValidator validator = new OrderValidator();

    @Test
    void isValid_shouldReturnTrueForValidOrder() {
        Order order = new Order("ORD-10", "Linus Torvalds", "CL", false);
        order.addItem(new OrderItem("USB", 2, 20));

        assertTrue(validator.isValid(order));
    }

    @Test
    void isValid_shouldReturnFalseWhenNoItems() {
        Order order = new Order("ORD-11", "Margaret Hamilton", "PE", false);

        assertFalse(validator.isValid(order));
    }

    //Errores nuevos

    @Test
    void validate_shouldReturnError_whenOrderIsNull() {
        List<String> errors = validator.validate(null);

        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("nula"));
    }

    @Test
    void validate_shouldReturnError_whenNoItems() {
        Order order = new Order("ORD-66", "Palpatine", "PE", false);

        List<String> errors = validator.validate(order);

        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("producto"));
    }

    @Test
    void validate_shouldReturnAllErrors_whenMultipleFieldsAreMissing() {
        Order order = new Order("", "", "PE", false);
        order.addItem(new OrderItem("USB", 2, 20));

        List<String> errors = validator.validate(order);
        assertEquals(2, errors.size());
    }

    @Test
    void validate_shouldReturnError_whenItemHasInvalidQuantity() {
        Order order = new Order("ORD-1", "Carlos Carlitos", "HN", false);
        order.addItem(new OrderItem("MOUSE", 0, 100));

        List<String> errors = validator.validate(order);

        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("producto #1"));
        assertTrue(errors.get(0).contains("cantidad"));
    }

    @Test
    void validate_shouldReturnError_whenItemHasInvalidPrice() {
        Order order = new Order("ORD-11", "Michael Jackson", "HN", false);
        order.addItem(new OrderItem("MOUSE", 1, 0));

        List<String> errors = validator.validate(order);

        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("producto #1"));
        assertTrue(errors.get(0).contains("precio"));
    }
}
