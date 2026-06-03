package MyReflectDemo;

public class MyReflectedDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        *反射
        * 获取Class对象的三种方式
        * */
        //方法1
        Class<?> clazz = Class.forName("MyReflectDemo.Student");
        System.out.println(clazz);

        //方法2
        Class clazz1 = Student.class;
        System.out.println(clazz1);

        System.out.println(clazz == clazz1);//true

        //方法3
        Student s = new Student();
        Class clazz2 = s.getClass();
        System.out.println(clazz2);

        System.out.println(clazz == clazz2);//true


    }
}
