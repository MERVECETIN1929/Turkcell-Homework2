package kodlama.io.ecommerce.business.dto.response.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateProductResponse {

    private String name;
    private int quantity;
    private int price;
    private String description;
    private int categoryId;
}
