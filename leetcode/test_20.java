import java.util.HashMap;
import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 总结：
 * 1. 不熟练使用堆栈；
 * 2. 看到题目之后第一时间联想到对应的数据结构；
 * 3. 上来考虑边界情况、复杂情况，避免简单测试用例导致算法考虑不周全；
 * --------------------------------------
 * @ClassName: test_20.java
 * @Date: 2019/5/17 19:17
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_20 {
    public static void main(String args[]) {
        String s = "([])";
        Solution_20 solution = new Solution_20();
//        System.out.println(solution.isValidOne(s));
        System.out.println(solution.isValidTwo(s));
    }
}

class Solution_20{
    /**
     * @Description: 堆栈 stack
     * @Date:        2019/5/17 21:52
     * @Params:
     * @ReturnType:
     **/
    public boolean isValidOne(String s){
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();

        for (char ch:chars) {
            if (stack.empty()){
                stack.push(ch);
                //比较是否是一对符号
            }else if (isPair(stack.peek(),ch)){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.size()==0;
    }

    public boolean isPair(char chOne, char chTwo) {
        boolean one = chOne == '(' && chTwo == ')';
        boolean two = chOne == '{' && chTwo == '}';
        boolean three = chOne == '[' && chTwo == ']';
        return one || two || three;
    }



    /**
     * @Description: 巧妙应用 ++ 与 --
     * @Date:        2019/5/17 22:01
     * @Params:
     * @ReturnType:
     **/
    public boolean isValidTwo(String s) {
        char[] chars = new char[s.length() + 1];
        int top = 1;
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                chars[top++] = c;
            }else if(c == ')' && chars[--top] != '('){
                return false;
            }else if(c == '}' && chars[--top] != '{'){
                return false;
            }else if(c == ']' && chars[--top] != '['){
                return false;
            }
        }
        return top == 1;

    }
}
