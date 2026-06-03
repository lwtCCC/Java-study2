package reflectDemo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

public class ReflectDemo2 {

    public static void main(String[] args) {

    }

    @Test
    //1.获取类名
    public void getClassInfo() {
        //获取类的信息
        Class<Student> c = Student.class;

        System.out.println(c.getName());//获取类名本身（全类名）
        System.out.println(c.getSimpleName());//获取类名本身（简单类名）
    }

    @Test
    //2.获取构造器对象
    public void getConstructorInfo() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Dog> c = Dog.class;
       /* //获取所有的构造器(包括私有)
        Constructor<?>[] cons = c.getDeclaredConstructors();
        for (Constructor<?> con : cons) {
            System.out.println(con.getName() + "(" + con.getParameterCount() + ")");
        }*/

        //获取单个构造器，根据参数来获取(无参构造器)
        Constructor<Dog> con = c.getDeclaredConstructor();
        System.out.println(con.getName() + "(" + con.getParameterCount() + ")");

        //有参构造器
        Constructor<Dog> con2 = c.getDeclaredConstructor(String.class, int.class);
        System.out.println(con2.getName() + "(" + con2.getParameterCount() + ")");

        //通过获取的构造器创建对象
        con.setAccessible(true);//获得执行权限
        Dog dog = con.newInstance();

        Dog dog1 = con2.newInstance("zhangsan", 23);

       /* //获取所有的构造器(非私有)
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor<?> con : constructors) {
            System.out.println(con.getName());
        }*/
    }

    @Test
    public void getMethodInfo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Dog> c = Dog.class;
        Method[] ms = c.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(m.getName() + "(" + m.getParameterCount() + ")");
            System.out.println(Arrays.toString(m.getParameterTypes()));
        }

        System.out.println("-------------------------------------");

        //获取指定的方法
        Method m = c.getDeclaredMethod("setName", String.class);
        System.out.println(m.getName() + "(" + m.getParameterCount() + ")");

        Method m1 = c.getDeclaredMethod("eat");
        System.out.println(m1.getName() + "(" + m1.getParameterCount() + ")");

        Dog dog = new Dog("zhangsan", 23);
        m1.setAccessible(true);
        m1.invoke(dog);//唤醒方法去执行，相当于dog.eat()

        Method m2 = c.getDeclaredMethod("eat", String.class);
        String s = (String) m2.invoke(dog, "牛肉");//有返回值
        System.out.println("m2方法的返回值:" + s);
    }

    @Test
    public void getFieldInfo() throws NoSuchFieldException, IllegalAccessException {
        Class<Dog> c = Dog.class;
        Field[] df = c.getDeclaredFields();//获取所有的变量
        for (Field f : df) {
            System.out.println(f.getName() + "(" + f.getType().getName() + ")");
        }
        //获取单个
        Field name = c.getDeclaredField("name");
        System.out.println(name.getName() + "(" + name.getType().getName() + ")");

        Dog dog = new Dog("小黑", 10);
        //对私有变量进行修改
        name.setAccessible(true);
        name.set(dog, "小白");
        System.out.println(dog);
        //获取私有变量的值
        String s = (String) name.get(dog);
        System.out.println(s);
    }

}
