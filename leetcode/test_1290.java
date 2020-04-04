package linkedList;

/**
 * @Description: 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。请你返回该链表所表示数字的 十进制值 。
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * <p>
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * --------------------------------------
 * @ClassName: linkedList.test_1290.java
 * @Date: 2019/12/22 19:03
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1290 {
    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();
        int[] nums = {1, 0, 1};

        for (int num : nums) {
            linkedLists.addListNodeFromLast(num);
        }

        Solution_1290 solution = new Solution_1290();
        System.out.println(solution.getDecimalValueTwo(linkedLists.head));
    }
}

class Solution_1290 {
    /**
     * @Description: 1.遍历所有节点获得长度；2.构建节点的值的数组；3.二进制转十进制。
     * @Date: 2019/12/22 19:03
     * @param: head
     * @Return:
     **/
    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            return head.data;
        }

        // 遍历链表长度
        int length = 0;
        ListNode newHead = head;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        int[] nums = new int[length + 1];

        // 构建 nums 数组
        int index = 0;
        while (newHead != null) {
            nums[index] = newHead.data;
            newHead = newHead.next;
            index++;
        }

        // 二进制转十进制
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sum += Math.pow(2, nums.length - i - 1);
            }
        }
        return sum;
    }


    /**
     * @Description: 左移
     * @Date: 2019/12/22 19:04
     * @param: head
     * @Return:
     **/
    public int getDecimalValueTwo(ListNode head) {
        int ans = 0;
        while (head != null) {
            // 存在一个节点，结果左移一次
            ans <<= 1;
            // 累计结果
            ans += head.data;
            // 下移一个节点
            head = head.next;
        }
        return ans;
    }
}

