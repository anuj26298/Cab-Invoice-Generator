package com.cabinvoiceservice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ReturnTotalFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService(CabSubscriptionType.NORMAL);
        double fare = cabInvoiceService.calculateFare(10,20);
        Assert.assertEquals(120, fare, 0);
    }

    @Test
    public void givenDistanceAndTime_WhenFareIsLessThenMinumumFare_ReturnMinimumFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService(CabSubscriptionType.NORMAL);
        double fare = cabInvoiceService.calculateFare(0.2, 2);
        Assert.assertEquals(5,fare,0);
    }

    @Test
    public void givenMultipleRides_ReturnInvoiceSummary() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService(CabSubscriptionType.NORMAL);
        Ride[] rides = {new Ride(10,20),
        new Ride(0.2,3)};
        InvoiceSummary actualInvoiceSummary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,125);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserId_ReturnUserRideInvoiceSummary() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService(CabSubscriptionType.NORMAL);
        Ride[] user1Ride = {new Ride(10,20),
        new Ride(.2,3)};
        Ride[] user2Ride = {new Ride(10,15),
        new Ride(.2,2),
        new Ride(5, 10)};
        cabInvoiceService.addRideInRepo("1",user1Ride);
        cabInvoiceService.addRideInRepo("2",user2Ride);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,180);
        InvoiceSummary actualInvoiceSummary = cabInvoiceService.getInvoiceSummary("2");
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }
}
