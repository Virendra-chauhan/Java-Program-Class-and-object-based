package shoppingWebsite.customer;

import shoppingWebsite.inventory.Inventory;
import shoppingWebsite.order.Order;
import shoppingWebsite.payment.Payment;
import shoppingWebsite.product.Product;
import shoppingWebsite.shipping.Shipping;
import shoppingWebsite.shoppingCart.ShoppingCart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private ShoppingCart cart = new ShoppingCart();
    private List<Order> orderHistory = new ArrayList<>();

    public Customer(String customerName,String customerEmail, String customerPassword) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;

    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void viewCart() {
        cart.viewCart();
    }

    public void placeOrder(String address) {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty.");
            return; // It's for break.
        }

        double total = cart.calculateTotal();
        boolean paymentSuccess = Payment.processPayment(total);
        if (paymentSuccess) {
            Order order = new Order(cart.getItems() , address);
            orderHistory.add(order);
            System.out.println("Order placed successfully! " + getCustomerName());
            System.out.println("Thank You !");
            cart.clearCart();
        }
    }

    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            for (Order order : orderHistory) {
                order.displayOrder();
            }
        }
    }

    public void trackOrder() {
        Shipping.trackOrder();
    }

    public void customer(){
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Customer customer = new Customer("", "","");
        while (true) {

            System.out.println("1. Search products");
            System.out.println("2. Add items to shopping cart");
            System.out.println("3. View cart");
            System.out.println("4. Place an order");
            System.out.println("5. View order history");
            System.out.println("6. Track an order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                int customerNumber = sc.nextInt();

                if (customerNumber == 7) {
                    System.exit(0);
                }

                switch (customerNumber) {
                    case 1:
                        System.out.print("Enter Product Id : ");
                        int id = sc.nextInt();
                        System.out.println(inventory.searchProduct(id));
                        break;

                    case 2:
                        System.out.print("Enter product id : ");
                        int productId = sc.nextInt();
                        try {
                            Product product = inventory.searchProduct(productId);
                            customer.addToCart(product);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        customer.viewCart();
                        break;

                    case 4:
                        System.out.print("Enter address for shipping: ");
                        sc.nextLine();
                        String address = sc.nextLine();
                        customer.placeOrder(address);
                        break;

                    case 5:
                        customer.viewOrderHistory();
                        break;

                    case 6:
                        customer.trackOrder();
                        break;

                    default:
                        System.out.println("Invalid Option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter number not anything else. Thank You !");
                sc.nextLine();
            }
        }
    }
}
