package reflectDemo;


import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo4 {
    public static void main(String[] args) throws IllegalAccessException {
        Student s1 = new Student("zhangsan", 123);
        Student s2 = new Student("lisi", 12);
        List<Student> l1 = new ArrayList<>();
        l1.add(s1);
        l1.add(s2);

        Dog d1 = new Dog("xiaohei", 1);
        Dog d2 = new Dog("wangwu", 1);
        List<Dog> l2 = new ArrayList<>();
        l2.add(d1);
        l2.add(d2);

        Class<Student> c1 = Student.class;

        Field[] list1 = c1.getDeclaredFields();
        for (Student s : l1) {
            for (Field field : list1) {
                field.setAccessible(true);
                Object o = field.get(s);
                System.out.println(field.getName()+":"+o);
            }
        }

        Class<Dog> c2 = Dog.class;
        Field[] list2 = c2.getDeclaredFields();
        for (Dog d : l2) {
            for (Field field : list2) {
                field.setAccessible(true);
                Object o = field.get(d);
                System.out.println(field.getName()+":"+o);
            }
        }

    }
}
