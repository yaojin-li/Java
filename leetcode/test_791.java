/**
 * @Description: 字符串 S 和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。
 * 更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 * <p>
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 * <p>
 * 注意:
 * S的最大长度为26，其中没有重复的字符。
 * T的最大长度为200。
 * S和T只包含小写字符。
 *
 * 注：
 * 输入："cbafg" "abcd"
 * 输出："cbafgd"
 * 预期："cbad"
 * 原因：以T为准，拼接S余下内容。修改：以T为准，拼接T余下内容。
 *
 * 输入："kqep" "pekeq"
 * 输出："kqep"
 * 预期："kqeep"
 * 原因：未考虑T中重复字符。修改：while遍历余下index+1至length()长度的字符串中当前字符出现的次数。
 *
 * 输入："jftiugkz" "kfiukutzjg"
 * 输出："jftiuugkkkkkz"
 * 预期："jftiuugkkz"
 * 原因：index每次更新应从当前字符的重复下一个字符+1的位置开始计算。
 *
 * 输入："hucw"
 * "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"
 * 输出："hhhuuccwtzoampdgkalexslxoqfkdjozajxtqyxvlfatmptqdsotdzgypsfkgqbgqbamdqnqztaqqanirikatmalzqjjxtqfn"
 * 预期："hhhhhuucccwaaaaaaaaabbdddddeffffggggiijjjjkkkkllllmmmmnnnoooopppqqqqqqqqqqqrsssttttttttvxxxxxyyzzzzz"
 * 原因：更新当前索引index为下一个相同字符出现的位置，不能在此基础上累加。
 *
 * --------------------------------------
 * @ClassName: test_791.java
 * @Date: 2019/6/3 20:20
 * @SoftWaonly: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_791 {
    public static void main(String[] args) {
        String S = "hucw";
        String T = "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh";
        Solution_791 solution = new Solution_791();
        System.out.println(solution.customSortString(S, T));
    }
}


class Solution_791 {
    /**
     * @Description:
     * 1. 找到当前字符位置，若重复，在index+1的基础上继续遍历，找到所有T中按照S顺序排列的字符
     * 2. 筛选在T中不在S中的字符
     * 3. 拼接两部分内容
     * @Date: 2019/6/3 20:26
     * @Params:
     * @onlyturnType:
     **/
    public String customSortString(String S, String T) {
        StringBuilder contains = new StringBuilder();
        StringBuilder only = new StringBuilder();

        for (char oneCh : S.toCharArray()) {
            StringBuilder temp = new StringBuilder(T);
            int index = 0;
            // 循环拼接T中多个相同的字符
            while (index < T.length()) {
                // 找到当前字符从index出开始的位置
                int charIndex = temp.indexOf(String.valueOf(oneCh), index);
                if (charIndex != -1) {
                    contains.append(oneCh);
                }
                // 从index处的下一个位置开始截取
                String tem = temp.substring(charIndex + 1, temp.length());
                if (tem.contains(String.valueOf(oneCh))) {
                    // 更新当前索引，不能累加
                    index = tem.indexOf(String.valueOf(oneCh));
                    // 更新temp
                    temp = new StringBuilder(tem);
                } else {
                    break;
                }
            }
        }
        // 拼接在T中不在S中的字符
        for (int i = 0; i < T.length(); i++) {
            if (contains.indexOf(String.valueOf(T.charAt(i))) == -1) {
                only.append(T.charAt(i));
            }
        }
        // 拼接T中存在的按照S顺序排列的字符，与T中独有的字符
        return contains.toString() + only.toString();
    }
}