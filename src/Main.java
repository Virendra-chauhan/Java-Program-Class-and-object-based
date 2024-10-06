import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price;
    }

}

class Inventory {
    private HashMap<Integer, Product> productsList ;

    public Inventory() {
        productsList = new HashMap<>();
        productsList.put(1, new Product(1,"Moisturizer", 299));
        productsList.put(2, new Product(2,"Sunscreen", 199));
        productsList.put(3, new Product(3,"Facial Cleanser", 349));
        productsList.put(4, new Product(4,"Toner", 159));
        productsList.put(5, new Product(5,"Serum", 179));
        productsList.put(6, new Product(6,"Eye Cream", 249));
        productsList.put(7, new Product(7,"Face Mask", 389));
        productsList.put(8, new Product(8,"Eyeliner", 499));
        productsList.put(9, new Product(9,"Lipstick", 489));
        productsList.put(10, new Product(10,"Shampoo", 199));
    }

    public void addProduct(Product product) {
        productsList.put(product.getId(), product);
    }

    public Product searchProduct(int productId) throws Exception{
        if (!productsList.containsKey(productId)) {
            throw new Exception("Product not found.");
        }

        return productsList.get(productId);
    }

    public void displayProducts() {

        if (productsList.isEmpty()) {

            System.out.println("No products available in this inventory.");

        } else {
            System.out.println("----------------------------------------------------------------");
            System.out.printf("| %-10s | %-33s | %-5s %n","Id", "Product Name", "Price");
            System.out.println("----------------------------------------------------------------");

            for (Product product : productsList.values()){
                System.out.printf("| %-10s | %-33s | %-5s %n",product.getId(), product.getName(), product.getPrice());
            }

            System.out.println("----------------------------------------------------------------");
        }
    }
}

class Admin {
    private String adminName;
    private String adminPassword;

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void admin() throws Exception {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Main main = new Main();
        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Search for products.");
            System.out.println("2. Add new product.");
            System.out.println("3. Show users.");
            System.out.println("4. Delete user.");
            System.out.println("5. Show all products.");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int number = sc.nextInt();

            if (number == 6){
                break;
            }

            switch (number){
                case 1 :
                    System.out.print("Enter Product Id : ");
                    int id = sc.nextInt();
                    System.out.println(inventory.searchProduct(id));
                    break;

                case 2 :
                    try {
                        System.out.print("Enter Product ID: ");
                        int pId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Product Name: ");
                        String pName = sc.nextLine();
                        System.out.print("Enter Product Price: ");
                        double pPrice = sc.nextDouble();
                        Product product = new Product(pId, pName, pPrice);
                        inventory.addProduct(product);
                        System.out.println("Product added...");
                    } catch (Exception e) {
                        System.out.println("Error adding product. Please try again.");
                    }
                    break;

                case 3 :
                    main.showCustomersDetails();
                    break;

                case 4 :
                    System.out.print("Enter User Password : ");
                    String pass = sc.next();
                    main.removeCustomer(pass);
                    break;

                case 5 :
                    inventory.displayProducts();
                    break;

                default :{
                    System.out.println("Invalid choice");
                }
            }

        }

    }
}

class ShoppingCart {

    private ArrayList<Product> cartItems = new ArrayList<>();;

    public void addItem(Product product) {
        cartItems.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart items:");
            for (Product product : cartItems) {
                System.out.println(product);
            }
        }
    }

    public StringBuilder getItems() {
        StringBuilder sb = new StringBuilder();
        for (Product product : cartItems){
            sb.append("Product Name : ").append(product.getName()).append(" , ").append("Product Price : ").append(product.getPrice()).append("\n");
        }
        return sb;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }
}

class Order {
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

class Payment {
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

class Shipping {
    public static void trackOrder(String productN) {
        System.out.println("Tracking Order : " + productN + " - Shipping in progress.");
    }
}

class Customer {
    private String customerName;
    private String customerPassword;
    private ShoppingCart cart = new ShoppingCart();
    private List<Order> orderHistory = new ArrayList<>();

