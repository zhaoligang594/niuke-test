package com.breakpoint.utils;

public abstract class LinkListUtils {

    /**
     * 头插法创建链表
     *
     * @param array 创建的链表信息 [1,2,3,4,5]
     * @return 1->2->3->4->5
     */
    public static ListNode getListByInsertHead(int[] array) {
        ListNode head = null;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    /**
     * 尾插法创建链表
     */
    public static ListNode getListNodeByArray(int[] array) {
        ListNode head, cur;
        if (array.length > 0) {
            head = new ListNode(array[0]);
        } else {
            head = null;
        }
        if (null != head) {
            cur = head;
            for (int i = 1; i < array.length; i++) {
                cur.next = new ListNode(array[i]);
                cur = cur.next;
            }
        }
        return head;
    }

    // get list with cycle
    public static ListNode getListNodeByArray(int[] array, int pos) {
        if (-1 == pos) {
            return getListNodeByArray(array);
        } else {
            //
            ListNode head, cur = null, posNode = null;
            if (array.length > 0) {
                head = new ListNode(array[0]);
            } else {
                return null;
            }
            if (0 == pos) {
                posNode = head;
            }
            if (null != head) {
                cur = head;
                for (int i = 1; i < array.length; i++) {
                    cur.next = new ListNode(array[i]);
                    cur = cur.next;
                    if (pos == i) {
                        posNode = cur;
                    }
                }
            }
            cur.next = posNode;
            return head;
        }
    }


    public static void printLinkList(ListNode root) {
        while (null != root) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}
