/**
 * @Description: 给定有效字符串 "abc"。
 * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。
 * （X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
 * <p>
 * 例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。
 * 无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 * <p>
 * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * 输入："aabcbc"
 * 输出：true
 * 解释：
 * 从有效字符串 "abc" 开始。
 * 然后我们可以在 "a" 和 "bc" 之间插入另一个 "abc"，产生 "a" + "abc" + "bc"，即 "aabcbc"。
 * <p>
 * 示例 2：
 * 输入："abcabcababcc"
 * 输出：true
 * 解释：
 * "abcabcabc" 是有效的，它可以视作在原串后连续插入 "abc"。
 * 然后我们可以在最后一个字母之前插入 "abc"，产生 "abcabcab" + "abc" + "c"，即 "abcabcababcc"。
 * <p>
 * 示例 3：
 * 输入："abccba"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入："cababc"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= S.length <= 20000
 * S[i] 为 'a'、'b'、或 'c'
 * --------------------------------------
 * @ClassName: test_1003.java
 * @Date: 2019/6/10 14:43
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1003 {
    public static void main(String[] args) {
        String s = "cababc";
        Solution_1003 solution = new Solution_1003();
        System.out.println(solution.isValid(s));
        System.out.println(solution.isValidOne(s));
    }
}

class Solution_1003 {
    public boolean isValid(String S) {
        String tar = "abc";
        while (S.contains(tar)) {
            S = S.replace(tar, "");
        }
        return S.length() == 0;
    }

    public boolean isValidOne(String S) {
        String tar = "abc";
        StringBuffer sb = new StringBuffer(S);
        while (sb.indexOf(tar) != -1) {
            sb.replace(sb.indexOf(tar),sb.indexOf(tar)+tar.length(),"");
        }
        return sb.length() == 0;
    }
}