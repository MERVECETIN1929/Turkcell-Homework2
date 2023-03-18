package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
        void add(Product product);
        void delete(int id);
        void update(int id,Product product);
        List<Product> getList();
        Product getProductById(int  id);

}
