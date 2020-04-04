import java.util.*;

/**
 * @Description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 1. 遍历 n 的所有可能的排列组合
 * 2. 判断是否满足条件
 * 3. 添加到数组
 * --------------------------------------
 * @ClassName: test_22.java
 * @Date: 2019/5/30 15:22
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_22 {
    public static void main(String[] args) {
        int n = 5;
        Solution_22 solution = new Solution_22();
        System.out.println(solution.generateParenthesis(n));
//        System.out.println(solution.generateParenthesisTwo(n));
    }
}

class Solution_22 {
    /**
     * @Description: 递归
     * @Date: 2019/5/30 16:43
     * @Params:
     * @ReturnType:
     **/
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int index, List<String> result) {
        if (index == current.length) {
            // 只添加满足要求的数据
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[index] = '(';
            generateAll(current, index + 1, result);
            current[index] = ')';
            generateAll(current, index + 1, result);
        }
    }

    /**
     * @Description: 判断当前字符是否有效
     * @Date: 2019/5/30 16:49
     * @Params:
     * @ReturnType:
     **/
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        // 保证括号个数对称
        return (balance == 0);
    }


    /**
     * @Description:
     * @Date: 2019/5/30 16:45
     * @Params:
     * @ReturnType:
     **/
    public List<String> generateParenthesisTwo(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> ans, String cur, int leftIndex, int rigthIndex, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (leftIndex < max) {
            backtrack(ans, cur + "(", leftIndex + 1, rigthIndex, max);
        }
        if (rigthIndex < leftIndex) {
            backtrack(ans, cur + ")", leftIndex, rigthIndex + 1, max);
        }
    }

}

