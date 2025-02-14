// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Medium

class Solution {
  // so since we needed the sorted sequence, i thought of inorder traversal
  // then i had two option in my head, first to keep a counter (like when it becomes equal to k, i'll kind of return that value)
  // but it was hard to manage that counter (you know like when to increment it and stuff)
  // then since we were doing inorder traversal i thought of an array
  // then it struck me that okay to not waste space i can stop filling my array when i fill it till k length
  // so i made a recursive function for inorder traversal that stopped adding elements in the array
  // when the array got the kth element
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>(); // made it a arraylist to add elements without worrying about the index
        inOrder(root, arr, k);
        return arr.get(k - 1);
    }
    public void inOrder(TreeNode node, ArrayList<Integer> arr, int k){
        if(arr.size() >= k) return; 
        if(node == null) return;

        inOrder(node.left, arr, k);
        arr.add(node.val);
        inOrder(node.right, arr, k);
    }
}
