package zhujie;

public @interface A {
    String value();//特殊属性,在使用时如果只有一个value属性，value名称可以不写，具体见AnnotationDemo1类
    String hobby() default "";//如果有默认值也可以不写
}
