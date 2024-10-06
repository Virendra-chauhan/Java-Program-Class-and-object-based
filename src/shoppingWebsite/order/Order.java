package shoppingWebsite.order;

public class Order {
    private StringBuilder items;
    private String address;

    public Order(StringBuilder items, String address) {
        this.address = address;
        this.items = items;
    }

    public void displayOrder() {
        System.out.println("\nYour Items - : ");
        System.out.print(items);
        System.out.println("Your Shipping Address: " + address);
    }
}
