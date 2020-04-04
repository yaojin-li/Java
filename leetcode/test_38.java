/**
 * @Description:
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * --------------------------------------
 * @ClassName: test_38.java
 * @Date: 2019/5/5 9:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_38 {
    public static void main(String args[]) {
        int n = 5;
        Solution_38 solution = new Solution_38();
        System.out.println(solution.countAndSayOne(n));
    }
}

class Solution_38 {
    public String countAndSayOne(int n) {
        StringBuilder input = new StringBuilder("1");
        if (n == 1) return "1";

        //每次遍历获取每个数字对应的结果
        for (int i = 2; i <= n; i++) {
            input = result(input);
        }
        return input.toString();
    }

    public StringBuilder result(StringBuilder input) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char firstChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {//当前值与其后的内容比较
            char now = input.charAt(i);
            if (firstChar == now) {
                count++;
            } else {
                builder.append(count).append(firstChar);
                firstChar = now;//更新当前指针
                count = 1;//重置次数
            }
        }
        //末尾加上最初的次数与对应的char
        builder.append(count).append(firstChar);
        return builder;
    }
}
