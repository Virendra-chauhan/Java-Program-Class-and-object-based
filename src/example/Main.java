//package example;
//
//import java.util.*;
//
//import static example.Shipping.setShippingMethod;
//
//class Product {
//    private String name;
//    private double price;
//
//    public Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//}
//
//class Inventory {
//    Map<Product, Integer> products;
//
//    public Inventory() {
//        products = new HashMap<>();
//        products.put(new Product("Moisturizer", 299) , 1);
//        products.put(new Product("Sunscreen", 199) , 2);
//        products.put(new Product("Facial Cleanser", 349), 3);
//        products.put(new Product("Toner", 159) , 4);
//        products.put(new Product("Serum", 179) , 5);
//        products.put(new Product("Eye Cream", 249) , 6);
//        products.put(new Product("Face Mask", 389) , 7);
//        products.put(new Product("Eyeliner", 499) , 8);
//        products.put(new Product("Lipstick", 489) , 9);
//        products.put(new Product("Shampoo", 199) , 10);
//    }
//
//    public void addProduct(Product product, int quantity) {
//        products.merge(product, quantity, Integer::sum);
//    }
//
//    public boolean hasProduct(Product product, int quantity) {
//        return products.getOrDefault(product, 0) >= quantity;
//    }
//
//    public void removeProduct(Product product, int quantity) {
//        int currentQuantity = products.get(product);
//        if (currentQuantity > quantity) {
//            products.put(product, currentQuantity - quantity);
//        } else {
//            products.remove(product);
//        }
//    }
//}
//
//class ShoppingCart {
//    Map<Product, Integer> items;
//
//    public ShoppingCart() {
//        items = new HashMap<>();
//    }
//
//    public void addToCart(Product product) {
//        items.merge(product, 1, Integer::sum);
//    }
//
//    public void removeFromCart(Product product) {
//        items.remove(product);
//    }
//
//    public double getTotalPrice() {
//        return items.entrySet().stream()
//                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
//                .sum();
//    }
//}
//
//class Payment {
//    public static boolean processPayment(double amount) {
//        // Implement payment processing logic here
//        return true;
//    }
//}
//
//class Shipping {
//    public static void setShippingMethod(Order order, String shippingMethod) {
//        order.setShippingMethod(shippingMethod);
//    }
//}
//
//class Order {
//    private List<Product> products;
//    private String shippingMethod;
//    private double totalPrice;
//
//    public Order() {
//        products = new ArrayList<>();
//    }
//
//    public void addProduct(Product product) {
//        products.add(product);
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setShippingMethod(String shippingMethod) {
//        this.shippingMethod = shippingMethod;
//    }
//
//    public String getShippingMethod() {
//        return shippingMethod;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//}
//
//class Customer {
//    String name;
//    private String email;
//    private List<Order> orderHistory;
//
//    public Customer(String name, String email) {
//        this.name = name;
//        this.email = email;
//        orderHistory = new ArrayList<>();
//    }
//
//    public void placeOrder(Order order) {
//        orderHistory.add(order);
//    }
//
//    public List<Order> getOrderHistory() {
//        return orderHistory;
//    }
//}
//
//class Admin {
//    private Inventory inventory;
//
//    public Admin(Inventory inventory) {
//        this.inventory = inventory;
//    }
//
//    public void addProduct(Product product, int quantity) {
//        inventory.addProduct(product, quantity);
//    }
//}
//
//class OnlineShoppingPlatform {
//    private Inventory inventory;
//    private Map<Customer, ShoppingCart> customerCarts;
//    private Scanner scanner;
//
//    public OnlineShoppingPlatform() {
//        inventory = new Inventory();
//        customerCarts = new HashMap<>();
//        scanner = new Scanner(System.in);
//    }
//
//    public void run() {
//        Admin admin = new Admin(inventory);
//        Customer customer = createCustomer();
//
//        while (true) {
//            displayMenu();
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    searchProducts();
//                    break;
//                case 2:
//                    addToCart(customer);
//                    break;
//                case 3:
//                    admin.addProduct(createProduct(), getProductQuantity());
//                    break;
//                case 4:
//                    placeOrder(customer);
//                    break;
//                case 5:
//                    viewOrderHistory(customer);
//                    break;
//                case 6:
//                    setShippingMethod(customer.getOrderHistory().get(0), getShippingMethod());
//                    break;
//                case 7:
//                    System.out.println("Exiting...");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private void displayMenu() {
//        System.out.println("\nMenu:");
//        System.out.println("1. Search for products");
//        System.out.println("2. Add to cart");
//        System.out.println("3. Add new product");
//        System.out.println("4. Place order");
//        System.out.println("5. View order history");
//        System.out.println("6. Set shipping method");
//        System.out.println("7. Exit");
//        System.out.print("Enter your choice: ");
//    }
//
//    private Customer createCustomer() {
//        System.out.print("Enter your name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter your email: ");
//        String email = scanner.nextLine();
//        return new Customer(name, email);
//    }
//
//    private Product createProduct() {
//        System.out.print("Enter product name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter product price: ");
//        double price = scanner.nextDouble();
//        scanner.nextLine(); // Consume newline
//        return new Product(name, price);
//    }
//
//    private int getProductQuantity() {
//        System.out.print("Enter product quantity: ");
//        return scanner.nextInt();
//    }
//
//    private String getShippingMethod() {
//        System.out.print("Enter shipping method: ");
//        return scanner.nextLine();
//    }
//
//    private void searchProducts() {
//        System.out.print("Enter keyword to search: ");
//        String keyword = scanner.nextLine();
//        inventory.products.keySet().stream()
//                .filter(product -> product.getName().contains(keyword))
//                .forEach(product -> System.out.println(product.getName() + " - $" + product.getPrice()));
//    }
//
//    private void addToCart(Customer customer) {
//        System.out.print("Enter product name to add: ");
//        String productName = scanner.nextLine();
//        inventory.products.keySet().stream()
//                .filter(product -> product.getName().equals(productName))
//                .findFirst()
//                .ifPresent(product -> {
//                    ShoppingCart cart = customerCarts.computeIfAbsent(customer, key -> new ShoppingCart());
//                    cart.addToCart(product);
//                    System.out.println(product.getName() + " added to cart.");
//                });
//    }
//
//    private void placeOrder(Customer customer) {
//        ShoppingCart cart = customerCarts.get(customer);
//        Order order = new Order();
//        double totalPrice = 0;
//
//        for (Map.Entry<Product, Integer> entry : cart.items.entrySet()) {
//            Product product = entry.getKey();
//            int quantity = entry.getValue();
//
//            if (inventory.hasProduct(product, quantity)) {
//                for (int i = 0; i < quantity; i++) {
//                    order.addProduct(product);
//                }
//                totalPrice += product.getPrice() * quantity;
//                inventory.removeProduct(product, quantity);
//            } else {
//                System.out.println("Insufficient quantity for " + product.getName());
//            }
//        }
//
//        order.setTotalPrice(totalPrice);
//        customer.placeOrder(order);
//        cart.items.clear();
//        System.out.println("Order placed successfully.");
//    }
//
//    private void viewOrderHistory(Customer customer) {
//        List<Order> orderHistory = customer.getOrderHistory();
//        if (orderHistory.isEmpty()) {
//            System.out.println("No order history found.");
//            return;
//        }
//        System.out.println("Order History for " + customer.name);
//        orderHistory.forEach(order -> {
//            System.out.println("Order:");
//            order.getProducts().forEach(product -> System.out.println(product.getName()));
//            System.out.println("Shipping Method: " + order.getShippingMethod());
//            System.out.println("Total Price: $" + order.getTotalPrice());
//        });
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        OnlineShoppingPlatform platform = new OnlineShoppingPlatform();
//        platform.run();
//    }
//}