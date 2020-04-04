/**
 * @Description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式。
 * --------------------------------------
 * @ClassName: test_415.java
 * @Date: 2019/5/11 14:10
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_415 {
    public static void main(String args[]) {
        String num1 = "9999999";
        String num2 = "9999999";
        Solution_415 solution = new Solution_415();
//        System.out.println(solution.addStrings(num1, num2));
        int a = num1.charAt(3) - '0';
        System.out.println();
    }
}

class Solution_415 {
    /**
     * @Description: 从后往前截取，对位相加，进位加到前一位的计算中，计算对位和；
     * 除10作为该位值，余10作为进位值，再拼接返回结果；
     * @Date: 2019/5/11 22:00
     * @Params:
     * @ReturnType:
     **/
    public String addStrings(String num1, String num2) {
        //开始补0
        if (num1.length() > num2.length()) {
            StringBuilder sb = new StringBuilder();
            int zeroNum = num1.length() - num2.length();
            for (int i = 0; i < zeroNum; i++) {
                sb.append("0");
            }
            num2 = sb.toString() + num2;
        } else {
            StringBuilder sb = new StringBuilder();
            int zeroNum = num2.length() - num1.length();
            for (int i = 0; i < zeroNum; i++) {
                sb.append("0");
            }
            num1 = sb.toString() + num1;
        }

        int addNum = 0;//进位
        int index = 0;
        int[] temp = new int[num1.length() + 1];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int one = getInt(num1.charAt(i));
            int two = getInt(num2.charAt(i));
            int sum = one + two + addNum;
            if (sum >= 10) {
                temp[index] = sum % 10;
                addNum = sum / 10;
            } else {
                temp[index] = sum;
                addNum = 0;
            }
            index++;
        }
        temp[num1.length()] = addNum;
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            sb.append(temp[i]);
        }
        if (sb.charAt(0) == '0') {
            return sb.substring(1, sb.length());
        }
        return sb.toString();
    }

    //字符转数字 直接字符'9'-'0' 返回对应的数字
    public int getIntFromChar(char ch) {
        return ch - '0';
    }

    //switch case 匹配数字
    public int getInt(char ch) {
        String s = String.valueOf(ch);
        int res = 0;
        switch (s) {
            case "0":
                res = 0;
                break;
            case "1":
                res = 1;
                break;
            case "2":
                res = 2;
                break;
            case "3":
                res = 3;
                break;
            case "4":
                res = 4;
                break;
            case "5":
                res = 5;
                break;
            case "6":
                res = 6;
                break;
            case "7":
                res = 7;
                break;
            case "8":
                res = 8;
                break;
            case "9":
                res = 9;
                break;
        }
        return res;
    }


    /**
     * @Description: 将进位作为判断条件
     * @Date:        2019/5/19 22:24
     * @Params:
     * @ReturnType:
     **/
    public String addStringsTwo(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry == 1;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

}