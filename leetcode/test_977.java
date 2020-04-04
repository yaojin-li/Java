import java.util.Arrays;

/**
 * @Description: 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * --------------------------------------
 * @ClassName: test_977.java
 * @Date: 2019/4/19 13:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/

public class test_977 {
    public static void main(String args[]) {
        int[] ints = {-4, -1, 0, 3, 10};
        Solution_977 solution = new Solution_977();
//        int[] res = solution.sortedSquaresOne(ints);
        int[] res = solution.sortedSquaresTwo(ints);
        for (int i = 0, len = res.length; i < len; i++) {
            System.out.println(res[i]);
        }
    }
}

class Solution_977 {
    /**
     * @Description: Arrays.sort()
     * @Date: 2019/4/19 14:05
     * @Params:
     * @ReturnType:
     **/
    public int[] sortedSquaresOne(int[] A) {
        for (int i = 0, len = A.length; i < len; i++) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(A);
        return A;
    }


    /**
     * @Description:
     * @Date: 2019/4/19 14:08
     * @Params:
     * @ReturnType:
     **/
    public int[] sortedSquaresTwo(int[] A) {
        int len = A.length;
        int right = 0;
        //正负数分界位置
        while (right < len && A[right] < 0) {
            right++;
        }
        int left = right - 1;
        int index = 0;//当前索引
        int[] result = new int[len];//！new、int[len]新建指定长度的数组
        //左右指针均有指向，将平方的较小值放入结果集
        while (left >= 0 && right < len) {
            if (A[left] * A[left] > A[right] * A[right]) {
                result[index++] = A[right] * A[right];//index++
                right++;
            } else {
                result[index++] = A[left] * A[left];
                left--;
            }
        }
        //遍历余下的结果
        while (left >= 0) {
            result[index++] = A[left] * A[left];
            left--;
        }
        while (right < len) {
            result[index++] = A[right] * A[right];
            right++;
        }
        return result;
    }
}
