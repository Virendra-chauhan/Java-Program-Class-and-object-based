package shoppingWebsite.shoppingCart;

import shoppingWebsite.product.Product;

import java.util.ArrayList;

public class ShoppingCart {

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

