// https://leetcode.com/problems/binary-tree-right-side-view/description/
// Medium

// same as normal BFS, but here we just add the last node of each level
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 1; i <= levelSize; i++){
                TreeNode temp = q.poll();
                if(i == levelSize) result.add(temp.val); // add the last node of each level
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }
        return result;
    }
}
