package com.breakpoint.leetcode2;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution138 {


    public static void main(String[] args) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Test.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getWriteMethod().getName());
        }
    }

    static class Test {
        private String a;
        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

//    public Node copyRandomList(Node head) {
//        Node res = null, cur = null;
//        Deque<Node> stack = new ArrayDeque<>();
//        Map<Node, Node> map = new HashMap<>();
//        while (null != head) {
//            if (res == null) {
//                res = new Node(head.val);
//                cur = res;
//            } else {
//                cur.next
//            }
//        }
//        return res;
//    }
//
//    static class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
//}
}
