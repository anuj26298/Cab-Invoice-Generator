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
}
