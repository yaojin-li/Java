package linkedList;

/**
 * @Description: 876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间。
 * --------------------------------------
 * @ClassName: test_876.java
 * @Date: 2019/12/23 16:54
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_876 {
    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();
        int[] nums = {1, 2, 3, 4, 5, 6};

        for (int num : nums) {
            linkedLists.addListNodeFromLast(num);
        }
        Solution_876 solution = new Solution_876();
        linkedLists.showList(solution.middleNode(linkedLists.head));
    }
}

class Solution_876 {
    /**
     * @Description: 遍历两遍，第一遍找到链表的总个数，中间位置为 偶数/2 + 1，（奇数+1）/2；
     * 第二遍遍历，加个count计数，等于中间位置时返回节点；
     * @Date: 2019/12/22 18:21
     * @param: head
     * @Return:
     **/
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode newHead = head;
        // 统计链表长度
        while (head != null) {
            count++;
            head = head.next;
        }

        // 找到链表中间位置
        int mid = (count % 2 == 0) ? (count / 2 + 1) : ((count + 1) / 2);

        // 再次遍历找到中间节点返回
        int index = 1;
        ListNode result = null;
        while (newHead != null) {
            if (index == mid) {
                // 返回中间节点
                result = newHead;
                break;
            } else {
                index++;
                newHead = newHead.next;
            }
        }
        return result;
    }
}
