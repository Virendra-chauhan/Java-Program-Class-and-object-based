package c;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private String adminName;
    private String adminPassword;

    Admin(String adminName, String adminPassword){
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminName(){
        return this.adminName;
    }

    public void setAdminName(String adminName){
        this.adminName = adminName;
    }

    public String getAdminPassword(){
        return this.adminPassword;
    }

    public void setAdminPassword(String password){
        this.adminPassword = adminPassword;
    }



}
class Customer{
    private String customerName;
    private String customerPassword;

    Customer(String customerName, String customerPassword){
        this.customerName = customerName;
        this.customerPassword = customerPassword;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerPassword(){
        return this.customerPassword;
    }

    public void setPassword(String customerPassword){
        this.customerPassword = customerPassword;
    }
}
class Shipping{
    private String name, phoneNo, address, state, pincode;

//    Shipping(String name, String phoneNo, String address, String state, String pincode){
//        this.name = name;
//        this.phoneNo = phoneNo;
//        this.address = address;
//        this.state = state;
//        this.pincode = pincode;
//    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhoneNo(){
        return this.phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getPincode(){
        return this.pincode;
    }
    public void setPincode(String pincode){
        this.pincode = pincode;
    }
}

class Order extends Shipping{
    private String newProductName;
    private double newProductPrice;
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Shipping> shippings = new ArrayList<>();

    Order() {
        super();
    }

    public String getNewProductName(){
        return this.newProductName;
    }
    public void setNewProductName(String newProductName){
        this.newProductName = newProductName;
    }

    public double getNewProductPrice(){
        return this.newProductPrice;
    }
    public void setNewProductPrice(double newProductPrice){
        this.newProductPrice = newProductPrice;
    }


    public void addOrder(Order o){
        orders.add(o);
    }


}

class Payment{

}
class Product{
    private String productName;
    private double price;

    Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }

    public String getProductName(){
        return this.productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
class Inventory{
    List<Product> productList ;

    public Inventory(){
       productList = new ArrayList<>();
       productList.add(new Product("Moisturizer", 299));
       productList.add(new Product("Sunscreen", 199));
       productList.add(new Product("Facial Cleanser", 349));
       productList.add(new Product("Toner", 159));
       productList.add(new Product("Serum", 179));
       productList.add(new Product("Eye Cream", 249));
       productList.add(new Product("Face Mask", 389));
       productList.add(new Product("Eyeliner", 499));
       productList.add(new Product("Lipstick", 489));
       productList.add(new Product("Shampoo", 199));

   }

   public void addItems(Product p){
        productList.add(p);
       System.out.println("added...");
   }

   public void removeItems(String itemName){
        int count = 0;
        for (Product p : productList){
            if (p.getProductName().equalsIgnoreCase(itemName)) {
                count++;
            }
        }
       productList.removeIf(pro -> pro.getProductName().equalsIgnoreCase(itemName));
        if (count > 0){
            System.out.println("removed...\n");
        }else {
            System.out.println(itemName + " does not match.\n");
        }
   }

   public void showAllItems(){
       System.out.println("----------------------------------------------------------------");
       System.out.printf("| %-10s | %-33s | %-5s %n","Id", "Product Name", "Price");
       System.out.println("----------------------------------------------------------------");
       int count = 1;

       for (Product product : productList){
           System.out.printf("| %-10s | %-33s | %-5s %n",count, product.getProductName(), product.getPrice());
           count ++;
       }

       System.out.println("----------------------------------------------------------------");
   }
}

class ShoppingCart{

}
class Main{
    private static ArrayList<Admin> admins ;
    private static ArrayList<Customer> customers ;
    static {
        System.out.println("\n----------- Welcome to GenZ Online Shopping Platform -----------");
        admins = new ArrayList<>();
        admins.add(new Admin("admin", "Admin@123"));

        customers = new ArrayList<>();
        customers.add(new Customer("Virendra", "Virendra@123"));
        customers.add(new Customer("Deepak", "Deepak@123"));
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Order orders = new Order();


        while (true){
            inventory.showAllItems();
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

                        while(true){
                            System.out.println("\nMenu:");
                            System.out.println("1. Search for products");
                            System.out.println("2. Add to cart");
                            System.out.println("3. Add new product");
                            System.out.println("4. Place order");
                            System.out.println("5. View order history");
                            System.out.println("6. Set shipping method");
                            System.out.println("7. Exit");
                            System.out.print("Enter your choice: ");


                            System.out.println("1. Add Items.");
                            System.out.println("2. Remove Items.");
                            System.out.println("3. Show All Items.");
                            System.out.println("4. Exit");
                            System.out.print("Enter choice: ");

                            int no = sc.nextInt();

                            if (no == 4){
                                break;
                            }

                            switch (no){
                                case 1 :
                                    System.out.print("Enter Product Name : ");
                                    String pn = sc.next();
                                    System.out.print("Enter Price : ");
                                    double p = sc.nextDouble();

                                    inventory.addItems(new Product(pn , p));
                                    break;

                                case 2 :
                                    System.out.print("Enter Product Name : ");
                                    String productName = sc.next();
                                    inventory.removeItems(productName);

                                    break;

                                case 3 :
                                    inventory.showAllItems();
                                    break;

                                default :{
                                    System.out.println("Invalid choice");
                                }
                            }

                        }
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
                        while (true){
                            System.out.println("1. Buy Product.");
                            System.out.println("2. Add to Cart.");
                            System.out.println("3. Exit");
                            System.out.print("Enter your choice : ");
                            int i = sc.nextInt();

                            if (i == 1){
                                inventory.showAllItems();
                                System.out.print("Enter Product Name : ");
                                String st = sc.next();
                                for (Product product : inventory.productList){
                                    if (product.getProductName().equals(st)){
                                        orders.setNewProductName(st);
                                        orders.setNewProductPrice(product.getPrice());
                                    }
                                }
                                System.out.println("Fill Your Order Details.");
                                System.out.print("Enter Your Name : ");
                                String name = sc.next();
                                System.out.print("Enter Your Phone Number : ");
                                String phoneNo = sc.next();
                                System.out.print("Enter Your Address : ");
                                String address = sc.next();
                                System.out.print("Enter Your State : ");
                                String state = sc.next();
                                System.out.println("Enter Pincode : ");
                                String pincode = sc.next();
                            }

                        }

                    }else {
                        System.out.println("Please register yourself.");
                        System.out.print("Enter Name : ");
                        String newCustomerName = sc.next();
                        System.out.print("Enter password : ");
                        String newCustomerPassword = sc.next();

                        customers.add(new Customer(newCustomerName, newCustomerPassword));
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