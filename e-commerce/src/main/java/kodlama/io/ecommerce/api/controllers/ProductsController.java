package kodlama.io.ecommerce.api.controllers;


import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping//productı nereden alacağını söylememiz lazım
    @ResponseStatus(HttpStatus.CREATED)
    void add(@RequestBody Product product) {
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable int id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @GetMapping
    List<Product> getList() {
        return productService.getList();
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
    //request paramda / koyuyorsun ama urlde ? nitelik=x mantığıyla çalışır. bir veri dönecek ama hangi niteliğe sahip olduğunu
}
