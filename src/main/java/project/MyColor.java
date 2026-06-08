package project;

import java.awt.*;
import java.io.Serializable;

public class MyColor extends Color implements Serializable {

    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public MyColor(Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue());
    }

    @Override
    public String toString() {
        int r = getRed();
        int g = getGreen();
        int b = getBlue();

        // 常见颜色匹配
        if (r == 255 && g == 0 && b == 0) return "red";
        if (r == 0 && g == 255 && b == 0) return "green";
        if (r == 0 && g == 0 && b == 255) return "blue";
        if (r == 255 && g == 255 && b == 0) return "yellow";
        if (r == 0 && g == 0 && b == 0) return "black";
        if (r == 255 && g == 255 && b == 255) return "white";
        if (r == 128 && g == 128 && b == 128) return "gray";
        if (r == 255 && g == 200 && b == 0) return "orange";
        if (r == 255 && g == 175 && b == 175) return "pink";
        if (r == 0 && g == 255 && b == 255) return "cyan";
        if (r == 255 && g == 0 && b == 255) return "magenta";

        // 深色系
        if (r == 128 && g == 0 && b == 0) return "darkred";
        if (r == 0 && g == 128 && b == 0) return "darkgreen";
        if (r == 0 && g == 0 && b == 128) return "darkblue";
        if (r == 128 && g == 128 && b == 0) return "darkyellow";

        // 浅色系
        if (r == 255 && g == 182 && b == 193) return "lightpink";
        if (r == 144 && g == 238 && b == 144) return "lightgreen";
        if (r == 173 && g == 216 && b == 230) return "lightblue";

        // 其他常见颜色
        if (r == 128 && g == 0 && b == 128) return "purple";
        if (r == 255 && g == 165 && b == 0) return "orange";
        if (r == 165 && g == 42 && b == 42) return "brown";
        if (r == 64 && g == 224 && b == 208) return "turquoise";
        if (r == 238 && g == 130 && b == 238) return "violet";
        if (r == 192 && g == 192 && b == 192) return "silver";
        if (r == 128 && g == 128 && b == 0) return "olive";

        // 默认返回 RGB 字符串
        return String.format("rgb(%d,%d,%d)", r, g, b);
    }

}