    public Customer(String customerName, String customerPassword) {
        this.customerName = customerName;
        this.customerPassword = customerPassword;
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

    public void trackOrder(String pName) {
        Shipping.trackOrder(pName);
    }
}

public class Main {
    private static final ArrayList<Admin> admins;
    private static final ArrayList<Customer> customers;
    static {
        System.out.println("\n----------- Welcome to GenZ Online Shopping Platform -----------");
        admins = new ArrayList<>();
        admins.add(new Admin("admin", "Admin@123"));

        customers = new ArrayList<>();
        customers.add(new Customer("Virendra", "Virendra@123"));
        customers.add(new Customer("Deepak", "Deepak@123"));
    }

    public void showCustomersDetails(){
        System.out.println("---------------------------------------------");
        System.out.printf("| %-20s | %-3s %n","User Name", "User Password");
        System.out.println("---------------------------------------------");

        for (Customer customer : customers){
            System.out.printf("| %-20s | %-3s %n",customer.getCustomerName(), customer.getCustomerPassword());
        }

        System.out.println("----------------------------------------------");
    }

    public void removeCustomer(String password){
        customers.removeIf(customer -> customer.getCustomerPassword().equalsIgnoreCase(password));

//        for (Customer customer : customers){
//            if (customer.getCustomerPassword().equalsIgnoreCase(password)){
//                customers.remove(customer);
//                System.out.println("Customer Removed successfully.");
//            }
//        }

    }



    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Main main = new Main();

        while (true){
            inventory.displayProducts();
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter : ");

            int num = sc.nextInt();
            if (num == 1){
                System.out.print("Enter Name : ");
                String adminName = sc.next();
                System.out.print("Enter password : ");
                String adminPassword = sc.next();

                for (Admin ad : admins){
                    if (ad.getAdminName().equals(adminName) && ad.getAdminPassword().equals(adminPassword)) {
                        ad.admin();
                    }else {
                        System.out.println("Sorry You are not admin.\n");
                    }
                }


            } else if (num == 2) {
                System.out.print("Enter Name : ");
                String customerName = sc.next();
                System.out.print("Enter password : ");
                String customerPassword = sc.next();

                for (Customer customer : customers){
                    if (customer.getCustomerName().equals(customerName) && customer.getCustomerPassword().equals(customerPassword)) {
                        while (true) {
                            System.out.println("\nMenu:");
                            System.out.println("1. Search products");
                            System.out.println("2. Add items to shopping cart");
                            System.out.println("3. View cart");
                            System.out.println("4. Place an order");
                            System.out.println("5. View order history");
                            System.out.println("6. Track an order");
                            System.out.println("7. Exit");
                            System.out.print("Enter your choice: ");
                            int i = sc.nextInt();

                            if (i == 7) {
                                break;
                            }

                            switch (i){
                                case 1 :
                                    System.out.print("Enter Product Id : ");
                                    int id = sc.nextInt();
                                    System.out.println(inventory.searchProduct(id));
                                    break;

                                case 2 :
                                    System.out.print("Enter product id : ");
                                    int productId = sc.nextInt();
                                    try {
                                        Product product = inventory.searchProduct(productId);
                                        customer.addToCart(product);
                                    }catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;

                                case 3 :
                                    customer.viewCart();
                                    break;

                                case 4 :
                                    System.out.print("Enter address for shipping: ");
                                    sc.nextLine();
                                    String address = sc.nextLine();
                                    customer.placeOrder(address);
                                    break;

                                case 5 :
                                    customer.viewOrderHistory();
                                    break;

                                case 6 :
                                    System.out.print("Enter product name to track: ");
                                    sc.nextLine();
                                    String productNames = sc.nextLine();
                                    customer.trackOrder(productNames);
                                    break;

                                default :
                                    System.out.println("Invalid Option.");
                            }
                        }

                    }else {
                        System.out.println("Please register yourself.");
                        System.out.print("Enter Name : ");
                        String newCustomerName = sc.next();
                        System.out.print("Enter password : ");
                        String newCustomerPassword = sc.next();

                        customers.add(new Customer(newCustomerName, newCustomerPassword));
                        System.out.println("Your Welcome "+ newCustomerName);
                    }
                }
            }else if (num == 3){
                System.exit(0);
            }else {
                System.out.println("Enter correct input.");
            }
        }
    }
}
