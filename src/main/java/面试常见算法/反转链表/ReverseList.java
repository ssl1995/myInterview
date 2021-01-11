package 面试常见算法.反转链表;


public class ReverseList {
    // 反转单链表：迭代
    public Node reverserList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 利用head遍历，节省一个空间
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 反转单链表：递归
    public Node reverserList1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归获取末尾节点
        Node res = reverserList1(head.next);
        // 如下的head从倒数第二个节点开始反转链表
        head.next.next = head;
        head.next = null;
        return res;
    }

    // 反转双链表：迭代法
    public DoubleNode reverserList(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            // 双向链表多加这一行
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
