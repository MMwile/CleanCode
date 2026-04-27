package edu.isi.cleancode.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

class OrderServiceTest {

    private final OrderService service = new OrderService();

    @Test
    void calculateTotal_forPeruPriorityOrder_shouldIncludePriorityShippingAndTax() {
        Order order = new Order("ORD-1", "Grace Hopper", "PE", true);
        order.addItem(new OrderItem("BOOK", 2, 50));

        double total = service.calculateTotal(order);

        assertEquals(133.0, total);
    }

    @Test
    void calculateTotal_forLargeRegularOrder_shouldHaveFreeShipping() {
        Order order = new Order("ORD-2", "Alan Turing", "PE", false);
        order.addItem(new OrderItem("KIT", 1, 200));

        double total = service.calculateTotal(order);

        assertEquals(236.0, total);
    }

    @Test
    void calculateTotal_forHondurasRegularOrder_shouldUse15PercentTax() {
        Order order = new Order("ORD-3", "Katherine Johnson", "HN", false);
        order.addItem(new OrderItem("MOUSE", 1, 100));

        double total = service.calculateTotal(order);

        assertEquals(135.0, total);
    }

    @Test
    void calculateTotal_forUnknownCountry_shouldUseDefaultTax() {
        Order order = new Order("ORD-4", "Juanguason Perez", "SR", false);
        order.addItem(new OrderItem("PLAGUE INC", 1, 100));

        double total = service.calculateTotal(order);

        assertTrue(total > 100);
    }

    @Test
    void calculateTotal_forPriorityOrderFromOtherCountry_shouldIncludePriorityShipping() {
        Order order = new Order("ORD-5", "Lionel Messi", "AW", true);
        order.addItem(new OrderItem("CAMELLO", 1, 50));

        double total = service.calculateTotal(order);

        assertTrue(total > 50);
    }
}
