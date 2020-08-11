package example.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Pominov Alexander
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Attribute {
    private String id;
    private String description;

    public Attribute(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
