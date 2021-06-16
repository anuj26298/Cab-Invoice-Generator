package com.cabinvoiceservice;

public class InvoiceSummary {
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/ this.numberOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        InvoiceSummary that = (InvoiceSummary) obj;
        return Double.compare(that.averageFare, averageFare) == 0 &&
                totalFare == that.totalFare &&
                Double.compare(that.numberOfRides, numberOfRides) == 0;
    }
}
