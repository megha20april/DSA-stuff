// https://leetcode.com/problems/path-sum-ii/description/
// Medium

// space same as height of the tree for both the arr and recursion
// for time also linear since we're traversing each node once

class Solution {
    // the only challenge here is to figure out how to store and manage all the nodes while doing dfs
    // and that could be achieved by keeping an array (and in this case sum as well)
    // in which we'll add nodes and remove them after getting done with their left and right sub trees
    // and when we get a LEAF node, we can compare the sum of that array with the target and add
    // this array to the result nested array
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        int sum = 0;
        List<List<Integer>> totarr = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        dfs(root, t, arr, totarr, sum);
        return totarr;
    }
    public void dfs(TreeNode node, int t, List<Integer> arr, List<List<Integer>> totarr, int sum){
        if(node == null){ // at first i implementation of adding the arr to the result nested array here
                        // but it was wrong as i have to make sure both the left and right of a node are null
            return;
        }

        arr.add(node.val);
        sum += node.val;
        dfs(node.left, t, arr, totarr, sum);
        dfs(node.right, t, arr, totarr, sum);
        // here we have to check for when both of left and right are null to make sure it's a leaf node
        if(node.left == null && node.right == null && sum == t) totarr.add(new ArrayList<>(arr));
        arr.remove(arr.size() - 1);
        sum -= node.val;
    }
}
