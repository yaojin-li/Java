/**
 * @Description: 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * --------------------------------------
 * @ClassName: test_28.java
 * @Date: 2019/5/16 20:23
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_28 {
    public static void main(String args[]) {
        String haystack = "mississippi";
        String needle = "issip";
        Solution_28 solution = new Solution_28();
        System.out.println(solution.strStr(haystack, needle));
    }
}

class Solution_28 {
    /**
     * @Description: 双指针。遍历每个char进行匹配。
     * 相同时，移动两个指针；
     * 不同时，第一个指针后退第二个指针值的跨度，第二个指针清零。
     * @Date: 2019/5/16 20:34
     * @Params:
     * @ReturnType:
     **/
    public int strStr(String haystack, String needle) {
//         return haystack.indexOf(needle);

        if (needle.length() == 0) {
            return 0;
        }

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int hStart = 0;
        int nStart = 0;

        while (hStart < haystack.length() && nStart < needle.length()) {
            //两个字符相等，两个指针分别后移一位
            if (haystackChars[hStart] == needleChars[nStart]) {
                hStart++;
                nStart++;
            } else {
                //不匹配时，hStart指针后退nStart个跨度，从下一个字符匹配；nStart清零，needle从头开始继续匹配
                hStart = hStart - nStart + 1;
                nStart = 0;
            }
        }
        //当nStart指针移动到末尾，说明完全匹配haystack中的字符
        if (nStart == needle.length()) {
            //返回起始位置
            return hStart - nStart;
        } else {
            return -1;
        }

    }
}
