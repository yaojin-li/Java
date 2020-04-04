
/**
 * @Description: 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。
 * 要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
 * 0, 1, 和 8 被旋转后仍然是它们自己；
 * 2 和 5 可以互相旋转成对方；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * 示例:
 * 输入: 10
 * 输出: 4
 * <p>
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * 注意:
 * N 的取值范围是 [1, 10000]。
 * --------------------------------------
 * @ClassName: test_788.java
 * @Date: 2019/5/2 10:22
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_788 {
    public static void main(String args[]) {
        int N = 10;
        Solution_788 solution = new Solution_788();
        System.out.println(solution.rotatedDigitsOne(N));
    }
}


class Solution_788 {
    /**
     * @Description: replaceAll()逐次替换
     * @Date: 2019/5/2 12:26
     * @Params:
     * @ReturnType:
     **/
    public int rotatedDigitsOne(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            String n = String.valueOf(i);
            //先替换掉相同的数字
            n = n.replaceAll("[+0,+1,+8]", "");
            if (!"".equals(n)) {
                //再替换好数
                n = n.replaceAll("[+2,+5,+6,+9]", "");
                //余下内容若为空，则说明该数字由好数构成
                if ("".equals(n)) {
                    sum++;
                }
            }
        }
        return sum;
    }
}