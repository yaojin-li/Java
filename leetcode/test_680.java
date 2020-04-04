/**
 * @Description: 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 注：
 * 1. 最多删除一个字符
 * 2. 删除不一定是临近的字符，测试用例误导
 * --------------------------------------
 * @ClassName: test_680.java
 * @Date: 2019/5/23 10:19
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_680 {
    public static void main(String[] args) {
        String s = "abca";
        Solution_680 solution = new Solution_680();
        System.out.println(solution.validPalindrome(s));
    }
}

class Solution_680 {
    /**
     * @Description: 双指针，删除不同位置再比较，字符数组char[]效率比sb高
     * @Date: 2019/5/23 11:23
     * @Params:
     * @ReturnType:
     **/
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (start <= end) {
            char startChar = sb.charAt(start);
            char endChar = sb.charAt(end);
            if (startChar == endChar) {
                start++;
                end--;
                continue;
            }
            StringBuilder temp = new StringBuilder(s);
            temp = temp.deleteCharAt(start);
            StringBuilder temp2 = new StringBuilder(s);
            temp2 = temp2.deleteCharAt(end);
            return isTarget(temp) || isTarget(temp2);
        }
        return true;
    }

    public boolean isTarget(StringBuilder sb) {
        int start = 0;
        int end = sb.length() - 1;
        while (start <= end) {
            if (sb.charAt(start) != sb.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * @Description:
     * 双指针；
     * 优化（char[]代替stringbuilder、
     *      判定函数只判断start+1至end或start至end-1之间的内容，不从头开始判断）
     * @Date:        2019/5/23 11:33
     * @Params:
     * @ReturnType:
     **/
    public boolean validPalindromeTwo(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start <= end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
                continue;
            }
            // 直接判断指定位置之间的内容
            return isTargetOne(chars, start + 1, end) || isTargetOne(chars, start, end - 1);
        }
        return true;
    }

    /**
     * @Description: 判断指定位置之间的字符数组是否是回文数组
     * @Date: 2019/5/23 11:29
     * @Params:
     * @ReturnType:
     **/
    public boolean isTargetOne(char[] sb, int m, int n) {
        while (m <= n) {
            if (sb[m++] != sb[n--]) {
                return false;
            }
        }
        return true;
    }


}

