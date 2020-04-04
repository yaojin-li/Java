import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 1217. 玩筹码
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 * <p>
 * 示例 1：
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * <p>
 * 示例 2：
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 * <p>
 * 提示：
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 * --------------------------------------
 * @ClassName: test_1217.java
 * @Date: 2019/10/31 19:17
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1217 {
    public static void main(String[] args) {
        int[] chips = new int[]{1, 2, 3};
        Solution_1217 solution = new Solution_1217();
        System.out.println(solution.minCostToMoveChips(chips));
    }
}

class Solution_1217 {
    /**
     * @Description: 两次遍历，求当前值与余下所有值差的绝对值，放新的数组，再每个值奇偶取余数，再求和
     * @Date: 2019/10/31 19:30
     * @Params:
     * @ReturnType:
     **/
    public int minCostToMoveChips(int[] chips) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < chips.length; i++) {
            int oneListSum = 0;
            for (int j = 0; j < chips.length; j++) {
                int sub = Math.abs(chips[i] - chips[j]);
                oneListSum += sub % 2;
            }
            list.add(oneListSum);
        }
        Collections.sort(list);
        return list.get(0);
    }

    /**
     * @Description:
     * @Date: 2019/10/31 19:44
     * @Params:
     * @ReturnType:
     **/
    public int minCostToMoveChipsTwo(int[] chips) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                num2++;
            } else {
                num1++;
            }
        }
        return num2 > num1 ? num1 : num2;
    }


}