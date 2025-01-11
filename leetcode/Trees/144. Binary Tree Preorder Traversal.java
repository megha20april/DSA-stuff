// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// Easy


class Solution {
    // since it goes at each node of the tree the time complexity will be O(n)
    // where n is the no. of nodes in the BT
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();

        // preOrder(root, ls);
        iterative(root, ls);

        return ls;
    }

  // using recursion
    public void preOrder(TreeNode root, List<Integer> ls){
        if(root == null) return; // base condition

        ls.add(root.val); // first the node itself
        preOrder(root.left, ls); // then we go for it's left node
        preOrder(root.right, ls); // lastly the right node
    }

  // follow Up question solution

    public void iterative(TreeNode root, List<Integer> ls){
        if(root == null) return;
        // to convert a non-linear data structure to a linear one we use stacks and queue
        // because usually in non-linear data structures we often use recursion
        // stack and queue are called helping data structures

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode temp = st.pop();

            ls.add(temp.val);
            if(temp.right != null) st.push(temp.right);
            // we add this after right node because we want it on the top of stack
            // to be able to fetch it first
            if(temp.left != null) st.push(temp.left);
        }
    }
}
