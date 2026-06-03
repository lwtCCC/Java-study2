package proxyDemo;

import static proxyDemo.ProxyUtil.createProxy;

public class Test {
    public static void main(String[] args) {
        //实现代理

        //创建对象
        Start star = new Start("罗薇塔");
        //创建代理
        //System.out.println(createProxy(star).getClass());
        StartService proxy = createProxy(star);
        proxy.sing();
        proxy.dance();
    }
}
