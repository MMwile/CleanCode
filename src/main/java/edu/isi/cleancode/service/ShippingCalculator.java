package edu.isi.cleancode.service;

public class ShippingCalculator {

    public double calculate(String countryCode, boolean isPriority, double subtotal) {
        if (isPriority) {
            return "PE".equals(countryCode) ? 15.0 : 25.0;
        }
        if (subtotal > 100) {
            return 0.0;
        }
        return "PE".equals(countryCode) ? 10.0 : 20.0;
    }
}