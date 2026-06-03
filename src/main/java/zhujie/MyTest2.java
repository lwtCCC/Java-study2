package zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})//指定注解的作用对象为方法和类
public @interface MyTest2 {
}
