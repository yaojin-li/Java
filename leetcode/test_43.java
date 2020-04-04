import java.util.Collections;

/**
 * @Description: 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * --------------------------------------
 * @ClassName: test_43.java
 * @Date: 2019/7/1 19:38
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        Solution_43 solution = new Solution_43();
        System.out.println(solution.multiply(num1, num2));
    }
}


class Solution_43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] resultArr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // ASCII码，将字符转换成数字，数字0对应的ASCII为48
                int tempOne = num1.charAt(i) - 48;
                int tempTwo = num2.charAt(j) - 48;
                // 最低位上的数字累加
                resultArr[i + j] += tempOne * tempTwo;
                if (resultArr[i + j] >= 10 && (i + j) != 0) {
                    // 进位累加
                    resultArr[i + j - 1] += resultArr[i + j] / 10;
                    resultArr[i + j] = resultArr[i + j] % 10;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        // 结果的最大位数为 len1 + len2 - 1
        for (int i = 0; i < len1 + len2 - 1; i++) {
            sb.append(resultArr[i]);
        }
        return sb.toString();
    }

}