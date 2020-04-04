import java.util.Arrays;

/**
 * @Description: 1170. 比较字符串最小字母出现频次
 * <p>
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
 * 其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 * <p>
 * 示例 1：
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * <p>
 * 示例 2：
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * <p>
 * 提示：
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 * --------------------------------------
 * @ClassName: test_1170.java
 * @Date: 2019/11/6 17:11
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1170 {
    public static void main(String[] args) {
        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        Solution_1170 solution = new Solution_1170();
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(queries, words)));
    }
}

class Solution_1170 {
    /**
     * @Description:
     * 1. 找到最小字母并统计最小字母出现次数
     * 2. 遍历 queries 中每个字符串，与 words 中每个字符串比较
     * 3. 若小于，int result++，queries 中每个字符串比较后，则将每个字符串的 result 结果存入 int[]
     * @Date: 2019/11/6 17:12
     * @Params:
     * @ReturnType:
     **/
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (String word : words) {
                if (queryMinCharCount(queries[i]) < queryMinCharCount(word)) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int queryMinCharCount(String str) {
        char[] chars = str.toCharArray();
        char minChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < minChar) {
                minChar = chars[i];
            }
        }
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == minChar) {
                count++;
            }
        }
        return count;
    }

}

