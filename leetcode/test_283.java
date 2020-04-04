import java.util.Arrays;

/**
 * @Description: 283 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * --------------------------------------
 * @ClassName: test_283.java
 * @Date: 2019/10/30 14:50
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_283 {
    public static void main(String[] args) {
        int[] nums = new int[]{18, 5, 0, 4, 9, 0, 1, 0, 2, 3};
        Solution_283 solution = new Solution_283();
        solution.moveZeroes(nums);
    }
}

class Solution_283 {
    /**
     * @Description: 双指针遍历
     * 思路：设置一个index，表示非0数的个数，循环遍历数组，
     * 如果不是0，将非0值移动到第index位置,然后index + 1
     * 遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
     * @Date: 2019/11/1 9:49
     * @Params:
     * @ReturnType:
     **/
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }

        // index 统计非零的个数
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前值非零，则与 index 处的值交换
            if (nums[i] != 0) {
                nums[index] = nums[i];
                // 非零个数自增
                index++;
            }
        }

        // 将非零个数之后的数字设置为 0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

}

