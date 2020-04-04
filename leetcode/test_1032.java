import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。
 * （我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 *  
 * <p>
 * 示例 1：
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * <p>
 * 示例 2：
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * <p>
 * 示例 3：
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 *  
 * <p>
 * 提示：
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 * --------------------------------------
 * @ClassName: test_1032.java
 * @Date: 2019/6/19 20:05
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1032 {
    public static void main(String[] args) {
        String[] queries = new String[]{"FooBar","FooBarTest","FootBall",
                "FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        Solution_1032 solution = new Solution_1032();
        System.out.println(solution.camelMatch(queries, pattern));
    }
}

class Solution_1032 {
    /**
     * @Description: 遍历每个query，针对query的每个字符，比较是否相同，比较长度，比较是否大写
     * @Date:        2019/6/19 21:01
     * @Params:
     * @ReturnType:
     **/
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<Boolean>();
        int len = pattern.length();
        for (String query : queries) {
            boolean isValid = true;
            int currentIndex = 0;
            for (int i = 0; i < query.length(); i++) {
                // 先判断长度，在比较
                if (currentIndex < len && query.charAt(i) == pattern.charAt(currentIndex)) {
                    currentIndex++;
                } else if (Character.isUpperCase(query.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            // 如果没有完全匹配完，则表示是匹配不上的
            result.add(isValid && len == currentIndex);
        }
        return result;
    }
}