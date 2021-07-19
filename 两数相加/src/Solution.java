package LC_2;

import java.util.Scanner;

/**
 *给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 *输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一组数");
        String s1 = sc.nextLine();
        ListNode l1 = StL(s1);
        System.out.println("请输入第一组数");
        String s2 = sc.nextLine();
        ListNode l2 = StL(s2);

        ListNode listNode = addTwoNumbers(l1, l2);

        while (listNode != null){
            System.out.print(listNode.val+"");
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s = 0;
        ListNode head = null, tail = null;
        while (l1!=null || l2!=null){
            int a = l1 != null? l1.val : 0;
            int b = l2 != null? l2.val : 0;
            int c = (a+b+s)%10;
            if (head == null){
                head = tail = new ListNode(c);
            }else {
                tail.next = new ListNode(c);
                tail = tail.next;
            }
            s = (a+b+s)/10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (s > 0) {
            tail.next = new ListNode(s);
        }
        return head;
    }

    public static ListNode StL(String str){
        ListNode head = null, tail = null;
        for (int i = 0; i < str.length(); i++) {
            if (head == null) {
                head =tail = new ListNode((int)str.charAt(i)-(int)'0');
            } else {
                tail.next = new ListNode((int)str.charAt(i)-(int)'0');
                tail = tail.next;
            }

        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}