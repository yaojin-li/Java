/**
 * @Description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * --------------------------------------
 * @ClassName: test_344.java
 * @Date: 2019/4/27 15:41
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_344 {
    public static void main(String args[]) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        Solution_344 solution = new Solution_344();
//        solution.reverseStringOne(s);
        solution.reverseStringTwo(s);
    }
}

class Solution_344 {
    /**
     * @Description: 首尾互换，无指针
     * @Date: 2019/4/27 15:49
     * @Params:
     * @ReturnType:
     **/
    public void reverseStringOne(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp;
            temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        System.out.println(s);
    }


    /**
     * @Description: 前后双指针
     * @Date: 2019/4/27 16:35
     * @Params:
     * @ReturnType:
     **/
    public void reverseStringTwo(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp;
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }

}
