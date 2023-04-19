package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.core.exceptions.BusinessExceptions;
import kodlama.io.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
// kullanılmak istenildiğizaman referans oluşturulmasını sağlar. yoksa yapıcı blok içerisinde değişken referans olarak nulla denk düşer
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    // id-den varlık kontolü sağlanmalı
    public void checkExistsCategoryById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessExceptions("Category not exists");
        }
    }

    public void checkExistsCategoryByName(String name) {
        if (!repository.existsCategoriesByName(name)) {
            throw new BusinessExceptions("Category name already exists");
        }
    }

    // aynı isime sahip başka category var mı kontrolü sağlanmalı- repositoryde sorgu yazmalısın
}
