package zhujie;

@MyTest2
public class AnnotationDemo2 {

    @MyTest3
    private String name;

    @MyTest5
    public AnnotationDemo2() {}

    @MyTest1
    @MyTest2
    public static void main(String[] args) {
        //元注解
        @MyTest6
        int age;
    }

    @MyTest1
    @MyTest2
    public void test(@MyTest4 String x){}
}
