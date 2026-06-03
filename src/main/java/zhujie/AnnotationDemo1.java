package zhujie;

@MyBook(name = "张三",age = 19,address = "北京")
@A(value = "1")
public class AnnotationDemo1 {

    @MyBook(name = "张三",age = 19,address = {"北京","上海"})
    @A("2")//这里可以去掉value不写
    public static void main(String[] args) {
        //自定义注解

    }
}
