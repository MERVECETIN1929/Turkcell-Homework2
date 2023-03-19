package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepository() {
        products=new ArrayList<>();
        products.add(new Product(1,"Iphone14",1,120,"dflsdkfjsdfjl"));
        products.add(new Product(2,"ps5",1,120,"dflsdkfjsdfjl"));
        products.add(new Product(3,"xbox",1,120,"dflsdkfjsdfjl"));
        products.add(new Product(4,"ıpad mini",1,120,"dflsdkfjsdfjl"));
        products.add(new Product(5,"Dyson v15",1,120,"dflsdkfjsdfjl"));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if(product.getId()==id){
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public void update(int id, Product product) {
        for (Product product1 : products) {
            if(product1.getId()==id){
                product1.setDescription(product.getDescription());
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setQuantity(product.getQuantity());
                break;
            }
        }
        //products.set()ile de istediğimizi güncelleyebiliriz ancak önce istenilen productın indexini bulmak lazım
    }

    @Override
    public List<Product> getList() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if(product.getId()==id){
                return product;
            }
        }
        return  null;
    }


}
