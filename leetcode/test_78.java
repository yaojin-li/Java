import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * --------------------------------------
 * @ClassName: test_78.java
 * @Date: 2019/8/21 9:38
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution_78 solution = new Solution_78();
        List<List<Integer>> result = solution.subsets(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
    }
}

class Solution_78 {
    /**
     * @Description: 直接遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     * @Date: 2019/8/26 22:31
     * @Params:
     * @ReturnType:
     **/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        // 初始化二维数组，包含为空的子集
        res.add(new ArrayList<Integer>());

        // 遍历每个元素
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            // 遍历已有的结果集
            for (int j = 0; j < size; j++) {
                // 获取当前子集
                List<Integer> list = res.get(j);
                // 新建临时存储的子集
                List<Integer> tmpList = new ArrayList<Integer>(list);
                // 把当前子集加上新的数，组成新的子集
                tmpList.add(nums[i]);
                // 新的子集加入到结果集
                res.add(tmpList);
            }
        }
        return res;
    }
}