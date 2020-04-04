
import java.util.*;

/**
 * @Description: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * --------------------------------------
 * @ClassName: test_49.java
 * @Date: 2019/6/9 21:53
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_49 {
    public static void main(String[] args) {
        String[] strs = {""};
        Solution_49 solution = new Solution_49();
        System.out.println(solution.groupAnagrams(strs));
    }
}

class Solution_49 {
    public void test() {
        char[] chars1 = new char[]{'a', 'b'};
        char[] chars2 = new char[]{'b', 'a'};
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        System.out.println(Arrays.equals(chars1, chars2));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        if (strs.length==1 && strs[0].equals("")){
            List<String> temp = new ArrayList<String>();
            temp.add("\"\"");
            list.add(temp);
            return list;
        }
        for (int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<String>();
            for (int j = i + 1; j <= strs.length; j++) {
                if (j == strs.length) {
                    if (!"".equals(strs[i])){
                        temp.add(strs[i]);
                    }
                    strs[i] = "";
                    break;
                }
                if (isTar(strs[i], strs[j])) {
                    if (!"".equals(strs[j])){
                        temp.add(strs[j]);
                    }
                    strs[j] = "";
                }
            }
            if (!temp.isEmpty()) {
                list.add(temp);
            }
        }
        return list;
    }

    public boolean isTar(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2) && !"".equals(s1) && !"".equals(s2);
    }

}



