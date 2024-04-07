package com.nayeem.dsa.hasmap.keys;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DuplicateSubTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        serialize(root, map, result);
        return result;
    }
    
    private String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "#";
        
        String key = node.val + "," + serialize(node.left, map, result) + "," + serialize(node.right, map, result);
        map.put(key, map.getOrDefault(key, 0) + 1);
        
        if (map.get(key) == 2) {
            result.add(node);
        }
        System.out.println(key);
        return key;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);
        root1.right.left.left = new TreeNode(4);

        DuplicateSubTrees duplicateSubTrees = new DuplicateSubTrees();
        List<TreeNode> duplicates = duplicateSubTrees.findDuplicateSubtrees(root1);
        for (TreeNode duplicate : duplicates) {
            // Assuming TreeNode has a method to print its structure
            System.out.println(duplicate);
        }
    }
}
