// https://leetcode.com/problems/diameter-of-binary-tree/description/
// Easy BUT for me it's Medium

// diameter of a tree at a node is the sum of the heights of its left and right subtrees plus 2.
// the height of a leaf node is 0, and it can be calculated recursively 
// by returning Math.max(height(n.left), height(n.right)) + 1;


// at first i was doing both the calculation of diameter and the height calc in two separate recursive functions
// which was increasing the time complexity unncessarily to O(n*2)
// The time complexity is not linear because the height function is recomputed multiple times for the same nodes across different calls to diameter.
// This way the height for each node is getting computed redundantly.

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return diameter;
    }
  
public void diameter(TreeNode n){
        if (n == null) return;
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        int p = leftHeight + rightHeight + 2;
        diameter = Math.max(diameter, p);
        diameter(n.left);
        diameter(n.right);
}

    public int height(TreeNode n){
        if(n == null) return -1;
        return Math.max(height(n.left), height(n.right)) + 1;
    }

}

// =======================BETTER SOLUTION============================
// instead of calculating diameter in a separate function, we can calculate it along side the height of each node
// this way we will calculate the height for each node only once
// in the height function, we only return height at each stage, but also simaltaneously update the maximum diameter.

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode n){
        if(n == null) return -1;

        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        int p = leftHeight + rightHeight + 2;
        diameter = Math.max(diameter, p); // updating the diameter

      // DO NOT WRITE THIS!!!
      // return Math.max(height(n.left), height(n.right)) + 1;
      // The recursion tree doubles at every level due to redundant recursive calls in both the computation (int leftHeight = height(...)) and the return statement (return Math.max(height(...))). For 
      // 𝑛 nodes, this results in 2^𝑛 recursive calls.
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
