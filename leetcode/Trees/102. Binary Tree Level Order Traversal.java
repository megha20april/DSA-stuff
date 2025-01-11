// https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/1505272978/
// Medium

// In BFS, we use queues because queues follow FIFO that helps in getting the right order of elements for level order traversal.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //both time and space are linear


        // so at first obviously we need a result nested array
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result; // empty list

        // now we make a queue to help us in implementation

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root); // insert the root

        while(!q.isEmpty()){
            // now in the output format
            // we need a separate list for each level
            // hence at each iteration  we'll create a new list every time for every level

            // BUT how would we know the no. of elements to take out from the queue (meaning the no. of nodes at each level) in each iteration because 
            // we'll be continuously adding the left and right nodes for each node in the queue, so we have to know the no. of nodes in a level to stop polling nodes from the queue
            
            // at the start of each iteration q's size can give us the no. of nodes in that level
            // since in each iteration we'll poll out all the nodes of level i and offer all the nodes of level i + 1
            // so that we can print only one level's nodes and not the next one's.

            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            // now let's say the level size is 3
            // then i'll only poll 3 nodes out of the queue 

            for(int i = 1; i <= levelSize; i++){
                TreeNode temp = q.poll();
                currentLevel.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }

            // now that we have all the nodes for current level in a list
            // we can just add them to our result list

            result.add(currentLevel);
        }

        return result;
    }
}
