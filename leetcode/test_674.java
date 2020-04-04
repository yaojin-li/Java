import java.util.Arrays;

/**
 * @Description: 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 * <p>
 * --------------------------------------
 * @ClassName: test_674.java
 * @Date: 2019/7/31 0:07
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_674 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 4, 7};
        Solution_674 solution = new Solution_674();
        System.out.println(solution.findLengthOfLCIS(ints));

    }
}

class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ints = new int[nums.length];
        int count = 1;
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            } else {
                ints[num] = count;
                count = 1;
                num++;
            }
        }
        ints[num] = count;
        Arrays.sort(ints);
        return ints[ints.length - 1];
    }
}