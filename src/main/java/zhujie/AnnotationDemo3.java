package zhujie;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo3 {
    //解析注解
    @Test
    public void paresClass() {
        Class c = Demo.class;
        //判断c类上是否有MyTest7注解
        if (c.isAnnotationPresent(MyTest7.class)) {
            //获取注解对象
            MyTest7 a = (MyTest7)c.getAnnotation(MyTest7.class);

            String value = a.value();
            double aaa = a.aaa();
            String[] bbb = a.bbb();
            System.out.println(value);
            System.out.println(aaa);
            System.out.println(Arrays.toString(bbb));
        }
    }

    @Test
    public void paresMethod() throws NoSuchMethodException {
        Class c = Demo.class;
        Method test1 = c.getDeclaredMethod("test1");
        //判断c类上是否有MyTest7注解
        if (test1.isAnnotationPresent(MyTest7.class)) {
            //获取注解对象
            MyTest7 a = (MyTest7)test1.getAnnotation(MyTest7.class);
            String value = a.value();
            double aaa = a.aaa();
            String[] bbb = a.bbb();
            System.out.println(value);
            System.out.println(aaa);
            System.out.println(Arrays.toString(bbb));
        }

    }
}
