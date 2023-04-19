package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.request.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.request.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.business.dto.response.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.business.dto.response.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.response.update.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();

    GetCategoryResponse getById(int id);

    CreateCategoryResponse add(CreateCategoryRequest request);

    UpdateCategoryResponse update(int id, UpdateCategoryRequest request);

    void delete(int id);
}
