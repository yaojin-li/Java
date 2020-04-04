package sorted;

import java.util.Arrays;

/**
 * @Description: 排序算法集合
 * 1. 插入排序
 * 2. 插入排序优化--拆半插入（二分查找）
 * 3. 冒泡排序
 * 4. 冒泡排序优化--是否已经有序
 * 5. 快速排序
 * 6. 希尔排序--直接插入算法加强版
 * 7. 堆排序
 * 8. 归并排序
 * 9. 基数排序（桶排序）
 * 10.
 * <p>
 * 参考链接：
 * https://gitbook.cn/books/5a099f419bfa9d42d08c81ea/index.html#undefined
 * https://mp.weixin.qq.com/s/dyRTXwsmUmFcF9PeFR8OrQ
 * --------------------------------------
 * @ClassName: SortedAlgorithms.java
 * @Date: 2019/7/30 22:39
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SortedAlgorithms {
    public static void main(String[] args) {
        int[] noOrderInts = new int[]{5, 3, 8, 1, 9, 4, 7, 2};
        SortedAlgorithms algorithms = new SortedAlgorithms();

        // 插入排序
        // System.out.println(Arrays.toString(algorithms.straightInsertionSort(noOrderInts)));

        // 插入排序优化--拆半插入（二分查找）
        // System.out.println(Arrays.toString(algorithms.straightInsertionSortHalf(noOrderInts)));

        // 冒泡排序
        // System.out.println(Arrays.toString(algorithms.bubbleSort(noOrderInts)));

        // 冒泡排序优化
        // System.out.println(Arrays.toString(algorithms.bubbleSortTwo(noOrderInts)));

        // 快速排序
        // algorithms.quickSorted(noOrderInts, 0, noOrderInts.length - 1);

        // 希尔排序
        // System.out.println(Arrays.toString(algorithms.shellSorted(noOrderInts)));

        // 堆排序
        System.out.println(Arrays.toString(algorithms.headSorted(noOrderInts)));

        // 归并排序
        System.out.println(Arrays.toString(algorithms.mergeSorted(noOrderInts)));

        // 基数排序（桶排序）
//        System.out.println(Arrays.toString(algorithms.radixSorted(noOrderInts)));

    }


    /**
     * @Description: 插入排序
     * 1. 介绍：
     * 一种依次将无序区的元素在有序区内找到合适位置依次插入的算法
     * 2. 原理：
     * 每次从无序表中取出第一个元素，把它插入到有序表的合适位置，使有序表仍然有序，直到无序表内所有元素插入为止
     * 3. 优缺点：
     * 优点 : 稳定，相对于冒泡排序与选择排序更快；
     * 缺点 : 比较次数不一定，比较次数越少，插入点后的数据移动越多，特别是当数据总量大的时候；
     * 4. 时间复杂度：
     * 插入排序的最坏时间复杂度为 O(n^2)，属于稳定排序算法，对于处理小批量数据时高效；
     * 5. 空间复杂度：
     * 排序只需要一个位置来暂存元素，因此空间复杂度为 O（1）。
     * @Date: 2019/7/29 21:15
     * @Params: 待排序数组 ints
     * @ReturnType: 排序后数组 result
     **/
    public int[] straightInsertionSort(int[] ints) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arrays = Arrays.copyOf(ints, ints.length);
        // nowIndex 从1开始，默认0处的值有序
        for (int nowIndex = 1; nowIndex < arrays.length; nowIndex++) {
            // 当前 nowIndex 对应的值
            int currentNum = arrays[nowIndex];
            // preIndex 定义为当前 nowIndex 的前一项
            int preIndex = nowIndex - 1;
            // 嵌套 while 比较当前值与左边所有数据的大小
            while (preIndex >= 0 && arrays[preIndex] > currentNum) {
                // 若当前值小于前一项的值，则把前一项的值赋给当前值，即大数赋值给小数，此时的小数的值为 currentNum
                arrays[preIndex + 1] = arrays[preIndex];
                // 前移一项继续比较
                preIndex--;
            }
            // 以最小值替换当前值
            arrays[preIndex + 1] = currentNum;
        }
        return arrays;
    }


    /**
     * @Description: 插入排序优化--拆半插入（二分查找）
     * 1. 原理：
     * 折半插入算法是对直接插入排序算法的改进，排序原理同直接插入算法。
     * 2. 区别：
     * 在插入到已排序的数据时采用来折半查找（二分查找），取已经排好序的数组的中间元素，与插入的数据进行比较，
     * 如果比插入的数据大，那么插入的数据肯定属于前半部分，否则属于后半部分，
     * 依次不断缩小范围，确定要插入的位置。
     * 3. 优缺点：
     * 优点 : 稳定，相对于直接插入排序元素减少了比较次数；
     * 缺点 : 相对于直接插入排序元素的移动次数不变；
     * 4. 时间复杂度：
     * 折半插入排序减少了比较元素的次数，约为 O(nlogn)，比较的次数取决于表的元素个数 n。
     * 因此，折半插入排序的时间复杂度仍然为 O(n²)，但它的效果还是比直接插入排序要好。
     * 5. 空间复杂度：
     * 排序只需要一个位置来暂存元素，因此空间复杂度为 O（1）。
     * @Date: 2019/7/29 21:25
     * @Params:
     * @ReturnType:
     **/
    public int[] straightInsertionSortHalf(int[] ints) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arrays = Arrays.copyOf(ints, ints.length);
        // nowIndex 从1开始，默认0处的值有序
        for (int nowIndex = 1; nowIndex < arrays.length; nowIndex++) {
            // 拆半插入（二分查找）
            // nowIndex 左侧序列最低值
            int low = 0;
            // nowIndex 左侧序列最高值
            int heigh = nowIndex - 1;
            // 当 nowIndex 左侧序列
            while (low <= heigh) {
                // 计算 nowIndex 左侧序列的中间索引值
                int middle = (low + heigh) / 2;
                // 若中间值大于当前值
                if (arrays[middle] > arrays[nowIndex]) {
                    // 将 nowIndex 左侧序列的最高值至为中间索引值的前一位，即 nowIndex 应该在中间索引值的左半部分
                    heigh = middle - 1;
                } else {
                    // 将 nowIndex 左侧序列的最低值至为中间索引值的后一位，即 nowIndex 应该在中间索引值的右半部分
                    low = middle + 1;
                }
            }
            // 定义临时变量 temp 存储当前值 arrays[nowIndex]
            int temp = arrays[nowIndex];
            // 统一移动元素，倒叙遍历赋值，不影响其后相邻位之间的赋值
            for (int j = nowIndex; j > heigh + 1; j--) {
                // 从 heigh 位的下一位开始到 nowIndex，每位依次后移
                arrays[j] = arrays[j - 1];
            }
            // 将临时存储的当前值 arrays[nowIndex] 插入到正确的位置 heigh + 1
            arrays[heigh + 1] = temp;
        }
        return arrays;
    }


    /**
     * @Description: 冒泡排序
     * 1. 原理：
     * 冒泡排序是一种交换排序（两两比较待排序的关键字，并交换不满足次序要求的那对数，直到整个表都满足次序要求为止）
     * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端，故名。
     * 假设有一个大小为 N 的无序序列。冒泡排序就是要每趟排序过程中通过两两比较，找到第 i 个小（大）的元素，将其往上排。
     * 2. 优缺点：
     * 优点：相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。
     * 缺点：
     * 3. 时间复杂度：
     * 最好时间复杂度为 O(N)，最坏时间复杂度为 O(N^2)。因此，冒泡排序的平均时间复杂度为 O(N^2)。
     * 当数据越接近正序时，冒泡排序性能越好。
     * 4. 空间复杂度：
     * 排序只需要一个位置来暂存元素，因此空间复杂度为 O（1）。
     * @Date: 2019/8/7 21:28
     * @Params:
     * @ReturnType:
     **/
    public int[] bubbleSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            // 从后开始遍历，两两比较
            for (int nowIndex = ints.length - 1; nowIndex > i; nowIndex--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (ints[nowIndex - 1] > ints[nowIndex]) {
                    // 交换
                    int temp = ints[nowIndex - 1];
                    ints[nowIndex - 1] = ints[nowIndex];
                    ints[nowIndex] = temp;
                }
            }
            System.out.format("第 %d 趟：\t", i);
            System.out.println(Arrays.toString(ints));
        }
        return ints;
    }


    /**
     * @Description: 冒泡排序优化--是否已经有序
     * 1. 原理：
     * 对冒泡排序常见的改进方法是加入标志性变量 exchange，用于标志某一趟排序过程中是否有数据交换。
     * 如果进行某一趟排序时并没有进行数据交换，则说明所有数据已经有序，可立即结束排序，避免不必要的比较过程。
     * @Date: 2019/8/7 22:07
     * @Params:
     * @ReturnType:
     **/
    public int[] bubbleSortTwo(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            // 每次循环都定义一个变量，判断当前序列是否已经有序
            boolean isChange = false;
            // 从后开始遍历，两两比较
            for (int nowIndex = ints.length - 1; nowIndex > i; nowIndex--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (ints[nowIndex - 1] > ints[nowIndex]) {
                    // 交换
                    int temp = ints[nowIndex - 1];
                    ints[nowIndex - 1] = ints[nowIndex];
                    ints[nowIndex] = temp;
                    isChange = true;
                }
            }
            // 若已经有序，break
            if (!isChange) {
                break;
            }
            System.out.format("第 %d 趟：\t", i);
            System.out.println(Arrays.toString(ints));
        }
        return ints;
    }


    /**
     * @Description: 快速排序
     * 1. 介绍
     * 交换排序；对冒泡排序的改进；
     * 通过一趟排序将要排序的数据分割成独立的两部分：分割点左边都是比它小的数，右边都是比它大的数。
     * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * 2. 原理
     * （2，4，5，1，3）
     * a. 设置两个指针 left 和 right，分别指向数组的头部（2）和尾部（3）。并且以头部元素（2）为基准数 base；
     * b. 从右到左扫描，通过移动 right 指针，寻找比基准数小的元素，将其赋值给 left 指针所指的位置；
     * c. 从左向右扫描，通过移动 left 指针，寻找比基准数大的元素，将其赋值给 right 指针所指的位置；
     * d. 不断重复二、三步骤，直到 left 与 right 指针重合，至此所有元素都被扫描一遍；将基准数（2）赋给重合的位置；至此完成一次排序，基准数（2）左边都是比它小的数，右边都是比它大的数；
     * e. 以基准数（2）为分割点，对其左侧和右侧的数分别按照前四部排序，递归后，排序结束。
     * 3. 优缺点
     * 优点：速度快
     * 缺点：不稳定、较复杂
     * 4. 时间复杂度
     * 平均复杂度 O(Nlog2N)，最坏情况 O(N^2)，最好情况 O(Nlog2N)
     * 5. 空间复杂度
     * 快速排序在每次分割的过程中，需要 1 个空间存储基准值。而快速排序的大概需要 Nlog2N 次的分割处理，所以占用空间也是 Nlog2N 个。
     * @Date: 2019/8/9 15:31
     * @Params:
     * @ReturnType:
     **/
    public void quickSorted(int[] ints, int left, int right) {
        // 当左下标大于右下标，返回null
        if (left < right) {
            // 对待排序列进行一次快排，找到基准索引，分割左右区间
            int baseIndex = division(ints, left, right);

            // 递归，对基准索引左侧区间数值递归分割，形成左侧数据的完整排序
            quickSorted(ints, left, baseIndex - 1);

            // 递归，对基准索引右侧区间数值递归分割，形成右侧数据的完整排序
            quickSorted(ints, baseIndex + 1, right);
        }
    }


    /**
     * @Description: 快速排序划分区间，返回一次排序后的基准索引。
     * 一次排序后的结果：基准数左边都是比它小的数，右边都是比它大的数；
     * @Date: 2019/8/14 21:02
     * @Params:
     * @ReturnType:
     **/
    public int division(int[] ints, int left, int right) {
        // 以最左边的数字（ints[left]）为基准
        int base = ints[left];
        // 当 left = right 时完成一次排序，此时基准数为 left(right)。
        // 基准数左边都是比它小的数，右边都是比它大的数
        while (left < right) {
            // 从序列右端开始往左遍历，当右指针大于左指针，且右指针的值大于基准数时，右指针往左移动，继续进行下次比较，直到找到小于基准的数
            while (left < right && ints[right] >= base) {
                right--;
            }
            // 找到小于基准的数赋值到左指针（left）的位置
            ints[left] = ints[right];
            // 从序列左端开始往右遍历，当左指针小于右指针，且左指针的值小于基准数时，左指针往右移动，继续进行下次比较，直到找到大于基准的数
            while (left < right && ints[left] <= base) {
                left++;
            }
            // 找到大于基准的数赋值到右指针（right）的位置
            ints[right] = ints[left];
        }

        // 经过一轮比较，left = right，将 base 的值放到此位置上。
        // 此时，基准数左侧数值都比 base 小，右边数值都比base大。
        ints[left] = base;
        System.out.println(String.format("一次排序后：%s", Arrays.toString(ints)));
        System.out.println(String.format("基准索引：%s，基准值：%s", String.valueOf(left), String.valueOf(base)));
        System.out.println("----------------------------------------");

        // 返回每次排序后的基准索引
        return left;
    }


    /**
     * @Description: 希尔排序
     * 1. 介绍
     * 希尔(Shell)排序又称为缩小增量排序，它是一种插入排序。它是直接插入排序算法的一种威力加强版。
     * 2. 原理
     * 把记录按步长 gap 分组，对每组记录采用直接插入排序方法进行排序。
     * 随着步长逐渐减小，所分成的组包含的记录越来越多，当步长的值减小到 1 时，整个数据合成为一组，构成一组有序记录，则完成排序。
     * 当步长为 1 时，算法变为插入排序，这就保证了数据一定会被排序。
     * 比较在希尔排序中是最主要的操作，而不是交换。
     * <p>
     * a. 初始大小 N；第一次排序设 gap = N/2 = 5，即相隔距离为 5 的元素一组，分为 5 组；
     * b. 直接插入排序对每个组排序；
     * c. 第二次排序 gap 缩小一半，gap = gap/2 = 2（取整），即相隔距离为 2 的元素一组，分为 2 组；
     * d. 直接插入排序对每个组排序；
     * e. 第三趟排序再次把 gap 缩小一半，即 gap = gap/2 = 1，即相隔距离为 1 的元素一组，即只有一组。
     * f. 直接插入排序对每个组排序，排序完成。
     * 3. 优缺点
     * 优点：
     * 缺点：不稳定，对规模非常大的数据排序不是最优选择；
     * 4. 时间复杂度
     * 最坏时间复杂度为 O(n^2)，平均情况为  O(Nlog2N)
     * 5. 空间复杂度
     * O(1)
     * @Date: 2019/8/16 20:43
     * @Params:
     * @ReturnType:
     **/
    public int[] shellSorted(int[] ints) {
        // 定义每次的步长 gap
        int gap = ints.length / 2;
        // 当步长 >= 1 时
        while (gap >= 1) {
            // 初始化 gapIndex（gap索引）为当前步长，把距离为 gap 的元素编为一个组，扫描所有组
            for (int gapIndex = gap; gapIndex < ints.length; gapIndex++) {
                // 当前索引
                int index = 0;
                // 缓存当前 gap 高位对应的索引值
                int temp = ints[gapIndex];
                // 对距离 gap 的元素排序
                // 当前索引为 gap 索引后退 gap 位；当前索引大于等于0，并且缓存当前 gap 高位对应的索引值小于当前索引值时（说明这一组连续这两位的值需要调换），由低位向高位赋值；此时高位的值存储在 temp 中；
                // 若当前索引小于0，或者当前索引值小于当前 gap 高位对应的索引值时，说明不需要调换；再比较当前索引的前 gap 位与 temp (当前 gap 高位对应的索引值)，依次前推当前索引的前 gap 位；
                for (index = gapIndex - gap; index >= 0 && temp < ints[index]; index = index - gap) {
                    // gap 低位向 gap 高位赋值，若满足条件，index 前推 gap 位继续比较
                    ints[index + gap] = ints[index];
                }
                // 当前索引值小于 temp 时，说明索引值的下一个 gap 对应的值应该设置为 temp，此时 temp 前面的值均比它小，后面的值均比他大
                ints[index + gap] = temp;
            }
            // 下次排序的步长缩短一倍
            gap = gap / 2;
        }
        return ints;
    }


    /**
     * @Description: 堆排序
     * @Date: 2019/8/31 20:59
     * @Params:
     * @ReturnType:
     **/
    public int[] headSorted(int[] ints) {
        int arrayLength = ints.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(ints, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(ints, 0, arrayLength - 1 - i);
        }
        return ints;
    }

    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的父节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //biggerIndex记录较大元素的序列值
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * @Description: 归并排序
     * 1. 介绍
     * 归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
     * 2. 原理
     * 将待排序序列 R[0…n-1] 看成是 n 个长度为 1 的有序序列，将相邻的有序表成对归并，得到 n/2 个长度为 2 的有序表；
     * 将这些有序序列再次归并，得到 n/4 个长度为 4 的有序序列；如此反复进行下去，最后得到一个长度为 n 的有序序列。
     * 综上可知：
     * 归并排序其实要做两件事：
     * “分解”——将序列每次折半划分。
     * “合并”——将划分后的序列段两两合并后排序。
     * a. 合并
     * 在每次合并过程中，都是对两个有序的序列段进行合并，然后排序。
     * 这两个有序序列段分别为 R[low, mid] 和 R[mid+1, high]。
     * 先将他们合并到一个局部的暂存数组R2 中，带合并完成后再将 R2 复制回 R 中。
     * 为了方便描述，我们称 R[low, mid] 第一段，R[mid+1, high] 为第二段。
     * 每次从两个段中取出一个记录进行关键字的比较，将较小者放入 R2 中。最后将各段中余下的部分直接复制到 R2 中。
     * 经过这样的过程，R2 已经是一个有序的序列，再将其复制回 R 中，一次合并排序就完成了。
     * b. 分解
     * 在某趟归并中，设各子表的长度为 gap，则归并前 R[0…n-1] 中共有 n/gap 个有序的子表：R[0…gap-1], R[gap…2gap-1], … , R[(n/gap)gap … n-1]。
     * 调用 Merge 将相邻的子表归并时，必须对表的特殊情况进行特殊处理。
     * 若子表个数为奇数，则最后一个子表无须和其他子表归并（即本趟处理轮空）：若子表个数为偶数，则要注意到最后一对子表中后一个子表区间的上限为 n-1。
     * 3. 优缺点
     * 优点：稳定，相等的元素的顺序不会改变
     * 缺点：较复杂
     * 4. 时间复杂度
     * 归并排序的形式就是一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的可以得出它的时间复杂度是 O(n*log2n)
     * 最坏、最好、平均情况均为  O(Nlog2N)
     * 5. 空间复杂度
     * 数组暂存合并的结果，O(n)
     * @Date: 2019/8/17 17:37
     * @Params:
     * @ReturnType:
     **/
    public int[] mergeSorted(int[] ints) {


        return ints;
    }


    /**
     * @Description: 基数排序（桶排序）
     * 1. 介绍
     * 根据关键字中各位的值，通过对排序的 N 个元素进行若干趟“分配”与“收集”来实现排序
     * 2. 原理
     * 初始序列为: R {50, 123, 543, 187, 49, 30,0, 2, 11, 100}。
     * 任何一个阿拉伯数，它的各个位数上的基数都是以 0~9 来表示的。 所以我们不妨把 0~9 视为 10 个桶。
     * a. 先根据序列的个位数的数字来进行分类，将其分到指定的桶中。例如：R[0] = 50，个位数上是 0，将这个数存入编号为 0 的桶中。
     * 这时，得到的序列就是个位数上呈递增趋势的序列。
     * 按照个位数排序：{50, 30, 0, 100, 11, 2, 123,543, 187, 49}。
     * b. 接下来，可以对十位数、百位数也按照这种方法进行排序，最后就能得到排序完成的序列。
     * 基数排序的效率和初始序列是否有序没有关联
     * 3. 优缺点
     * 优点：稳定（每次都是将当前位数上相同数值的元素统一“装桶”，不需要交换位置）
     * 缺点：
     * 4. 时间复杂度
     * r 为基数，d 为位数
     * 最好、最坏、平均：O(d(n+r))
     * 5. 空间复杂度
     * O(n+r) 对于任何位数上的基数进行“装桶”操作时，都需要 n+r 个临时空间。
     * @Date: 2019/8/27 22:24
     * @Params:
     * @ReturnType:
     **/
    public int[] radixSorted(int[] ints) {

        return ints;
    }

}





