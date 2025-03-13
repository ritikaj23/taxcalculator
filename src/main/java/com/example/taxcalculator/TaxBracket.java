package com.example.taxcalculator;

public class TaxBracket {
    private final double lower;
    private final double higher;
    private final double percentage;

    public TaxBracket(double lower, double higher, double percentage) {
        this.lower = lower;
        this.higher = higher;
        this.percentage = percentage;
    }

    public double getLower() {
        return lower;
    }

    public double getHigher() {
        return higher;
    }

    public double getPercentage() {
        return percentage;
    }
}
