package com.example.taxcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tax")
public class TaxCalculatorController {

    private final TaxCalculatorService taxCalculatorService;

    @Autowired
    public TaxCalculatorController(TaxCalculatorService taxCalculatorService) {
        this.taxCalculatorService = taxCalculatorService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculateTax(@RequestParam double income) {
        if (income < 0) {
            return ResponseEntity.badRequest().body("Income cannot be negative.");
        }

        double tax = taxCalculatorService.calculateTax(income);
        double taxPercentage = (income > 0) ? (tax / income) * 100 : 0;

        return ResponseEntity.ok(new TaxResponse(income, tax, taxPercentage));
    }

    // Inner class to return JSON response
    static class TaxResponse {
        public double income;
        public double tax;
        public double taxPercentage;

        public TaxResponse(double income, double tax, double taxPercentage) {
            this.income = income;
            this.tax = tax;
            this.taxPercentage = taxPercentage;
        }
    }
}
