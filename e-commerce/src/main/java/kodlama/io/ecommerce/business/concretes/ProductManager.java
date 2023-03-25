package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
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
            productRepository.save(product);


    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(int id, Product product) {
        validateProduct(product);
        product.setId(id);
        productRepository.save(product);

    }

    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow();
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
