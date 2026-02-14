package main.java.com.airtribe.meditrack.entity;


import main.java.com.airtribe.meditrack.util.IdGenerator;

public class Bill {
    private long billId;
    private Appointment appointment;
    private BillingStrategy billingStrategy;

    public Bill(long billId, Appointment appointment, BillingStrategy billingStrategy) {
        this.billId = IdGenerator.generateId("BILLID--");
        this.appointment = appointment;
        this.billingStrategy = billingStrategy;
    }

    public BillSummary generateBill() {
        double amt =  billingStrategy.calculate();
        double tax = amt * 0.18;
        double total = amt + tax;
        BillSummary billSummary = new BillSummary(billId,amt,tax,total);
        return billSummary;
    }

    public BillingStrategy getBillingStrategy() {
        return billingStrategy;
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }
}
