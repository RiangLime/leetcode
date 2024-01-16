package cn.lime.leetcode.leetcode.editor.cn.comm;


/**
 * @ClassName: ListNode
 * @Description:
 * @Author: Lime
 * @Date: 2024/1/16 18:35
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
