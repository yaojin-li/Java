import java.util.Arrays;

/**
 * @Description: 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * 提示：
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * --------------------------------------
 * @ClassName: test_1089.java
 * @Date: 2019/11/7 21:24
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1089 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        Solution_1089 solution = new Solution_1089();
        solution.duplicateZeros(arr);
    }
}

class Solution_1089 {
    /**
     * @Description: 检测非 0 值之后的每一个逐个移动
     * @Date: 2019/11/7 21:27
     * @Params:
     * @ReturnType:
     **/
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                // 往后移一位逐个交换位置
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                // 当前位置数据为 0，后一位由于前一步的复制也为 0，故自增 1，在 for 中再次自增 1
                // 即从当前位的后两位开始继续循环
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
