package com.fanzibang.day02;

public class Solution {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     *
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 1.如果l1和l2都为null返回0
     * 2.同时循环两个链表
     *  2.1 判断每次循环的元素是否为null，为null设置为0
     *  2.2 每一位计算都与上一次的进位值相加，当前计算完之后也需要更新进位值
     *  2.3 设置head和tail指针记录结果
     *  2.4 移动l1和l2的指针
     * 3.如果两个链表都遍历完，进位值>0，则在新链表最前方添加一个节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int res = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;

            if (head == null) {
                head = tail = new ListNode(res);
            } else {
                tail.next = new ListNode(res);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
