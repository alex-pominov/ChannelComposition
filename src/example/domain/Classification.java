package example.domain;

import lombok.*;

/**
 * @author Pominov Alexander
 */
@Getter
@Setter
@NoArgsConstructor
public class Classification {
    private String id;
    private String description;

    public Classification(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
