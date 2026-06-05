package swingDemo;

import lombok.*;

import javax.swing.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String name;
    String desc;
    Icon icon;

    @Override
    public String toString() {
        return name;
    }
}
