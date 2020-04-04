import java.util.HashMap;

/**
 * @Description: 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 提示：
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 * --------------------------------------
 * @ClassName: test_917.java
 * @Date: 2019/5/8 20:39
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_917 {
    public static void main(String args[]) {
        String S = "ab-cd";
        Solution_917 solution = new Solution_917();
//        System.out.println(solution.reverseOnlyLettersOne(S));
        System.out.println(solution.reverseOnlyLettersTwo(S));
    }
}

class Solution_917 {
    /**
     * @Description: 找到所有非字母的字符，保留位置，
     * 余下的新str反转，在特定位置设置非字母的字符，其余位置设置字母
     * @Date: 2019/5/8 20:26
     * @Params:
     * @ReturnType:
     **/
    public String reverseOnlyLettersOne(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();

        char ch[] = S.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            //是非字母的字符
            if (!('a' <= ch[i] && ch[i] <= 'z' || 'A' <= ch[i] && ch[i] <= 'Z')) {
                map.put(i, ch[i]);//记录特殊字符及其位置
            } else {
                stringBuilder.append(ch[i]);
            }
        }

        //反转stringBuilder
        stringBuilder.reverse();

        //构造于S等长度的StringBuilder
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            result.append(" ");
        }

        //设置对应位置的特殊字符
        for (Integer key : map.keySet()) {
            result.setCharAt(key, map.get(key));
        }

        //设置字符
        for (int i = 0; i < stringBuilder.length(); i++) {
            result.setCharAt(result.indexOf(" "), stringBuilder.charAt(i));
        }

        return result.toString();
    }


    /**
     * @Description: 双指针（优先考虑！）
     * @Date: 2019/5/8 21:47
     * @Params:
     * @ReturnType:
     **/
    public String reverseOnlyLettersTwo(String S) {
        int start = 0;
        int end = S.length() - 1;
        char[] ch = S.toCharArray();

        //左右指针指向同一char
        while (start <= end) {
            //判断左指针指向字符是否是特殊字符
            if (!('a' <= ch[start] && ch[start] <= 'z' ||
                    'A' <= ch[start] && ch[start] <= 'Z')) {
                start++;
                continue;
            }

            //判断右指针指向字符是否是特殊字符
            if (!('a' <= ch[end] && ch[end] <= 'z' ||
                    'A' <= ch[end] && ch[end] <= 'Z')) {
                end--;
                continue;
            }

            //若左右指针指向均不是特殊字符，则互换，并更新左右指针
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }

}










