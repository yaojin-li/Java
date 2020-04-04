import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1200. 最小绝对差
 * <p>
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * --------------------------------------
 * @ClassName: test_1200.java
 * @Date: 2019/11/12 17:22
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1200 {
    public static void main(String[] args) {
        int[] arr = {40, 11, 26, 27, -20};
        Solution_1200 solution = new Solution_1200();
        List<List<Integer>> res = solution.minimumAbsDifference(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}

class Solution_1200 {
    /**
     * @Description:
     * @Date: 2019/11/12 17:25
     * @Params:
     * @ReturnType:
     **/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List result = new ArrayList();
        // 1. 排序
        Arrays.sort(arr);

        // 2. 取最小值
        int left = 0;
        int right = 1;
        int[] subArr = new int[arr.length - 1];
        while (right < arr.length) {
            int sub = Math.abs(arr[right] - arr[left]);
            subArr[left] = sub;
            left++;
            right++;
        }
        Arrays.sort(subArr);
        int minSub = subArr[0];

        // 3. 滑动窗口取最值
        left = 0;
        right = 1;
        while (right < arr.length) {
            List list = new ArrayList();
            int sub = Math.abs(arr[right] - arr[left]);
            // 满足条件加入到结果列表
            if (sub <= minSub) {
                minSub = sub;
                list.add(arr[left]);
                list.add(arr[right]);
                result.add(list);
            }
            left++;
            right++;
        }
        return result;
    }


    public List<List<Integer>> minimumAbsDifferenceTwo(int[] arr) {
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] <= min) {
                if (arr[i] - arr[i - 1] < min) {
                    // 由于存在最小的差值，清空已有的结果
                    lists.clear();
                    // 更新最小值
                    min = arr[i] - arr[i - 1];
                }
                List<Integer> list = new ArrayList<Integer>(2);
                list.add(arr[i - 1]);
                list.add(arr[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}

