package kodlama.io.ecommerce.business.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateProductResponse {
    private int id;
    private String name;
    private  int quantity;
    private int price;
    private String description;
    private int categoryId;
}
