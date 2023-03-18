package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        boolean result=check(product);
        if(result){
            productRepository.add(product);
        }
        else{
            System.err.println("Bilgilerin kurallara uygun olduğuna emin olunuz");
        }

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(int id, Product product) {
        if(check(product)){
            productRepository.update(id,product);
        }
        else{
            System.err.println("Bilgilerin kurallara uygun olduğuna emin olunuz");
        }
    }

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public Product getProductById(int id) {
        List<Product> products=this.productRepository.getList();
        for (Product product : products) {
            if(product.getId()==id){
                return product;
            }
        }
        throw new RuntimeException("aranan ürün bulunamadı");
    }
    public boolean check(Product product){
        //
        if(product.getPrice()<= 0 &&  product.getQuantity()<= 0 && (product.getDescription().length()<10 || product.getDescription().length()>50)){

            return false;
        }
       return true;
    }
}
