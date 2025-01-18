// https://leetcode.com/problems/invert-binary-tree/description/
// Easy


// pretty easy as at each node, you just have to swap its left and right subtrees.
// time is linear as it goes over each node only once
// space is also linear, as in the worst case, which is a skewed tree, height is equal to n
class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode n){
      // this condition will check for null and leaf nodes
        if(n == null || (n.left == null && n.right == null)) return;
      // on leaf nodes we don't need to swap anything.

        TreeNode temp = n.left;
        n.left = n.right;
        n.right = temp;

      // once swap is done, we go deeper in the tree to swap nodes.
        invert(n.left);
        invert(n.right);
    }
}
