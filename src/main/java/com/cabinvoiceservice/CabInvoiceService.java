package com.cabinvoiceservice;

public class CabInvoiceService {
    private static final double MINIMUM_COST_PER_KM_NORMAL = 10;
    private static final int COST_PER_MINUTE_NORMAL = 1;
    private static final double MINIMUM_FARE_NORMAL = 5;

    private static final double MINIMUM_COST_PER_KM_PREMIUM = 20;
    private static final int COST_PER_MINUTE_PREMIUM = 2;
    private static final double MINIMUM_FARE_PREMIUM = 20;

    private CabSubscriptionType cabSubscriptionType;
    RideRepository rideRepository = new RideRepository();

    public CabInvoiceService(CabSubscriptionType cabSubscriptionType) {
        this.cabSubscriptionType = cabSubscriptionType;
        this.rideRepository = rideRepository;
    }

    public double calculateFare(double distance, int time) {
        if (cabSubscriptionType.NORMAL.equals(this.cabSubscriptionType)){
            double fare = (distance * MINIMUM_COST_PER_KM_NORMAL) + (time * COST_PER_MINUTE_NORMAL);
            return Math.max(MINIMUM_FARE_NORMAL, fare );
        }
        if (cabSubscriptionType.PREMIUM.equals(this.cabSubscriptionType)){
            double fare = (distance * MINIMUM_COST_PER_KM_PREMIUM) + (time * COST_PER_MINUTE_PREMIUM);
            return Math.max(MINIMUM_FARE_PREMIUM, fare);
        }
        return 0;
    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for (Ride ride : rides){
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRideInRepo(String userId, Ride[] rides){
        rideRepository.addUserRide(userId, rides);
    }
    public InvoiceSummary getInvoiceSummary(String userId){
        return this.calculateFare(rideRepository.getUserRide(userId));
    }

}
