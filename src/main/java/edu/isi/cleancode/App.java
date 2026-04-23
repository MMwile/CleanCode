package edu.isi.cleancode;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;
import edu.isi.cleancode.service.OrderService;
import edu.isi.cleancode.validation.OrderValidator;

public class App {
    public static void main(String[] args) {
        Order order = new Order("ORD-1001", "Ada Lovelace", "HN", false);
        order.addItem(new OrderItem("LAP-001", 1, 2500.00));
        order.addItem(new OrderItem("MOU-002", 2, 80.00));

        OrderValidator validator = new OrderValidator();
        if (!validator.isValid(order)) {
            System.out.println("Invalid order");
            return;
        }

        OrderService service = new OrderService();
        String summary = service.generateSummary(order);
        System.out.println(summary);
    }
}
