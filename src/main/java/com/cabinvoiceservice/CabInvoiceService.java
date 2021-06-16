package com.cabinvoiceservice;

public class CabInvoiceService {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    public double calculateFare(double distance, int time) {
        double fare = (MINIMUM_COST_PER_KM * distance) + (COST_PER_MINUTE * time);
        if (fare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return  fare;
    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for (Ride ride : rides){
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
