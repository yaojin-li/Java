
/**
 * @Description: 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 * <p>
 * 山羊拉丁文的规则如下：
 * 1.如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * <p>
 * 2.如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * <p>
 * 3.根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 * <p>
 * 示例 1:
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * 示例 2:
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * 说明:
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * 1 <= S.length <= 150。
 * --------------------------------------
 * @ClassName: test_824.java
 * @Date: 2019/5/3 15:37
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_824 {
    public static void main(String args[]) {
        String s = "The quick brown fox jumped over the lazy dog";
        Solution_824 solution = new Solution_824();
        System.out.println(solution.toGoatLatinOne(s));
    }
}

class Solution_824 {
    public String toGoatLatinOne(String S) {
        String[] s = S.split(" ");
        StringBuilder result = new StringBuilder();
        int aNum = 1;
        for (String str : s) {
            char ch = str.charAt(0);
            StringBuilder stringBuilder = new StringBuilder(str);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                stringBuilder.append("ma");
            } else {
                char one = stringBuilder.charAt(0);
                stringBuilder.deleteCharAt(0);
                stringBuilder.append(one).append("ma");
            }
            for (int i = 0; i < aNum; i++) {
                stringBuilder.append("a");
            }
            aNum++;
            result.append(stringBuilder).append(" ");
        }
        return result.toString().trim();
    }
}
