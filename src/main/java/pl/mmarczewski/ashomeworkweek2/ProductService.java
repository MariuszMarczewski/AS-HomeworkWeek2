package pl.mmarczewski.ashomeworkweek2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private List<Product> cart;
    private List<Double> itemPriceList;
    private Info info;
    private int min;
    private int max;

    private int getRandomPrice(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public ProductService() {

        info = new Info();

        min = 50;
        max = 300;

        Product product1 = new Product("Wine", getRandomPrice(50, 300));
        Product product2 = new Product("Whiskey", getRandomPrice(50, 300));
        Product product3 = new Product("Bourbon", getRandomPrice(50, 300));
        Product product4 = new Product("Chivaz", getRandomPrice(50, 300));
        Product product5 = new Product("Cognac", getRandomPrice(50, 300));

        cart = new ArrayList<>();
        cart.add(product1);
        cart.add(product2);
        cart.add(product3);
        cart.add(product4);
        cart.add(product5);

        double tempPrice = cart.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total cart price: " + tempPrice);
        System.out.println(" !!! TEST !!! " + info.getVat());
        System.out.println(" !!! TEST !!! " + info.getDiscount());
        System.out.println(" !!! TEST !!! " + info.getMessage());
    }

    public List<Product> getCart() {
        return cart;
    }

    public double getCartPrice() {
        return cart.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.getCart();
        productService.getCartPrice();
    }
}
