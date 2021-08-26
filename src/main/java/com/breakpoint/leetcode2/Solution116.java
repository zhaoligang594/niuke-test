package com.breakpoint.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/21
 */
public class Solution116 {


    public Node connect(Node root) {
        if (null != root) {
            dfs(root, 0);
        }
        return root;
    }

    // 由于节点的数量小于 4096 那么 他的深度小于13 是一定的
    private Node[] nodes = new Node[13];

    private void dfs(Node root, int depth) {
        if (null != root) {
            if (null != nodes[depth]) {
                nodes[depth].next = root;
            }
            nodes[depth] = root;
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}