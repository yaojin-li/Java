package commonFunctions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Description: Java 基本数据类型常用功能集合
 * 1. double、float 保留两位小数
 * 2. 测试 BigDecimal
 * 3.
 * 参考网址：
 * https://www.cnblogs.com/aipan/p/8022312.html
 * --------------------------------------
 * @ClassName: commonFunctions.TestBasicDataType.java
 * @Date: 2019/10/25 18:24
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestBasicDataType {
    public static void main(String[] args) {
        // 1.
        retainDecimals();

        // 2.
        testBigDecimal();

    }


    /**
     * @Description: double、float 保留两位小数
     * @Date:        2019/10/25 18:36
     * @Params:
     * @ReturnType:
     **/
    public static void retainDecimals(){
        // 方法1
        System.out.println(new DecimalFormat("#.00").format(3.1415926));    // 3.14

        // 方法2
        BigDecimal bigDecimal = new BigDecimal(3.14159);
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());     // 3.14
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());      // 3.14

        // 方法3
        System.out.println(String.format("%.2f", 3.14159));     // 3.14

        // 方法4
        NumberFormat ddf1= NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(3);
        System.out.println(ddf1.format(3.14159));       // 3.142
    }


    /**
     * @Description: 测试 BigDecimal
     * @Date:        2019/10/25 19:08
     * @Params:
     * @ReturnType:
     **/
    public static void testBigDecimal() {
        BigDecimal bigDecimal1 = new BigDecimal("10");
        BigDecimal bigDecimal2 = new BigDecimal("4");
        BigDecimal bigDecimal3 = null;
        BigDecimal bigDecimal4 = new BigDecimal("3.1415926");

        // 加
        bigDecimal3 = bigDecimal1.add(bigDecimal2);
        System.out.println("和：" + bigDecimal3); // 和：14

        // 减
        bigDecimal3 = bigDecimal1.subtract(bigDecimal2);
        System.out.println("差：" + bigDecimal3); // 差：6

        // 乘
        bigDecimal3 = bigDecimal1.multiply(bigDecimal2);
        System.out.println("乘：" + bigDecimal3); // 乘：40

        // 除
        bigDecimal3 = bigDecimal1.divide(bigDecimal2);
        System.out.println(bigDecimal3);    // 2.5

        // 保留两位小数，四舍五入
        System.out.println(bigDecimal4.setScale(2, RoundingMode.HALF_UP));  // 3.14


        // 转换
        // Integer => BigDecimal
        BigDecimal bigDecimal = new BigDecimal(new Integer(3));
        System.out.println(bigDecimal); // 3
        // BigDecimal => Integer
        Integer integer1 = bigDecimal.intValue();
        System.out.println(integer1);   // 3


        // String => BigDecimal     String: 数字字符串
        BigDecimal bigDecimal5 = new BigDecimal("9.9000");
        System.out.println(bigDecimal5);    // 9.9000
        // BigDecimal => String
        System.out.println(bigDecimal5.toString()); // 9.9000
        // 避免输出科学计数法。stripTrailingZeros：去除末尾多余的0，toPlainString：避免输出科学计数法的字符串
        System.out.println(bigDecimal5.stripTrailingZeros().toPlainString());   // 9.9


        // Double => BigDecimal
        BigDecimal bigDecimal6 = new BigDecimal(new Double("3.1415"));
        System.out.println(bigDecimal6);    // 3.141500000000000181188397618825547397136688232421875
        // BigDecimal => Double
        Double d = bigDecimal6.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);  // 3.14


        // Float => BigDecimal
        BigDecimal bigDecimal7 = new BigDecimal(new Float("3.1415"));
        System.out.println(bigDecimal7);    // 3.141499996185302734375
        // BigDecimal => Float
        Float f = bigDecimal7.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println(f);      // 3.14
    }

}

