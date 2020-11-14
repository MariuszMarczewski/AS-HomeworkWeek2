package pl.mmarczewski.ashomeworkweek2;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ProductService(Info info) {
        this.info = info;

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

        System.out.println("Your order (prices netto and withount discunt): ");
        System.out.println(cart);
        System.out.println(info.getMessage());
        System.out.println("Final order price: " + tempPrice * Double.parseDouble(info.getDiscount())
                * Double.parseDouble(info.getDiscount()));
    }

    public List<Product> getCart() {
        return cart;
    }

    public double getCartPrice() {
        return cart.stream()
                .mapToDouble(cart -> cart.getPrice() * Double.parseDouble(info.getDiscount())
                        * Double.parseDouble(info.getDiscount()))
                .sum();
    }
}
