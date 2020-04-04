/**
 * @Description:
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * <p>
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；
 * A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 * <p>
 * 注意:
 * A 与 B 字符串的长度在1和10000区间范围内。
 * <p>
 * 注：
 * 1. B是A的字串，字串。
 * 2. 分析题意：终止长度：一个完整的B可能首部用到A的一部分，尾部用到A的一部分，像这样A'[AA....AA]A',
 * [ ] 内必然<=B的长度，故总长<=2*A+B
 *
 * 测试用例：
 * "abc"
 * "cabcabca"
 *
 * "a"
 * "a"
 *
 * "a"
 * "aa"
 * --------------------------------------
 * @ClassName: test_686.java
 * @Date: 2019/5/22 19:59
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_686 {
    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        Solution_686 solution = new Solution_686();
        System.out.println(solution.repeatedStringMatch(A, B));
        System.out.println(solution.repeatedStringMatchTwo(A, B));
    }
}


class Solution_686 {
    /**
     * @Description: 循环拼接，b.len/a.len 次不包含，再加一次判断是否包含
     * @Date: 2019/5/22 20:47
     * @Params:
     * @ReturnType:
     **/
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sbA = new StringBuilder(A);
        StringBuilder sbB = new StringBuilder(B);
        // b.len / a.len  叠加次数
        int num = sbB.length() / sbA.length();
        for (int i = 0; i < num; i++) {
            //若相等，返回拼接次数
            if (sbA.toString().equals(sbB.toString())) {
                return i + 1;
            }
            sbA.append(new StringBuilder(A));
        }

        // 包含时，返回重叠次数
        if (sbA.toString().contains(sbB)) {
            return sbA.length() / A.length();
        } else {
            // 叠加num次之后不包含，再叠加1次，判断是否包含，若不包含，返回-1
            sbA.append(new StringBuilder(A));
            if (sbA.toString().contains(sbB)) {
                return sbA.length() / A.length();
            } else {
                return -1;
            }
        }
    }


    /**
     * @Description:
     * 1. 可能B的首尾均包含部分A的字符，最多加2
     * 2. lastIndexOf()>-1 说明不相等、不包含
     * @Date: 2019/5/22 21:07
     * @Params:
     * @ReturnType:
     **/
    public int repeatedStringMatchTwo(String A, String B) {
        // 可能B的首尾均包含部分A的字符，最多加2
        int max = B.length() / A.length() + 2;
        StringBuilder sb = new StringBuilder(A);
        // 从1开始--append()方法执行后，本身已经包含一次，故从1开始
        int index = 1;
        while (index <= max) {
            // lastIndexOf()从后往前搜索效率比indexOf()从前往后效率高，变化的地方在append()的后面
            // >-1 说明不相等、不包含
            if (sb.lastIndexOf(B) > -1) {
                return index;
            } else {
                sb.append(A);
                index++;
            }
        }
        return -1;
    }

}
