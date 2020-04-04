/**
 * @Description: 求两个升序数组归并后的中位数
 * <p>
 * https://mp.weixin.qq.com/s/8nWXRbz18W6ouK_e_sKMGw
 * <p>
 * 1,3,5,6,7,10
 * 2,4,5,9,11
 * -> 1,2,3,4,5,5,6,7,9,10,11  (5)
 * <p>
 * 3,5,7,8,9
 * 1,2,6,7,15
 * -> 1,2,3,5,6,7,7,8,9,15  (6.5)
 * --------------------------------------
 * @ClassName: FindMedianSortedArrays.java
 * @Date: 2019/9/6 21:16
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] arrayB = new int[]{11, 12, 13, 14, 15, 16};
        int[] arrayA = new int[]{1, 2, 3};
        System.out.println(findMedianSortedArrays(arrayA, arrayB));
    }

    /**
     * @Description:
     * @Date: 2019/9/6 21:26
     * @Params:
     * @ReturnType:
     **/
    public static double findMedianSortedArrays(int[] arrayA, int[] arrayB) {
        int lengthA = arrayA.length;
        int lengthB = arrayB.length;
        // 若数组A的长度大于B，互换数组
        if (lengthA > lengthB) {
            int[] tempArray = arrayA;
            arrayA = arrayB;
            arrayB = tempArray;
            // 互换长度
            int tempLength = lengthA;
            lengthA = lengthB;
            lengthB = tempLength;
        }

        int start = 0;
        int end = lengthA;
        // 定义A，B数组归并后的中间索引，+1是考虑基数情况
        int midIndexOfMergeArray = (lengthA + lengthB + 1) / 2;
        while (start <= end) {
            // A数组中间索引（利用二分查找，定位midIndexA的值）
            int midIndexA = (start + end) / 2;
            // B数组中，归并排序后，中位数的后一位索引 nextIndexOfMidIndex
            int j = midIndexOfMergeArray - midIndexA;
            if (midIndexA < end && arrayB[j - 1] > arrayA[midIndexA]) {
                // midIndexA 偏小，需要右移
                start = midIndexA + 1;
            } else if (midIndexA > start && arrayA[midIndexA - 1] > arrayB[j]) {
                // midIndexA 偏大，需要左移
                end = midIndexA - 1;
            } else {
                // midIndexA 刚好合适，或 midIndexA 已达到数组边界
                // 定义左半部分最大值
                int maxLeft;
                if (midIndexA == 0) {
                    maxLeft = arrayB[j - 1];
                } else if (j == 0) {
                    maxLeft = arrayA[midIndexA - 1];
                } else {
                    maxLeft = Math.max(arrayA[midIndexA - 1], arrayB[j - 1]);
                }
                //如果归并数组的长度是奇数，中位数就是左半部分的最大值
                if ((lengthA + lengthB) % 2 == 1) {
                    return maxLeft;
                }
                int minRight;
                if (midIndexA == lengthA) {
                    minRight = arrayB[j];
                } else if (j == lengthB) {
                    minRight = arrayA[midIndexA];
                } else {
                    minRight = Math.min(arrayB[j], arrayA[midIndexA]);
                }
                //如果归并数组的长度是偶数，取左侧最大值和右侧最小值的平均
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
















