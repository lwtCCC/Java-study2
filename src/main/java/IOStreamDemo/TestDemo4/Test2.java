package IOStreamDemo.TestDemo4;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String s = HttpUtil.get("https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0");
        List<String> all = ReUtil.findAll("(\\W{4})(，|。)", s, 1);
        System.out.println(all);

    }
}
