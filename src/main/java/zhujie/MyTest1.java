package zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//指定注解的作用目标为方法
@Retention(RetentionPolicy.RUNTIME)//注解的存活周期
public @interface MyTest1 {

}
