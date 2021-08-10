package com.breakpoint.bitree;

import com.breakpoint.annotation.Fail;
import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 树的基本遍历
 * <p>
 * 先序
 * 中序
 * 后序
 *
 * @author breakpoint/zlg
 * 2020/08/30
 */
public class Tree_test_01 {

    public static void main(String[] args) {
        Integer[] tree = {1, 2, 3, 4, 5, 6};
        TreeNode treeNode = TreeUtils.createTree(tree);
        preOrder(treeNode);
        System.out.println("=========");
        proOrderUnRecur(treeNode);
        // 非递归的遍历操作
        morrisPre(treeNode);
        inOrderUnRecur(treeNode);
        levelOrderUnRecur(treeNode);
        posOrderUnRecur(treeNode);
        posOrderUnRecur2(treeNode);
        String s = serialTree(treeNode);
        System.out.println(s);
        TreeNode treeNode1 = reConTree(s);
        System.out.println(treeNode1);
    }

    @Success
    public static void preOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (null != node) {
            stack.addLast(node);
            node = stack.peekLast();
            System.out.println(node.val);
            node = node.left;
            while (node == null && !stack.isEmpty()) {
                node = stack.pollLast().right;
            }
        }
    }

    // 访问节点
    private static void visit(TreeNode node) {
        // to do something
        System.out.println(node.val);
    }

    /**
     * 深度优先 先序遍历
     *
     * @param root 根节点
     */
    public static void preOrderDfs(TreeNode root) {
        if (null != root) {
            // 访问节点信息 处理相关操作
            visit(root);
            preOrderDfs(root.left);
            preOrderDfs(root.right);
        }
    }

    /**
     * 深度优先 中序遍历
     *
     * @param root 根节点
     */
    public static void inOrderDfs(TreeNode root) {
        if (null != root) {
            inOrderDfs(root.left);
            // 访问节点信息 处理相关操作
            visit(root);
            inOrderDfs(root.right);
        }
    }

    /**
     * 深度优先 后序遍历
     *
     * @param root 根节点
     */
    public static void postOrderDfs(TreeNode root) {
        if (null != root) {
            postOrderDfs(root.left);
            postOrderDfs(root.right);
            // 访问节点信息 处理相关操作
            visit(root);
        }
    }

    /**
     * 广度优先 水平遍历
     *
     * @param root 跟节点
     */
    public static void lfs(TreeNode root) {
        // 创建队列对象
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (null != root) {
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                visit(node);
                if (null != node.left) queue.addLast(node.left);
                if (null != node.right) queue.addLast(node.right);
            }
        }
    }

    // 先序遍历的操作
    public static void proOrderUnRecur(TreeNode head) {
        System.out.println("pro-order");
        if (null != head) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            stack.addLast(head);
            while (!stack.isEmpty()) {
                head = stack.pollLast();
                System.out.print(head.val + " ");
                if (head.right != null) stack.addLast(head.right);
                if (head.left != null) stack.addLast(head.left);
            }
        }
        System.out.println();
    }

    // 中序遍历
    public static void inOrderUnRecur(TreeNode head) {
        System.out.println("in-order");
        if (null != head) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            while (!stack.isEmpty() || head != null) {
                if (null != head) {
                    stack.addLast(head);
                    head = head.left;
                } else {
                    head = stack.pollLast();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    // 后序遍历
    public static void posOrderUnRecur(TreeNode head) {
        System.out.println("pos-order");
        if (null != head) {
            Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
            Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
            stack1.addLast(head);
            while (!stack1.isEmpty()) {
                head = stack1.pollLast();
                stack2.addLast(head);
                if (head.left != null) stack1.addLast(head.left);
                if (head.right != null) stack1.addLast(head.right);

            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pollLast().val + " ");
            }
        }
        System.out.println();
    }

    // 后序遍历2
    public static void posOrderUnRecur2(TreeNode h) {
        System.out.println("pos-order");
        if (null != h) {
            Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
            stack1.addLast(h);
            TreeNode c = null;
            while (!stack1.isEmpty()) {
                c = stack1.getLast();
                if (c.left != null && h != c.left && h != c.right) {
                    stack1.addLast(c.left);
                } else if (null != c.right && h != c.right) {
                    stack1.addLast(c.right);
                } else {
                    System.out.print(stack1.pollLast().val + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }


    // 中序遍历
    public static void levelOrderUnRecur(TreeNode head) {
        System.out.println("level-order");
        if (null != head) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            stack.addLast(head);
            while (!stack.isEmpty()) {
                head = stack.pollFirst();
                System.out.print(head.val + " ");
                if (head.left != null) stack.addLast(head.left);
                if (head.right != null) stack.addLast(head.right);
            }
        }
        System.out.println();
    }


    /**
     * 序列化的操作
     *
     * @param root 二叉树的根结点
     * @return
     */
    public static String serialTree(TreeNode root) {
        if (null == root) return "#_";
        return root.val + "_" + serialTree(root.left) + serialTree(root.right);
    }

    /**
     * 反序列化树结构
     *
     * @param data
     * @return
     */
    public static TreeNode reConTree(String data) {
        if (null == data || "".equals(data)) return null;
        String[] split = data.split("_");
        Deque<String> queue = new ArrayDeque<>();
        for (String str : split) {
            queue.addLast(str);
        }
        return reConTree(queue);
    }

    private static TreeNode reConTree(Deque<String> queue) {
        TreeNode res = null;
        if (!queue.isEmpty()) {
            String s = queue.pollFirst();
            if ("#".equals(s)) return null;
            res = new TreeNode(Integer.valueOf(s));
            res.left = reConTree(queue);
            res.right = reConTree(queue);
        }
        return res;
    }

    // 额外空间的复杂度是O（1）的空间复杂度
    // 中序遍历
    public static void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head, mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (null != mostRight) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } // end if
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }


    // 主要是看访问节点的时机 时机是什么样子的
    public static void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head, mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (null != mostRight) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    // 第一次访问节点的时候，进行打印的操作
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                // 第一次访问节点的时候，进行打印的操作
                // 注意：第一次与第二次是合并在一起的
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }


    // 打印二叉树
    public static void printTree(TreeNode root, int level) {

    }
}
