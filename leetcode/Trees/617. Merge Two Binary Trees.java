// https://leetcode.com/problems/merge-two-binary-trees/description/
// Easy

// time complexity will be linear as union of m and n
// for space complexity it will also be linear (the height of the tree)
class Solution {
  // basically in recursion, i will traverse each nodes for both the trees
  // and when one of them's node becomes null, we'll just return the other one's whole sub tree.
  // but when both of them are not-null we'll first go deep into their left and right 
  // then after getting their left and right subtrees resolved, we'll return a node containg the left and right subtree
  // with it's value as the sum of both the tree's current node.
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        return mer(root1, root2);
    }
    public TreeNode mer(TreeNode n1, TreeNode n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        TreeNode left = mer(n1.left, n2.left);
        TreeNode right = mer(n1.right, n2.right);

        return new TreeNode(n1.val + n2.val, left, right);

    }
}
