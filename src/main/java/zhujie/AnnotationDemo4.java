package zhujie;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationDemo4 {
    //手动实现Test

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        AnnotationDemo4 a = new AnnotationDemo4();
        Class c = AnnotationDemo4.class;

        Method[] mlist = c.getDeclaredMethods();
        for (Method m : mlist) {
            if (m.isAnnotationPresent(MyTest8.class)) {
                m.setAccessible(true);
                Object o = m.invoke(a);
            }
        }
    }

    @MyTest8()
    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }

    @MyTest8()
    public void test3(){
        System.out.println("test3");
    }

    public void test4(){
        System.out.println("test4");
    }
}
