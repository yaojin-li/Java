import java.util.Arrays;

/**
 * @Description: 985. 查询后的偶数和
 * 给出一个整数数组 A 和一个查询数组 queries。
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *  
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 * <p>
 * 注意：
 * 时间超时问题；
 * 只需要求解每次的变量，不变量不用考虑；
 * --------------------------------------
 * @ClassName: test_985.java
 * @Date: 2019/9/3 20:40
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_985 {
    public static void main(String[] args) {
        int[] A = {0, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        Solution_985 solution = new Solution_985();
        System.out.println(Arrays.toString(solution.sumEvenAfterQueries(A, queries)));
    }
}

class Solution_985 {
    /**
     * @Description: 遍历 queries ，只对每次的总和进行操作；根据改变前后的奇偶性决定新的求和
     * @Date: 2019/9/3 20:49
     * @Params:
     * @ReturnType:
     **/
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        // 先记录 A 中的偶数和
        int sum = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        int[] result = new int[A.length];
        // 遍历时单次只改变一个位置上的元素，其余总和不变
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            // 如果修改的数原本是偶数，先从偶数和中减去
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            // 把 val 加到 A[index]
            A[index] += val;
            // 修改后的值若是偶数，加到偶数和中
            if (A[index] % 2 == 0) {
                sum += A[index];
            }
            result[i] = sum;
        }

        return result;
    }

}
