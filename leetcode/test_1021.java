import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * 示例 1：
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 示例 2：
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * 示例 3：
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * 提示：
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 * <p>
 * 第一步分解原语，第二步删除最外层括号。
 * --------------------------------------
 * @ClassName: test_1021.java
 * @Date: 2019/4/22 9:32
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1021 {
    public static void main(String args[]) {
        String string = "(()())(())(()(()))";
        Solution_1021 solution = new Solution_1021();
//        System.out.println(solution.removeOuterParenthesesOne(string));
//        System.out.println(solution.removeOuterParenthesesTwo(string));
        System.out.println(solution.removeOuterParenthesesThree(string));

    }
}

class Solution_1021 {
    /**
     * @Description: 利用索引，当index值加减为0时，即找到一个原语，分割字符串；string.substring()含左不含右；
     * @Date: 2019/4/22 22:53
     * @Params:
     * @ReturnType:
     **/
    public String removeOuterParenthesesOne(String S) {
        int index = 0;
        String[] list = S.split("");
        List<Integer> integers = new ArrayList<Integer>();
        List<String> res = new ArrayList<String>();
        for (int i = 0, len = list.length; i < len; i++) {
            if ("(".equals(list[i])) {
                index++;
            } else {
                index--;
            }
            //找到原语
            if (index == 0) {
                integers.add(i);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < integers.size(); i++) {
            if (i == 0) {
                stringBuffer.append(S.substring(1, integers.get(i)));
            } else {
                //从前一个原语的后两位截取
                stringBuffer.append(S.substring(integers.get(i - 1) + 2, integers.get(i)));
            }
        }
        return stringBuffer.toString();
    }

    /**
     * @Description: 研究逻辑设计的巧妙性
     * @Date: 2019/4/22 23:34
     * @Params:
     * @ReturnType:
     **/
    public String removeOuterParenthesesTwo(String S) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        char[] chs = S.toCharArray();
        for (char ch : chs) {
            if (ch == '(') {
                if (count > 0) {
                    sb.append("(");
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }


    /**
     * @Description: 根据堆栈的大小分割字符串
     * @Date: 2019/4/23 23:21
     * @Params:
     * @ReturnType:
     **/
    public String removeOuterParenthesesThree(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> rect = new ArrayList<Integer>(); //堆栈的大小
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
                rect.add(i, stack.size());
            } else {
                rect.add(i, stack.size());
                stack.pop();
            }
        }

        //String string = "(()())(())(()(()))";
        //rect = [1, 2, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 3, 3, 2, 1]
        char[] chars = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            //当rect的值为1时，说明对应的字符为原语的最外层括号
            if (rect.get(i) != 1) {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

}
