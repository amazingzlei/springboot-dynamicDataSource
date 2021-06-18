package com.example.demo.thread.demo10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 7, 1, 3, 6, 9};
        // 构建二叉树
        TreeNode treeNode = createTree(array, 0);
        System.out.println("前序-递归");
        preOrderTraverse1(treeNode);
        System.out.println("\r\n中序-递归");
        inOrderTraverse1(treeNode);
        System.out.println("\r\n后序-递归");
        postOrderTraverse1(treeNode);

        System.out.println("\r\n前序-迭代");
        preOrderTraverse2(treeNode);
        System.out.println("\r\n中序-迭代");
        inorderTraversal2(treeNode);
        System.out.println("\r\n后序-迭代");
        postOrder2(treeNode);
    }

    public static TreeNode createTree(int[] arr, int index) {
        if (index < arr.length) {
            TreeNode treeNode = new TreeNode();
            treeNode.setVal(arr[index]);
            treeNode.setLeft(createTree(arr, 2 * index + 1));
            treeNode.setRight(createTree(arr, 2 * index + 2));
            return treeNode;
        }
        return null;
    }

    // 前序遍历-递归
    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    // 中序遍历-递归
    public static void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val + " ");
            inOrderTraverse1(root.right);
        }
    }

    // 后序遍历-递归
    public static void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void preOrderTraverse(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        System.out.print(list);
    }

    // 中序遍历-迭代
    public static void inorderTraversal(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }
        System.out.print(list);
    }

    // 后序遍历-迭代
    private static void postOrder(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;
        TreeNode pre = null;

        while (null != current || !stack.isEmpty()) {
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (null == current.right || pre == current.right) {
                stack.pop();
                result.add(current.val);
                pre = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        System.out.println(result);
    }


    public static void preOrderTraverse2(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        System.out.println(list);
    }

    // 中序遍历-迭代
    public static void inorderTraversal2(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }
        System.out.print(list);
    }

    private static void postOrder2(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;
        TreeNode pre = null;
        while (null != current || !stack.isEmpty()) {
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (null == current.right || pre == current.right) {
                stack.pop();
                list.add(current.val);
                pre = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        System.out.println(list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
