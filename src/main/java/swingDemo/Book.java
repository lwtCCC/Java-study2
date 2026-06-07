package swingDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String  title;
    private String  desc;

    @Override
    public String toString() {
        return title;
    }
}
