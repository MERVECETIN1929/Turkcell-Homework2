package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {

            validateProduct(product);
            productRepository.add(product);


    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(int id, Product product) {
        validateProduct(product);
        productRepository.update(id, product);

    }

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getById(id);
    }


    // *** Product iş kurallarını yazıdığımız metotlar ***
    // her if için ne hatası döndüğünü kapsamlı verir
    // her iş için tek tek ayrı methotlar da kullanılır
    private boolean validateProduct(Product product) {
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLength(product);

        return true;
    }

    private void checkIfDescriptionLength(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Açıklama kısmını dikkatli yaz ");
    }

    private void checkIfPriceValid(Product product) {
        if (product.getPrice() <= 0) throw new IllegalArgumentException("fiyat 0dan küçük olamaz ");
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new IllegalArgumentException("Miktar 0dan küçük olamaz ");
    }

}
