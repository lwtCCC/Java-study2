package reflectDemo;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类的class对象

        //方法1
        Class c1 = Student.class;
        System.out.println(c1);

        //方法2
        Class c2 = Class.forName("reflectDemo.Student");
        System.out.println(c2);

        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));

        //方法3,通过对象获取
        Student s1 = new Student();
        Class<? extends Student> c3 = s1.getClass();
        System.out.println(c3);

        System.out.println(c2 == c3);

    }
}
