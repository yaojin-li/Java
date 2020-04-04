/**
 * @Description: 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 注：
 * 1.判断是否是单词: aa、a、at
 * --------------------------------------
 * @ClassName: test_58.java
 * @Date: 2019/5/22 16:34
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_58 {
    public static void main(String[] args) {
        String s = "    ";
        Solution_58 solution = new Solution_58();
        System.out.println(solution.lengthOfLastWord(s));
    }
}

class Solution_58 {
    /**
     * @Description: string.trim()先去除首位空格再分割
     * 若输入为 "   ";
     * s.trim() -> ""
     * s.trim().aplit(" ") -> {""}   // 存在一个元素 ""
     * 直接分割，则：
     * s.split(" ") -> {}    // 无元素，分割之后全部都去除了
     * @Date: 2019/5/22 17:28
     * @Params:
     * @ReturnType:
     **/
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String[] strings = s.trim().split(" ");
        return strings[strings.length - 1].length();
    }


    /**
     * @Description: 分割
     * @Date: 2019/5/22 17:28
     * @Params:
     * @ReturnType:
     **/
    public int lengthOfLastWordTwo(String s) {
        if (s.isEmpty() || isNotWord(s)) {
            return 0;
        }
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }

    public boolean isNotWord(String s) {
        String[] strings = s.split(" ");
        return strings.length == 0;
    }
}
