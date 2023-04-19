package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.dto.request.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.request.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.business.dto.response.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService service;

    @PostMapping//productı nereden alacağını söylememiz lazım
    @ResponseStatus(HttpStatus.CREATED)
    void add(@RequestBody CreateCategoryRequest product) {
        service.add(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable int id, @RequestBody UpdateCategoryRequest product) {
        service.update(id, product);
    }

    @GetMapping
    List<GetAllCategoriesResponse> getList() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetCategoryResponse getProductById(@PathVariable int id) {
        return service.getById(id);
    }
}
