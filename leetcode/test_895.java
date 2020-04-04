/**
 * @Description: 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 * 就返回 true ；否则返回 false 。
 * <p>
 * 示例 1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * <p>
 * 示例 2：
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * <p>
 * 示例 3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * <p>
 * 示例 4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * <p>
 * 示例 5：
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * 提示：
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * <p>
 * index与其后的元素换位比较（相同则与后一个换位比较）
 * <p>
 * 主要考虑三种情况:
 * 字符串长度不相等, 直接返回false
 * 字符串相等的时候, 只要有重复的元素就返回true
 * A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
 * <p>
 * 总结：
 * 1.理解题意，可能涉及到的注意点都罗列出来
 * 2.通过测试用例考虑算法涉及的不完整性
 * --------------------------------------
 * @ClassName: test_895.java
 * @Date: 2019/5/21 20:11
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_895 {
    public static void main(String args[]) {
        String A = "aa";
        String B = "aa";
        Solution_895 solution = new Solution_895();
        System.out.println(solution.buddyStrings(A, B));
    }
}

class Solution_895 {
    /**
     * @Description: index与其后的元素换位比较（相同则与后一个换位比较）
     * @Date: 2019/5/21 21:03
     * @Params:
     * @ReturnType:
     **/
    public boolean buddyStrings(String A, String B) {
        // 当其中一个为空或长度不等时，直接返回false
        if (A.length() == 0 || A.isEmpty() || B.length() == 0 || B.isEmpty() || A.length() != B.length()) {
            return false;
        }
        StringBuilder sba = new StringBuilder(A);
        StringBuilder sbb = new StringBuilder(B);

        // 当两个字符串相同时，比较不同字符的个数，存在一个字符个数大于一，则可以交换；否则说明该字符串均以不同字符构成，无法交换后相等。
        // 定义int[26] 字符相减缩短计算
        int[] indexInts = new int[26];
        if (A.equals(B)) {
            for (int i = 0; i < A.length(); i++) {
                indexInts[A.charAt(i) - 'a']++;
            }
            boolean flag = false;
            for (int i = 0; i < indexInts.length; i++) {
                // 若同一字符存在多个，则返回true
                if (indexInts[i] > 1) {
                    flag = true;
                }
            }
            return flag;
        }

        // 记录字符不等的两个index
        int[] ints = new int[A.length()];
        int index = 0;
        for (int i = 0, len = sba.length(); i < len; i++) {
            if (sba.charAt(i) != sbb.charAt(i)) {
                ints[index] = i;
                index++;
            }
        }

        // 交换两个不等位置的字符
        char temp = sba.charAt(ints[0]);
        sba.setCharAt(ints[0], sba.charAt(ints[1]));
        sba.setCharAt(ints[1], temp);

        //比较交换之后的字符是否相等
        if (String.valueOf(sba).equals(String.valueOf(sbb))) {
            return true;
        } else {
            return false;
        }
    }
}
