import org.apache.commons.lang3.ArrayUtils;

/**
 * @Description: 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 * --------------------------------------
 * @ClassName: test_1480.java
 * @Date: 2020/7/10 15:45
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1480 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 10, 1};
        Solution_1480 solution = new Solution_1480();
        int[] result = solution.runningSum(nums);
        System.out.println(ArrayUtils.toString(result));
    }
}

class Solution_1480 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            res[i] = temp;
        }
        return res;
    }
}