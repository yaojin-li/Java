/**
 * @Description: 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，
 * 如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：S = "0110", N = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：S = "0110", N = 4
 * 输出：false
 * <p>
 * 提示：
 * 1 <= S.length <= 1000
 * 1 <= N <= 10^9
 * --------------------------------------
 * @ClassName: test_1016.java
 * @Date: 2019/6/11 17:57
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1016 {
    public static void main(String[] args) {
        String S = "01100101010101111";
        int N = 200;
        Solution_1016 solution = new Solution_1016();
        System.out.println(solution.queryString(S, N));
    }
}

class Solution_1016 {
    /**
     * @Description:
     * 二进制包含问题
     * 主要考察的点应该是如何实现十进制到二进制的转换？
     * @Date:        2019/6/11 19:15
     * @Params:
     * @ReturnType:
     **/
    public boolean queryString(String S, int N) {
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (!S.contains(Integer.toBinaryString(i))){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
