import java.util.*;

/**
 * @Description: 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * <p>
 * 示例：
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *  
 * 提示：
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * --------------------------------------
 * @ClassName: test_1051.java
 * @Date: 2019/7/30 22:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1051 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 4, 7};
        Solution_1051 solution = new Solution_1051();
        System.out.println(solution.heightChecker(ints));
    }
}

class Solution_1051 {
    /**
     * @Description: 先排序，再对比各个位置上的不同数据，不同则结果+1
     * @Date: 2019/7/30 22:51
     * @Params:
     * @ReturnType:
     **/
    public int heightChecker(int[] heights) {
        // 先复制数组，留作比较相同index的value时使用
        int[] arrays = Arrays.copyOf(heights, heights.length);
        // 对数组排序
        Arrays.sort(arrays);
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            // 比较复制后的数组与排序后的数组相同index上的value，不同时即该位需要移动
            if (heights[i] != arrays[i]) {
                count++;
            }
        }
        return count;
    }


}
