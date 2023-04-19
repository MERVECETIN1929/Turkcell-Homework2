package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.response.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.response.update.UpdateProductResponse;
import kodlama.io.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
        CreateProductResponse add(CreateProductRequest product);
        void delete(int id);
        UpdateProductResponse update(int id, UpdateProductRequest product);
        List<GetAllProductsResponse> getList();
        GetProductResponse getProductById(int  id);

}
