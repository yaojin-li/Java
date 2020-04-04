/**
 * @Description: 
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * --------------------------------------
 * @ClassName: test_125.java
 * @Date: 2019/5/16 20:06
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_125 {
    public static void main(String args[]) {
        String s = "0P";
        Solution_125 solution = new Solution_125();
        System.out.print(solution.isPalindrome(s));

        //字母大小写转换
//		char ch = 'B';
//		int a = ch-'A'+'a';
//		System.out.print((char)a);
    }
}

class Solution_125 {
    /**
     * @Description: 双指针。注意条件：考虑数字，考虑大小写
     * @Date:        2019/5/16 20:20
     * @Params:      
     * @ReturnType:  
     **/
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (start <= end) {
            if (check(sb.charAt(start))) {
                start++;
                continue;
            }
            if (check(sb.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(sb.charAt(start)) != Character.toLowerCase(sb.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean check(char ch) {
        boolean flagOne = 'a' <= ch && ch <= 'z';
        boolean flagTwo = 'A' <= ch && ch <= 'Z';
        boolean flagThree = '0' <= ch && ch <= '9';
        return !(flagOne || flagTwo || flagThree);
    }
}
