package kodlama.io.ecommerce.api.controllers;


import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @PostMapping//productı nereden alacağını söylememiz lazım
    @ResponseStatus(HttpStatus.CREATED)
    void add(@RequestBody CreateProductRequest product) {
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable int id, @RequestBody UpdateProductRequest product) {
        productService.update(id, product);
    }

    @GetMapping
    List<GetAllProductsResponse> getList() {
        return productService.getList();
    }

    @GetMapping("/{id}")
    GetProductResponse getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
    //request paramda / koyuyorsun ama urlde ? nitelik=x mantığıyla çalışır. bir veri dönecek ama hangi niteliğe sahip olduğunu
}
