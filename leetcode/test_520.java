/**
 * @Description: 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 1. 全部字母都是大写，比如"USA"。
 * 2. 单词中所有字母都不是大写，比如"leetcode"。
 * 3. 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * <p>
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * 输入: "USA"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "FlaG"
 * 输出: False
 * <p>
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * --------------------------------------
 * @ClassName: test_520.java
 * @Date: 2019/4/30 14:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_520 {
    public static void main(String[] args) {
        String word = "G";
        Solution_520 solution = new Solution_520();
        System.out.println(solution.detectCapitalUseOne(word));
    }
}

class Solution_520 {
    /**
     * @Description: 判断首字母，再判断余下内容。
     * 判断条件：
     * word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'
     * Character.isUpperCase(char)
     * @Date: 2019/4/30 15:07
     * @Params:
     * @ReturnType:
     **/
    public boolean detectCapitalUseOne(String word) {
        String one = word.substring(0, 1);
        String two = word.substring(1);
        boolean flag = true;

        //长度为1时，大小写均正确
        if (word.length() == 1) {
            return true;
        }

        //首字母是大写，1.余下全大写，2.余下全小写
        if (Character.isUpperCase(one.charAt(0))) {
            //判断two的首字母大小写，后续必须与其保持一致
            if (Character.isUpperCase(two.charAt(0))) {
                //余下必须全是大写，判断有小写至为false
                for (char ch : two.toCharArray()) {
                    if (Character.isLowerCase(ch)) {
                        flag = false;
                        break;
                    }
                }
            } else {
                //余下必须全是小写，判断有大写至为false
                for (char ch : two.toCharArray()) {
                    if (Character.isUpperCase(ch)) {
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            //首字母是小写，则余下必须都是小写，判断有大写至为false
            for (char ch : two.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}


