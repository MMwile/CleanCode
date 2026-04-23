package edu.isi.cleancode.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

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
}
