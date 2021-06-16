package com.cabinvoiceservice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ReturnTotalFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double fare = cabInvoiceService.calculateFare(10,20);
        Assert.assertEquals(120, fare, 0);
    }

    @Test
    public void givenDistaceAndTime_WhenFareIsLessThenMinumumFare_ReturnMinimumFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double fare = cabInvoiceService.calculateFare(0.2, 2);
        Assert.assertEquals(5,fare,0);
    }

    @Test
    public void givenMultipleRides_ReturnTotalFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        Ride[] rides = {new Ride(10,20),
        new Ride(0.2,3)};
        double fare = cabInvoiceService.calculateFare(rides);
        Assert.assertEquals(125, fare,0);
    }
}
