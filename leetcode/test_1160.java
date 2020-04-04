/**
 * @Description: 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * 示例 1：
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * <p>
 * 示例 2：
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * --------------------------------------
 * @ClassName: test_1160.java
 * @Date: 2019/8/28 21:54
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1160 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        Solution_1160 solution = new Solution_1160();
        System.out.println(solution.countCharacters(words, chars));
    }
}

class Solution_1160 {
    /**
     * @Description: 遍历每个单词中的每个字母，是否在chars中。
     * 在则将chars对应的字母置空，继续下一个字母比较，若都在且无重复，则累加此单词长度；
     * 不在则继续比较下一个单词；
     * @Date: 2019/8/28 21:56
     * @Params:
     * @ReturnType:
     **/
    public int countCharacters(String[] words, String chars) {
        // 判断当前单词是否满足要求
        boolean isTarget = true;
        // 缓存chars
        String temp = chars;
        // 结果
        int result = 0;
        for (String word : words) {
            char[] oneChars = word.toCharArray();
            for (int i = 0; i < oneChars.length; i++) {
                // 若包含，则将开始的一个字符替换为""
                if (chars.contains(String.valueOf(oneChars[i]))) {
                    chars = chars.replaceFirst(String.valueOf(oneChars[i]), "");
                } else {
                    // 当前单词不满足条件，遍历下一个
                    isTarget = false;
                    break;
                }
            }
            // 累加
            if (isTarget) {
                result += word.length();
            }
            // 下一次单词遍历初始化条件
            isTarget = true;
            chars = temp;
        }
        return result;
    }


    /**
     * @Description: 统计每个字符个数，与chars判断
     * @Date: 2019/8/28 22:26
     * @Params:
     * @ReturnType:
     **/
    private int[] charCount = new int[26];
    private int charLength;

    public int countCharactersTwo(String[] words, String chars) {
        // 统计字符数
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        // 字符总个数
        charLength = chars.length();

        int sum = 0;
        for (String word : words) {
            sum += getCount(word);
        }
        return sum;
    }

    // 匹配单词 返回单词长度
    private int getCount(String word) {
        if (word.length() > charLength) {
            return 0;
        }

        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (wordCount[i] >= charCount[i]) {
                return 0;
            } else {
                wordCount[i]++;
            }
        }
        return word.length();
    }
}
