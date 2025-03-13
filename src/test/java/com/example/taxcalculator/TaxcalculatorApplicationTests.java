package com.example.taxcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxcalculatorApplicationTests {

    private final TaxCalculatorService service = new TaxCalculatorService();

    @Test
    public void testIncomeUnder11000() {
        assertEquals(600.0, service.calculateTax(6000), 0.01);
    }

    @Test
    public void testIncomeIs11000() {
        assertEquals(1100.0, service.calculateTax(11000), 0.01);
    }

    @Test
    public void testIncomeIs12000() {
        assertEquals(1220.0, service.calculateTax(12000), 0.01); // Updated expected value
    }

    @Test
    public void testIncomeUnder44725() {
        assertEquals(5147.0, service.calculateTax(44725), 0.01); // Updated expected value
    }

    @Test
    public void testIncomeUnder50000() {
        assertEquals(6307.5, service.calculateTax(50000), 0.01); // Updated expected value
    }

    @Test
    public void testIncomeUnder100000() {
        assertEquals(18307.5, service.calculateTax(100000), 0.01); // Updated expected value
    }

    @Test
    public void testIncomeUnder900000() {
        assertEquals(274307.5, service.calculateTax(900000), 0.01); // Update expected value if needed
    }
}