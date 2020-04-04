/**
 * @Description: 给定两个表示复数的字符串。
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * <p>
 * 示例 1:
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * <p>
 * 示例 2:
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * <p>
 * 注意:
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 * --------------------------------------
 * @ClassName: test_537.java
 * @Date: 2019/6/1 22:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_537 {
    public static void main(String[] args) {
        String a = "3+-5i";
        String b = "2+-1i";
        Solution_537 solution = new Solution_537();
        System.out.println(solution.complexNumberMultiply(a, b));
    }
}

class Solution_537 {
    /**
     * @Description: 1. +分割
     * 2. 提取相乘项
     * 3. 计算
     * 4. 拼接 0+ 的形式
     * @Date: 2019/6/1 22:55
     * @Params:
     * @ReturnType:
     **/
    public String complexNumberMultiply(String a, String b) {
        String[] aStr = a.split("\\+");
        String[] bStr = b.split("\\+");

        int aInt = Integer.valueOf(aStr[0]);
        int bInt = Integer.valueOf(bStr[0]);
        int aiInt = Integer.valueOf(aStr[1].substring(0, aStr[1].indexOf("i")));
        int biInt = Integer.valueOf(bStr[1].substring(0, bStr[1].indexOf("i")));

        int one = aInt * bInt;//整数
        int two = aiInt * bInt + biInt * aInt;//x i
        int three = aiInt * biInt;//整数

        return String.valueOf(one - three) + "+" + String.valueOf(two) + "i";
    }
}