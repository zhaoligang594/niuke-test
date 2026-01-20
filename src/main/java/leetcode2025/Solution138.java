package leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution138 {

    public Node copyRandomList(Node head) {
        Node fakeHead1 = new Node(0);
        fakeHead1.next = head;
        Node fakeHead2 = new Node(0);
        Node cur = fakeHead2;
        Map<Node, Node> target = new HashMap<Node, Node>();
        while (head != null) {
            cur.next = new Node(head.val);
            target.put(head, cur.next);
            cur = cur.next;
            head = head.next;
        }
        for (Map.Entry<Node, Node> nodeNodeEntry : target.entrySet()) {
            Node oriNode = nodeNodeEntry.getKey();
            Node newNode = nodeNodeEntry.getValue();
            if(null!=oriNode.random){
                newNode.random = target.get(oriNode.random);
            }
        }
        return fakeHead2.next;
    }
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
