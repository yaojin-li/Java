/**
 * @Description:
 * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
 * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。
 * 你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。
 * 你的表达式不应该含有冗余的括号。
 * <p>
 * 示例：
 * 输入: [1000,100,10,2]
 * 输出: "1000/(100/10/2)"
 * 解释:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 * <p>
 * 其他用例:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * <p>
 * 说明:
 * 输入数组的长度在 [1, 10] 之间。
 * 数组中每个元素的大小都在 [2, 1000] 之间。
 * 每个测试用例只有一个最优除法解。
 * --------------------------------------
 * @ClassName: test_553.java
 * @Date: 2019/6/13 17:38
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_553 {
    public static void main(String[] args) {
        int[] nums = new int[]{1000, 100};
        Solution_553 solution = new Solution_553();
        System.out.println(solution.optimalDivision(nums));
    }
}

class Solution_553 {
    /**
     * @Description:
     * 如果想要结果最大，那么实际就是要第二个数要最小，那么第一个数除以最小的第二个数，
     * 才会获得最大结果，第二个数一直往后除那就是最小值
     * @Date:        2019/6/13 17:46
     * @Params:      
     * @ReturnType:  
     **/
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if (nums.length == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < nums.length; i++) {
                sb.append(nums[i]).append("/");
            }
            return String.valueOf(nums[0]) + "/(" + sb.substring(0, sb.length() - 1) + ")";
        }
    }
}