package commonFunctions;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @Description: 常用公共方法
 * 1. 获取 min 与 max 之间的随机 float 类型字符串
 * 2.
 *
 * --------------------------------------
 * @ClassName: commonFunctions.CommonFunctionUtils.java
 * @Date: 2019/10/25 18:15
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class CommonFunctionUtils {
    public static void main(String[] args) {
        // 1.
        System.out.println(randomMoney(30, 60));
    }


    /**
     * @Description: 获取 min 与 max 之间的随机 float 类型字符串
     * @Date: 2019/10/25 18:15
     * @Params: min 下限；max 上限；
     * @ReturnType: String
     **/
    public static String randomMoney(int min, int max) {
        int num = new Random().nextInt(max - min + 1) + min;
        float a = (float) (Math.random());
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num + a);
    }


}
