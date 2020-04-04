/**
 * @Description: 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 * 示例 1：
 * 输入： "()"
 * 输出： 1
 * <p>
 * 示例 2：
 * 输入： "(())"
 * 输出： 2
 * <p>
 * 示例 3：
 * 输入： "()()"
 * 输出： 2
 * <p>
 * 示例 4：
 * 输入： "(()(()))"
 * 输出： 6
 *  
 * 提示：
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 * --------------------------------------
 * @ClassName: test_856.java
 * @Date: 2019/6/11 19:19
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_856 {
    public static void main(String[] args) {
        String S = "(()(()))";
        Solution_856 solution = new Solution_856();
        System.out.println(solution.scoreOfParentheses(S));
        System.out.println(solution.scoreOfParenthesesTwo(S));
    }
}


class Solution_856 {
    /**
     * @Description: 括号的深度；位运算
     * @Date:        2019/6/11 20:39
     * @Params:
     * @ReturnType:
     **/
    public int scoreOfParentheses(String S) {
        int result = 0;
        // 相乘；左括号的深度
        int deep = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                // 有"("，深度自增1
                deep++;
            } else {
                // 无"("，深度自减1
                deep--;
            }
            // 含有 "()"，结果累加深度左移的大小
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                // result 累加 1<<deep 的大小
                result += 1 << deep;
            }
        }
        return result;
    }


    /**
     * @Description: 括号的深度；分配律
     * @Date:        2019/6/11 20:48
     * @Params:
     * @ReturnType:
     **/
    public int scoreOfParenthesesTwo(String S) {
        int result = 0;
        int deep = 1;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)=='('){
                deep=deep+1;
            }else {
                deep=deep-1;
            }
            if (S.charAt(i)==')' && S.charAt(i-1)=='('){
                // 含有 "()"，通过分配律，同级别的括号分开，结果累加 2的(深度-1)次幂
                result += Math.pow(2,deep-1);
            }
        }
        return result;
    }
}



