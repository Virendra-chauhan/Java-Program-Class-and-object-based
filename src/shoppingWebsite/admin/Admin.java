package shoppingWebsite.admin;


import shoppingWebsite.Main;
import shoppingWebsite.inventory.Inventory;
import shoppingWebsite.product.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
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

    public void admin(){
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory("");
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

    }
}


class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}
