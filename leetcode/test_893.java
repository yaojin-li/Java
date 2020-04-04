import java.util.*;

/**
 * @Description: 你将得到一个字符串数组 A。如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
 * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
 * 返回 A 中特殊等价字符串组的数量。
 * <p>
 * 示例 1：
 * 输入：["a","b","c","a","c","c"]
 * 输出：3
 * 解释：3 组 ["a","a"]，["b"]，["c","c","c"]
 * <p>
 * 示例 2：
 * 输入：["aa","bb","ab","ba"]
 * 输出：4
 * 解释：4 组 ["aa"]，["bb"]，["ab"]，["ba"]
 * <p>
 * 示例 3：
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 * <p>
 * 示例 4：
 * 输入：["abcd","cdab","adcb","cbad"]
 * 输出：1
 * 解释：1 组 ["abcd","cdab","adcb","cbad"]
 * <p>
 * 提示：
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * 所有 A[i] 都具有相同的长度。
 * 所有 A[i] 都只由小写字母组成。
 * <p>
 * <p>
 * 方法：计数
 * 思路和算法
 * 让我们试着表述一个特殊等价的字符串 SS，通过找到函数 C 使得 S≡T⟺C(S)=C(T)。
 * 通过交换，我们可以排列偶数索引字母和奇数索引字母。这些排列的特征在于字母的数量：所有这样的排列都有相同的数量，不同的数量会产生不同的排列。
 * 因此，函数 C(S)=（S 中偶数索引字母的数量，其后是 S 中奇数索引字母的数量）成功地刻画了这一等价关系。
 * 然后，我们统计出满足 S∈A 的 C(S) 的数量。
 * --------------------------------------
 * @ClassName: test_893.java
 * @Date: 2019/5/26 18:14
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_893 {
    public static void main(String[] args) {
        String[] A = new String[]{"abc","acb","bac","bca","cab","cba","d"};
        Solution_893 solution = new Solution_893();
        System.out.println(solution.numSpecialEquivGroups(A));
    }
}

class Solution_893 {
    /**
     * @Description: 计数
     * @Date: 2019/5/26 18:37
     * @Params:
     * @ReturnType:
     **/
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(count));//添加数组
        }
        return set.size();
    }
}
