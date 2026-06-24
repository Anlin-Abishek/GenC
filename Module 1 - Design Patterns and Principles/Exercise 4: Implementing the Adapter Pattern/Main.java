interface PaymentProcessor {
    void processPayment(double amountInUSD);
}

class LegacyRupeeVendor {
    public void executeRupeeTransaction(double amountInINR) {
        System.out.println("💸 Legacy Vendor: Successfully processed ₹" + amountInINR);
    }
}

class CurrencyPaymentAdapter implements PaymentProcessor {
    private LegacyRupeeVendor legacyVendor;
    private final double EXCHANGE_RATE_USD_TO_INR = 83.50; 

    public CurrencyPaymentAdapter(LegacyRupeeVendor legacyVendor) {
        this.legacyVendor = legacyVendor;
    }

    @Override
    public void processPayment(double amountInUSD) {
        double amountInINR = amountInUSD * EXCHANGE_RATE_USD_TO_INR;
        System.out.println("🔄 Adapter: Converting $" + amountInUSD + " USD to ₹" + amountInINR + " INR.");
        
        legacyVendor.executeRupeeTransaction(amountInINR);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Checkout Process Started ---");

        LegacyRupeeVendor oldVendor = new LegacyRupeeVendor();

        PaymentProcessor adapter = new CurrencyPaymentAdapter(oldVendor);

        double orderTotalUSD = 45.00;
        adapter.processPayment(orderTotalUSD);
        
        System.out.println("--- Checkout Process Completed ---");
    }
}
