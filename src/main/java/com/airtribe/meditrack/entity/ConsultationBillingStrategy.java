package main.java.com.airtribe.meditrack.entity;

public class ConsultationBillingStrategy implements BillingStrategy{
    @Override
    public double calculate() {
        double baseFee = 500;
        return baseFee;
    }
}
