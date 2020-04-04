import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 为求每个字符串之间字符数量的交集
 * --------------------------------------
 * @ClassName: test_1002.java
 * @Date: 2019/8/10 16:10
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1002 {
    public static void main(String[] args) {
        String[] A = new String[]{"cool","lock","cook"};
        Solution_1002 solution = new Solution_1002();
        List<String> result = solution.commonChars(A);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}


class Solution_1002 {
    /**
     * @Description:
     * @Date: 2019/8/10 16:26
     * @Params:
     * @ReturnType:
     **/
    public List<String> commonChars(String[] A) {
        List result = new ArrayList();
        int[] ints = new int[26];
        // 统计第一个字符串中的字符个数
        for (char c : A[0].toCharArray()) {
            ints[c - 'a']++;
        }
        // 遍历余下字符串
        for (int i = 1; i < A.length; i++) {
            // 统计当前字符串的字符个数
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a']++;
            }
            // 遍历第一个字符串与当前字符串的每个字符，取最小值更新至第一个字符串数组中
            for (int j = 0; j < 26; j++) {
                ints[j] = Math.min(ints[j], temp[j]);
            }
        }

        //
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                for (int j = 0; j < ints[i]; j++) {
                    result.add(((char) ('a' + i) + ""));
                }
            }
        }
        return result;
    }
}






