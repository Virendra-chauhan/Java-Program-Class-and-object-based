package shoppingWebsite.inventory;

import shoppingWebsite.product.Product;

import java.util.HashMap;

public class Inventory {
     HashMap<Integer, Product> productsList = new HashMap<>(); ;
    public Inventory(){
        this("");
    }
    public Inventory(String s) {

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

    public Product searchProduct(int productId) {
        try{
            if (!productsList.containsKey(productId)) {
                throw new SearchException("Product not found.");
            }

        }catch (SearchException se){
            System.out.println(se.getMessage());
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

class SearchException extends Exception{
   public SearchException(String s){
       super(s);
   }
}