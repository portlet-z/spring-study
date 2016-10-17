package com.zhang.springmvc;

/**
 * Created by zhangxinzheng on 16/9/23.
 */
public class BinaryTree {
    public class TreeNode {
        int leftOrRight = 0;// 0: root;-1:left;1, right;
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;
    private int size = 0;

    public BinaryTree() {
    }

    public TreeNode getRoot() {
        return root;
    }
    private TreeNode findParentNode(int value) {
        TreeNode parent = null;
        TreeNode node = root;
        while (node.value != value) {
            parent = node;
            if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
            if (node == null) {
                node = null;
                parent = null;
            }
        }
        return parent;
    }
}

