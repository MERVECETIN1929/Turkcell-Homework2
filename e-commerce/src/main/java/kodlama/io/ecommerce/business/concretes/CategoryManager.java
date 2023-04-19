package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.dto.request.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.request.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.business.dto.response.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.response.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> categoriesResponses = categories.stream().map(category -> mapper.map(category, GetAllCategoriesResponse.class)).toList();

        return categoriesResponses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse getCategoryResponse = mapper.map(category, GetCategoryResponse.class);
        return getCategoryResponse;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);
        CreateCategoryResponse createCategoryResponse = mapper.map(category, CreateCategoryResponse.class);
        return createCategoryResponse;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);
        UpdateCategoryResponse categoryResponse = mapper.map(category, UpdateCategoryResponse.class);
        return categoryResponse;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
