
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * <p>
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * 要求:
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 * --------------------------------------
 * @ClassName: test_541.java
 * @Date: 2019/5/11 9:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_541 {
    public static void main(String args[]) {
        String s = "abcdefg";
        int k = 2;
        Solution_541 solution = new Solution_541();
        System.out.println(solution.reverseStrOne(s, k));
        System.out.println(solution.reverseStrTwo(s, k));
    }
}

class Solution_541 {
    /**
     * @Description: 截取，反转
     * @Date: 2019/5/11 11:56
     * @Params:
     * @ReturnType:
     **/
    public String reverseStrOne(String s, int k) {
        List<char[]> list = new ArrayList<>();//存储2k截取后的字符串
        int len = s.length() / 2 / k + 1;//分割后的字符串数组大小

        // 根据2k截取成字符串数组
        for (int i = 0; i < len; i++) {
            if ((i + 1) * 2 * k > s.length()) {
                list.add(s.substring(i * 2 * k).toCharArray());
            } else {
                list.add(s.substring(i * 2 * k, (i + 1) * 2 * k).toCharArray());
            }
        }

        // 遍历每个字符串长度。
        // 若该字符串长度=2k，反转前k个字符；
        // 若该字符串长度<k，全部反转；
        // 若该字符串长度<2k && >=k，则反转前 k 个字符，并将剩余的字符保持原样。
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i);
            if (chars.length == 2 * k) {
                result.append(reverse(chars, k));
            } else if (chars.length < k) {
                result.append(reverse(chars, 0));
            } else {
                result.append(reverse(chars, k));
            }
        }
        return result.toString();
    }

    public char[] reverse(char[] chars, int k) {
        //全反转
        if (k == 0) {
            for (int i = 0, len = chars.length - 1; i < len; i++) {//等同于while()中双指针判断
                char temp = chars[i];
                chars[i] = chars[len];
                chars[len] = temp;
                len--;//移动右指针
            }
        } else {
            //反转前k个
            for (int i = 0; i < k; i++) {
                char temp = chars[i];
                chars[i] = chars[k - 1];
                chars[k - 1] = temp;
                k--;//移动右指针
            }
        }
        return chars;
    }



    public String reverseStrTwo(String s, int k) {
        List<String> list = new ArrayList<>();//存储2k截取后的字符串
        StringBuilder result = new StringBuilder();
        int len = s.length() / 2 / k + 1;

        // 根据2k截取成字符串数组
        for (int i = 0; i < len; i++) {
            if ((i + 1) * 2 * k > s.length()) {
                list.add(i, s.substring(i * 2 * k));
            } else {
                list.add(i, s.substring(i * 2 * k, (i + 1) * 2 * k));
            }
        }

        // 遍历每个字符串长度。
        // 若该字符串长度=2k，反转前k个字符；
        // 若该字符串长度<k，全部反转；
        // 若该字符串长度<2k && >=k，则反转前 k 个字符，并将剩余的字符保持原样。
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder(list.get(i));
            if (stringBuilder.length() == 2 * k) {
                result.append(reverse(stringBuilder, k));
            } else if (stringBuilder.length() < k) {
                result.append(stringBuilder.reverse());
            } else {
                result.append(reverse(stringBuilder, k));
            }
        }
        return result.toString();
    }

    public StringBuilder reverse(StringBuilder stringBuilder, int k) {
        StringBuilder result = new StringBuilder();
        String temp = stringBuilder.substring(0, k);
        String other = stringBuilder.substring(k);
        StringBuilder tempSb = new StringBuilder(temp);
        StringBuilder otherSb = new StringBuilder(other);
        result.append(tempSb.reverse()).append(otherSb);
        return result;
    }

}
