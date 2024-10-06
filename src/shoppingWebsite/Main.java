package shoppingWebsite;

import shoppingWebsite.admin.Admin;
import shoppingWebsite.customer.Customer;
import shoppingWebsite.inventory.Inventory;
import shoppingWebsite.product.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Admin> admins;
    private static final ArrayList<Customer> customers;
    static {
        System.out.println("\n----------- Welcome to GenZ Online Shopping Platform -----------");
        admins = new ArrayList<>();
        admins.add(new Admin("admin", "Admin@123"));

        customers = new ArrayList<>();
        customers.add(new Customer("Virendra", "Virendra@123", "123"));
        customers.add(new Customer("Deepak", "Deepak@123", "1234"));
    }

    public void showCustomersDetails(){
        System.out.println("---------------------------------------------");
        System.out.printf("| %-20s | %-3s %n","User Name", "User Email");
        System.out.println("---------------------------------------------");

        for (Customer customer : customers){
            System.out.printf("| %-20s | %-3s %n",customer.getCustomerName(), customer.getCustomerEmail());
        }

        System.out.println("----------------------------------------------");
    }

    public void removeCustomer(String email){
        int count = 0;
        for (Customer customer : customers){
            if (customer.getCustomerEmail().equalsIgnoreCase(email)){
                customers.remove(customer);
                System.out.println("Customer Removed successfully.");
                count ++;
                break;
            }
        }
        if (count == 0){
            System.out.println("Customer does not exist.");
        }


    }



    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true){
            inventory.displayProducts();
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter : ");

            try {
                int num = sc.nextInt();

                if (num == 1) {
                    System.out.print("Enter Name : ");
                    String adminName = sc.next();
                    System.out.print("Enter password : ");
                    String adminPassword = sc.next();

                    for (Admin ad : admins) {
                        if (ad.getAdminName().equals(adminName) && ad.getAdminPassword().equals(adminPassword)) {
                            ad.admin();

                            Main main = new Main();

                            while(true) {

                                System.out.println("1. Search for products.");
                                System.out.println("2. Add new product.");
                                System.out.println("3. Show users.");
                                System.out.println("4. Delete user.");
                                System.out.println("5. Show all products.");
                                System.out.println("6. Exit");
                                System.out.print("Enter your choice: ");

                                try {
                                    int number = sc.nextInt();

                                    if (number == 6) {
                                        break;
                                    }

                                    switch (number) {
                                        case 1:
                                            System.out.print("Enter Product Id : ");
                                            int id = sc.nextInt();
                                            System.out.println(inventory.searchProduct(id));
                                            break;

                                        case 2:
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

                                        case 3:
                                            main.showCustomersDetails();
                                            break;

                                        case 4:
                                            System.out.print("Enter User Email : ");
                                            String email = sc.next();
                                            main.removeCustomer(email);
                                            break;

                                        case 5:
                                            inventory.displayProducts();
                                            break;

                                        default: {
                                            System.out.println("Invalid choice");
                                        }
                                    }

                                }catch (InputMismatchException e) {

                                    System.out.println("Please enter number not anything else. Thank You !");
                                    sc.nextLine();
                                }
                            }
                        } else {
                            System.out.println("Sorry You are not admin.\n");
                        }
                    }


                } else if (num == 2) {
                    System.out.print("Enter Name : ");
                    String customerName = sc.next();
                    System.out.print("Enter password : ");
                    String customerPassword = sc.next();

                    boolean customerFound = false;

                    for (Customer customer : customers) {
                        if (customer.getCustomerName().equalsIgnoreCase(customerName) && customer.getCustomerPassword().equals(customerPassword)) {
                            customer.customer();
                            customerFound = true;
                            break;
                        }
                    }

                    if (!customerFound) {
                        // Register a new customer outside of the loop
                        System.out.println("Please register yourself.");

                        System.out.print("Enter Name : ");
                        String newCustomerName = sc.next();

                        System.out.print("Enter Email : ");
                        String email = sc.next();

                        System.out.print("Enter Password : ");
                        String newCustomerPassword = sc.next();

                        customers.add(new Customer(newCustomerName, email, newCustomerPassword));
                        System.out.println("Welcome, " + newCustomerName + "!");
                    }

                } else if (num == 3) {
                    System.exit(0);
                } else {
                    System.out.println("Enter correct input.");
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter number not anything else. Thank You !");
                sc.nextLine();
            }
        }
    }
}

