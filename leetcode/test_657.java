/**
 * @Description: 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，
 * 判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * <p>
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。
 * 机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。
 * 此外，假设每次移动机器人的移动幅度相同。
 * <p>
 * 示例 1:
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。
 * 因此，我们返回 true。
 * <p>
 * 示例 2:
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。
 * 我们返回 false，因为它在移动结束时没有返回原点。
 * <p>
 * 注：
 * 1. 两个值加减，最终判定是否都为零；
 * 2. L与R，U与D个数相同；
 * --------------------------------------
 * @ClassName: test_657.java
 * @Date: 2019/5/28 13:51
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_657 {
    public static void main(String[] args) {
        Solution_657 solution = new Solution_657();
        String moves = "LL";
        System.out.println(solution.judgeCircle(moves));
    }
}

class Solution_657 {
    /**
     * @Description: 两个值加减，最终判定是否都为零；
     * @Date:        2019/5/28 14:11
     * @Params:
     * @ReturnType:
     **/
    public boolean judgeCircle(String moves) {
        int level = 0;
        int vertical = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (temp == 'U') {
                level++;
            } else if (temp == 'D') {
                level--;
            } else if (temp == 'L') {
                vertical++;
            } else {
                vertical--;
            }
        }
        return level == 0 && vertical == 0;
    }

}