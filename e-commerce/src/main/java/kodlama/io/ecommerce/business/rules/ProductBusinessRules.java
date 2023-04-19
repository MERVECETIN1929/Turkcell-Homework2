package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.core.exceptions.BusinessExceptions;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service // ıoc de referansı oluşmalı yoksa biz newlemek zorunda kalırız
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfDescriptionLength(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new BusinessExceptions("Açıklama kısmını dikkatli yaz ");
    }

    public void checkIfPriceValid(Product product) {
        if (product.getPrice() <= 0) throw new BusinessExceptions("fiyat 0dan küçük olamaz ");
    }

    public void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new BusinessExceptions("Miktar 0dan küçük olamaz ");
    }

    public boolean validateProduct(Product product) {
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLength(product);
        return true;
    }
}
