import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * --------------------------------------
 * @ClassName: test_922.java
 * --------------------------------------
 * @Date: 2019/8/8 17:31
 * @SoftWare: IntelliJ IDEA
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_922 {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7, 1, 0};
        Solution_922 solution = new Solution_922();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(A)));
        System.out.println(Arrays.toString(solution.sortArrayByParityIITwo(A)));
    }
}

class Solution_922 {
    /**
     * @Description: 先分别找出奇数、偶数；再以此按索引放置奇偶数
     * @Date: 2019/8/9 10:36
     * @Params:
     * @ReturnType:
     **/
    public int[] sortArrayByParityII(int[] A) {
        List evenList = new ArrayList<>(A.length / 2);
        List oddList = new ArrayList<>(A.length / 2);
        int[] result = new int[A.length];

        // 分别生成奇数、偶数数组
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenList.add(A[i]);
            } else {
                oddList.add(A[i]);
            }
        }

        // 奇偶位置放置奇偶数
        int indexEven = 0;
        int indexOdd = 0;
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = (int) evenList.get(indexEven);
                // 下一次偶数索引放下一个偶数
                indexEven++;
            } else {
                result[i] = (int) oddList.get(indexOdd);
                indexOdd++;
            }
        }
        return result;
    }


    /**
     * @Description: 双指针遍历交换
     * @Date: 2019/8/9 10:38
     * @Params:
     * @ReturnType:
     **/
    public int[] sortArrayByParityIITwo(int[] A) {
        // 定义第二位的索引  indexEven indexOdd
        int indexOdd = 1;
        // 遍历偶数索引
        for (int indexEven = 0; indexEven < A.length; indexEven += 2) {
            // 若偶数索引对应的值为奇数
            if (A[indexEven] % 2 == 1) {
                // 遍历奇数索引的值是否为奇数
                while (A[indexOdd] % 2 == 1) {
                    // 若奇数索引的值为奇数，则判断下一个奇数索引
                    indexOdd += 2;
                }
                // 将偶数索引的值与奇数索引的值交换
                int temp = A[indexEven];
                A[indexEven] = A[indexOdd];
                A[indexOdd] = temp;
            }
        }
        return A;
    }

}

