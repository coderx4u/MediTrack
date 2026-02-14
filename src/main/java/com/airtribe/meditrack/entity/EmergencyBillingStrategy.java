package main.java.com.airtribe.meditrack.entity;

public class EmergencyBillingStrategy implements BillingStrategy{
    @Override
    public double calculate() {
        double baseFee = 500;
        double emergencyFee = 500;
        return baseFee + emergencyFee;
    }
}
