package kodlama.io.ecommerce.api.controller;


import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/add")
    void add(@RequestBody  Product product){
        productService.add(product);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable int id){
        productService.delete(id);
    }
    @PutMapping("/update/{id}")
    void update(@PathVariable int id,@RequestBody  Product product){
        productService.update(id,product);
    }
    @GetMapping("/gelAll")
    List<Product> getList(){
        return productService.getList();
    }
    @GetMapping("/getById/{id}")
    Product getProductById(@PathVariable  int  id){
        return productService.getProductById(id);
    }
}
