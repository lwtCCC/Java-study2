package proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 代理工具类
* */
public class ProxyUtil {
    public static StartService createProxy(Start s) {
        //参数1；类加载器
        //参数2：实现接口类
        //参数3：指定代理对象做的事情
        return (StartService) Proxy.newProxyInstance(Start.class.getClassLoader(),
                s.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //参数1：代理对象本身
                        //参数2：正在被代理的方法
                        //参数3：方法的参数
                        String name = method.getName();
                        if ("dance".equals(name)) {
                            System.out.println("准备舞台");
                        } else if ("sing".equals(name)) {
                            System.out.println("准备话筒");
                        }
                        return method.invoke(s, args);
                    }
                });
    }
}
