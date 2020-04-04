import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 169.求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * --------------------------------------
 * @ClassName: test_169.java
 * @Date: 2019/8/20 13:47
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        Solution_169 solution = new Solution_169();
        System.out.println(solution.majorityElement(nums));
        System.out.println(solution.majorityElementTwo(nums));
    }
}


class Solution_169 {
    /**
     * @Description: map 统计，选最大的 value 对应的 key
     * @Date: 2019/8/20 16:09
     * @Params:
     * @ReturnType:
     **/
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历新增 map
        for (int i = 0; i < nums.length; i++) {
            if (map.keySet().contains(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // 最大值
        int maxCount = 0;
        // 最大值对应的 key
        int maxCountNum = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > maxCount) {
                maxCount = map.get(key);
                maxCountNum = key;
            }
        }
        return maxCountNum;
    }


    /**
     * @Description: 排序后利用中位数统计众数
     * @Date: 2019/8/20 16:43
     * @Params:
     * @ReturnType:
     **/
    public int majorityElementTwo(int[] nums) {
        // 先排序，使得中位数与众数相同
        Arrays.sort(nums);
        // 获得中位数，由于众数的个数大于总数的一半，所以排序后的中位数就是总数
        int candi = nums[nums.length / 2];
        // 众数的个数
        int count = 0;
        // 遍历获得众数个数
        for (int i = 0; i < nums.length; i++) {
            if (candi == nums[i]) {
                count++;
            }
        }
        //
        return count > nums.length / 2 ? candi : -1;
    }

}
