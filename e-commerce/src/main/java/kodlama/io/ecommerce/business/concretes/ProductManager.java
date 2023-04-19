package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.response.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.response.update.UpdateProductResponse;
import kodlama.io.ecommerce.business.rules.ProductBusinessRules;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ProductBusinessRules rules;

    @Override
    public CreateProductResponse add(CreateProductRequest createProductRequest) {
        Product product = modelMapper.map(createProductRequest, Product.class);
        rules.validateProduct(product);
        productRepository.save(product);
        CreateProductResponse createProductResponse = modelMapper.map(product, CreateProductResponse.class);
        return createProductResponse;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest updateProductRequest) {
        // kontrol kodları yazılmalı
        Product product = modelMapper.map(updateProductRequest, Product.class);
        rules.validateProduct(product);
        product.setId(id);
        productRepository.save(product);
        UpdateProductResponse updateProductResponse = modelMapper.map(product, UpdateProductResponse.class);
        return updateProductResponse;
    }

    @Override
    public List<GetAllProductsResponse> getList() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductsResponse> getAllProductsResponses = products.stream()
                .map(product -> modelMapper.map(product, GetAllProductsResponse.class)).toList();
        return getAllProductsResponses;
    }

    @Override
    public GetProductResponse getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        GetProductResponse getProductResponse = modelMapper.map(product, GetProductResponse.class);
        return getProductResponse;
    }


    // *** Product iş kurallarını yazıdığımız metotlar ***
    // her if için ne hatası döndüğünü kapsamlı verir
    // her iş için tek tek ayrı methotlar da kullanılır


}
