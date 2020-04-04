import java.util.HashSet;

/**
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * --------------------------------------
 * @ClassName: test_14.java
 * @Date: 2019/5/18 9:59
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_14 {
    public static void main(String args[]) {
        String[] strs = {"flower", "flow", "flight"};
        Solution_14 solution = new Solution_14();
//        System.out.println(solution.longestCommonPrefix(strs));
        System.out.println(solution.longestCommonPrefixTwo(strs));
    }
}

class Solution_14 {
    /**
     * @Description: 找到长度最短的元素作为遍历的长度；
     * hashset 遍历一遍取所有元素相同index处的值放入set，大小大于一说明有不一致的字符；
     * 从0开始截取到返回长度不一致的前一个字符；
     * @Date: 2019/5/19 16:11
     * @Params:
     * @ReturnType:
     **/
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLen = strs[0].length();
        int minIndex = 0;

        //找到最小长度元素及其位置
        for (int i = 1; i < strs.length; i++) {
            if (minLen >= strs[i].length()) {
                minLen = strs[i].length();
                minIndex = i;
            }
        }

        int index = 0;
        //以最小的元素长度为准，若遍历中无返回，说明最小的元素即为最长公共前缀
        for (int i = 0; i < minLen; i++) {
            HashSet set = new HashSet();
            for (String str : strs) {
                char ch = str.charAt(index);
                set.add(ch);
            }
            //判断set长度，大于1说明在index处不一致
            if (set.size() > 1) {
                return strs[0].substring(0, index);
            }
            index++;
        }
        return strs[minIndex];
    }


    /**
     * @Description: 找第一个元素作为最长前缀，再不断截取出公共的最长前缀
     * @Date:        2019/5/19 17:55
     * @Params:
     * @ReturnType:
     **/
    public String longestCommonPrefixTwo(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        // 遍历每个元素
        for (int i = 1; i < strs.length; i++)
            // 当后一个元素不包含prefix时
            while (strs[i].indexOf(prefix) != 0) {
                // prefix截取掉后一位，再次判断strs[i]中是否存在prefix；
                // 这样后一个元素继续判断时，prefix的长度只会逐渐减少，以满足每个元素共有的公共前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                // 当prefix为空时，说明第一个元素与strs[i]不存在一致的前缀，返回空
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

}
