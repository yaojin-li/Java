/**
 * @Description:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * 说明:
 * 元音字母不包含字母"y"。
 * --------------------------------------
 * @ClassName: test_345.java
 * @Date: 2019/5/9 19:05
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_345 {
    public static void main(String args[]) {
        String s = "hello";
        Solution_345 solution = new Solution_345();
        System.out.println(solution.reverseVowels(s));
    }
}

class Solution_345 {
    /**
     * @Description: 双指针判断；判断一个字符是否在字符数组中，直接==比较，||连接
     * @Date: 2019/5/9 20:14
     * @Params:
     * @ReturnType:
     **/
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();

        while (start <= end) {
            if (!isYuanYin(chars[start])) {
                start++;
                continue;
            }
            if (!isYuanYin(chars[end])) {
                end--;
                continue;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    //直接判断，不借助stringbuilder等结构
    private boolean isYuanYin(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
