package kodlama.io.ecommerce.business.dto.request.update;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProductRequest {

    private String name;
    private  int quantity;
    private int price;
    private String description;
    private int categoryId;
}
