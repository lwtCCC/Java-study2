package reflectDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //反射获取列表
        ArrayList<String> list = new ArrayList<>();

        Class c = List.class;

        Method a = c.getDeclaredMethod("add",Object.class);
        Object o = a.invoke(list,1);
        System.out.println(list);
    }
}
