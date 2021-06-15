package com.cabinvoiceservice;

public class CabInvoiceService {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    public double calculateFare(double distance, int time) {
        return (MINIMUM_COST_PER_KM * distance) + (COST_PER_MINUTE * time);
    }
}
