package shoppingWebsite.payment;

public class Payment {
    public static boolean processPayment(double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Invalid payment amount.");
            }
            System.out.println("Payment of " + amount + " rs processed successfully.");
            return true;
        } catch (Exception e) {
            System.out.println("Payment failed: " + e.getMessage());
            return false;
        }
    }
}