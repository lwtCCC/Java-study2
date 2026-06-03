package proxyDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Start implements StartService {
    private String name;

    @Override
    public void dance() {
        System.out.println(this.name + "dance");
    }

    @Override
    public void sing() {
        System.out.println(this.name + "sing");
    }

}
