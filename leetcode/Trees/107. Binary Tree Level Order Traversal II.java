// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// Medium

// this is going to be exactly the same as the regular BFS
// the only thing that's going to change is the final result arraylist
// in regular BFS we add each level Lists at the end right?
// Well, here we're going to add level lists at the start of the result ArrayList
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
             
            List<Integer> curLevel = new ArrayList<>();

            for(int i = 1; i <= levelSize; i++){
                TreeNode temp = q.poll();
                curLevel.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }

            result.add(0, curLevel); // here's the CATCH!! we're going to insert each level at the start of result array
        }

        return result;
    }
}
