import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 * <p>
 * 示例 1：
 * 输入: ["23:59","00:00"]
 * 输出: 1
 * <p>
 * 备注:
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 * --------------------------------------
 * @ClassName: test_539.java
 * @Date: 2019/6/12 19:49
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_539 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("01:01");
        timePoints.add("02:01");
        timePoints.add("03:00");
        Solution_539 solution = new Solution_539();
        System.out.println(solution.findMinDifference(timePoints));
    }
}


class Solution_539 {
    /**
     * @Description:
     * 1.调用时间模块 || 写个时间字符串转换成分钟的函数
     * 2.注意列表长度
     * 3.连续双指针遍历，记录时间差的最小值
     * <p>
     * 优化过程：
     * 移动end指针，逐个两两相减，差值记录到list   （多次无用的相减，记录到list）
     * -> 先排序，前后临近位相减，差值记录到list    （排序后减少相减次数，记录到list）
     * -> 先排序，首尾差值与前后临近位差值比较，不断更新最小值返回   （遍历的同时更新最小值）
     * <p>
     * int[] 性能优于 list
     * Arrays.sort(int[]) 性能优于 Collections.sort(list)
     * 优先选择：int[]数组 > list
     * @Date: 2019/6/12 21:20
     * @Params:
     * @ReturnType:
     **/
    public int findMinDifference(List<String> timePoints) {
        int[] timeSec = new int[timePoints.size()];
        // 计算分钟
        for (int i = 0; i < timePoints.size(); i++) {
            timeSec[i] = timeToSec(timePoints.get(i));
        }
        // 排序
        Arrays.sort(timeSec);
        // 收尾值相减，若大于12个小时，取其相反部分
        int temp = Math.abs(timeSec[0] - timeSec[timeSec.length - 1]);
        if (temp > 12 * 60) {
            temp = 24 * 60 - temp;
        }
        // 前后值相减，比较最小值
        for (int i = 1; i < timeSec.length; i++) {
            temp = Math.min(temp, timeSec[i] - timeSec[i - 1]);
        }
        return temp;
    }

    public int timeToSec(String time) {
        return Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
    }
}