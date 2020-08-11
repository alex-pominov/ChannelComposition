package example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pominov Alexander
 */
@Getter
@Setter
@NoArgsConstructor
public class Products {
    private String name;
    private double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
