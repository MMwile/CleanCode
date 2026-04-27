package edu.isi.cleancode.service;

public class TaxCalculator {

    public double calculate(String countryCode, double subtotal) {
        double rate = getRateFor(countryCode);
        return Math.round(subtotal * rate * 100.0) / 100.0;
    }

    private double getRateFor(String countryCode) {
        switch (countryCode) {
            case "HN": return 0.15;
            case "PE": return 0.18;
            case "CL": return 0.19;
            default:   return 0.15;
        }
    }
}