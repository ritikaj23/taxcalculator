package com.example.taxcalculator;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaxCalculatorService {
    private final List<TaxBracket> taxBrackets = List.of(
        new TaxBracket(0.0, 11000.0, 0.10),  // 10% for $0 - $11,000
        new TaxBracket(11000.0, 44725.0, 0.12), // 12% for $11,001 - $44,725
        new TaxBracket(44725.0, 50000.0, 0.22), // 22% for $44,726 - $50,000
        new TaxBracket(50000.0, 100000.0, 0.24), // 24% for $50,001 - $100,000
        new TaxBracket(100000.0, 900000.0, 0.32)  // 32% for $100,001 - $900,000
    );

    public double calculateTax(double income) {
        double tax = 0.0;

        for (TaxBracket bracket : taxBrackets) {
            if (income > bracket.getLower()) {
                double taxableIncome = Math.min(income, bracket.getHigher()) - bracket.getLower();
                tax += taxableIncome * bracket.getPercentage();
                if (income <= bracket.getHigher()) break;
            }
        }

        return tax;
    }
}
