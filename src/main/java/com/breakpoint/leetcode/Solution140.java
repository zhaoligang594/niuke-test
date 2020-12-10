package com.breakpoint.leetcode;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/11/01
 */
public class Solution140 {

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> list = new Solution140().wordBreak("catsandog", wordDict);
        System.out.println(list);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Node root = new Node((char) -1);
        for (String str : wordDict) {
            insertArr(str.toCharArray(), root, 0);
        }
        seek(s.toCharArray(), root, 0, root, new StringBuilder());
        return res;
    }


    List<String> res = new ArrayList<>();

    private Deque<String> stack = new ArrayDeque<>();

    private void seek(char[] arr, Node root, int start, Node theFirst, StringBuilder sb) {
        if (start >= arr.length) {
            //System.out.println(stack);
            if (root.val == (char)-1) {
                StringBuilder sb2 = new StringBuilder();
                List<String> temp = new ArrayList<>(stack);
                for (String str : temp) {
                    sb2.append(str + " ");
                }
                res.add(sb2.toString().trim());
            }
            return;
        }
        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).val == arr[start]) {
                sb.append((char) root.child.get(i).val);
                Node node = root.child.get(i);
                if (node.tag == 1) {
                    stack.addLast(sb.toString());
                    seek(arr, theFirst, start + 1, theFirst, new StringBuilder());
                    stack.pollLast();
                    seek(arr, root.child.get(i), start + 1, theFirst, sb);
                } else {
                    seek(arr, root.child.get(i), start + 1, theFirst, sb);
                    //return;
                }
            }
        }
    }


    private static class Node {
        public char val;
        public int tag;
        List<Node> child = new ArrayList<>();

        public Node(char val) {
            this.val = val;
        }
    }

    private void insertArr(char[] arr, Node root, int index) {
        if (index >= arr.length) {
            root.tag = 1;// 结束的标志
            return;
        }
        int i = 0;
        for (; i < root.child.size(); i++) {
            if (root.child.get(i).val == arr[index]) {
                insertArr(arr, root.child.get(i), index + 1);
                return;
            }
        }
        if (i >= root.child.size()) {
            Node node = new Node(arr[index]);
            root.child.add(node);
            insertArr(arr, node, index + 1);
        }
    }

}
