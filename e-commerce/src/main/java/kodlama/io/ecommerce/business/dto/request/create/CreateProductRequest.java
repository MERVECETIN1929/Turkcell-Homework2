package kodlama.io.ecommerce.business.dto.request.create;

import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductRequest {

    private String name;

    private  int quantity;

    private int price;

    private String description;


    private int categoryID;

}
