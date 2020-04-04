/**
 * @Description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * --------------------------------------
 * @ClassName: test_459.java
 * @Date: 2019/5/14 19:37
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_459 {
    public static void main(String args[]) {
        String s = "abab";
        Solution_459 solution = new Solution_459();
        System.out.println(solution.repeatedSubstringPattern(s));
    }
}

class Solution_459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length()==1){
            return false;
        }

        for (int i = 1,len=s.length()/2; i < len+1; i++) {
            //主要考察点：筛选遍历的条件，限制时间 s.length() % i == 0
            if (s.length() % i ==0){
                String pattern = s.substring(0,i);
                String[] arr = s.split(pattern);
                if (arr.length==0){
                    return true;
                }
            }
        }
        return false;
    }

}
