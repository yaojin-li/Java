/**
 * @Description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * <p>
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 注意:
 * 输入的字符串长度不会超过1000。
 * --------------------------------------
 * @ClassName: test_647.java
 * @Date: 2019/6/6 21:35
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_647 {
    public static void main(String[] args) {
        String s = "bcdaaa";
        Solution_647 solution = new Solution_647();
        System.out.println(solution.countSubstrings(s));
    }
}

class Solution_647 {
    /**
     * @Description:
     * 定义一个跨度的start与end，分别都加一移动，跨度每次自增1。
     * 缺点：全部遍历。可以过滤一些不必要的判断。比如偶数是回文串的时候，偶数跨度+1不是回文串；
     * 同理，奇数是回文串的时候，奇数跨度+1不是回文串。
     * @Date: 2019/6/6 21:43
     * @Params:
     * @ReturnType:
     **/
    public int countSubstringsOne(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int start = 0, end = start + j; end < s.length(); start++,end++) {
                if (isTar(chars, start, end)) {
                    sum += 1;
                }
            }
        }
        // 跨度从1开始。0时每个字符都是子回文串
        return s.length() + sum;
    }

    // 判断当前字符数组在指定跨度中是否是回文
    public boolean isTar(char[] chars, int start, int end) {
        boolean flag = true;
        while (start<=end){
            if (chars[start] != chars[end]){
                flag = false;
                break;
            }
            start++;
            end--;
        }
        return flag;
    }


    /**
     * @Description:
     * 以当前字符为中心左右扩散，幅度+1，判断奇数位字符串是否是回文串；
     * 再以当前字符与下一个字符为中心扩散，幅度为1，判断偶数位字符串是否是回文串；
     * @Date:        2019/6/6 22:23
     * @Params:
     * @ReturnType:
     **/
    private int count=0;
    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++){
            // 判断奇数跨度的长度。start与end相同，表示当前字符是回文串
            extendSubStrings(s, i, i);

            // 判断偶数跨度的长度
            extendSubStrings(s, i, i+1);
        }
        return count;
    }

    public void extendSubStrings(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
    }

}