package leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution117 {

    public Node connect(Node root) {
        Node[] map = new Node[6000];
        dfs(root, map, 0);
        return root;
    }

    private void dfs(Node root, Node[] map, Integer level) {
        if (root == null) return;
        if (map[level] != null) {
            map[level].next = root;
        }
        map[level] = root;
        dfs(root.left, map, level + 1);
        dfs(root.right, map, level + 1);
    }

    public static final class Node {
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

    ;
}


