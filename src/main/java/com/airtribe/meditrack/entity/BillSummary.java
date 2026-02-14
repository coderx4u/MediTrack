package main.java.com.airtribe.meditrack.entity;

public final class BillSummary {

    private final long billId;
    private final double baseAmount;
    private final double tax;
    private final double finalAmount;

    public BillSummary(long billId, double baseAmount, double tax, double finalAmount) {
        this.billId = billId;
        this.baseAmount = baseAmount;
        this.tax = tax;
        this.finalAmount = finalAmount;
    }

}
