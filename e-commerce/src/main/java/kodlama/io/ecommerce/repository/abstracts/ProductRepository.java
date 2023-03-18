package kodlama.io.ecommerce.repository.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository {
    void add(Product product);
    void delete(int id);
    void update(int id,Product product);
    List<Product> getList();

}