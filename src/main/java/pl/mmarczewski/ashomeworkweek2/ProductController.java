package pl.mmarczewski.ashomeworkweek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> get() {
        return productService.getCart();
    }

    @GetMapping("/price")
    public double getCartPrice(){
        return productService.getCartPrice();
    }
}
