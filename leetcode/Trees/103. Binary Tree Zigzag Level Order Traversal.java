// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Medium

// obviously we're using BFS here, but in a different manner
// first we print from left to right then vice-versa.
// so the second time i'll have to actually poll nodes from the back of the queue(to get the reverse order)
// and simaltaneously adding to the front of the queue
// and we'll do this reverse and normal way of polling and adding alternatively
// by using a boolean reverse value which will be false initially

// to be able to insert and remove from both sides we can use deque
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);

        boolean rev = false;

        while(!dq.isEmpty()){
            int levelSize = dq.size();

            List<Integer> curLevel = new ArrayList<>();

            for(int i = 1; i <= levelSize; i++){
                if(!rev){ // normal left to right case
                    TreeNode temp = dq.pollFirst();
                    curLevel.add(temp.val);
                    if(temp.left != null) dq.offerLast(temp.left);
                    if(temp.right != null) dq.offerLast(temp.right);
                }else{
                    TreeNode temp = dq.pollLast();
                    curLevel.add(temp.val);
                    
                    // now even if we're adding from starting we still want to access the left node first
                    // hence we'll first add the right node then the left
                    if(temp.right != null) dq.offerFirst(temp.right);
                    if(temp.left != null) dq.offerFirst(temp.left);
                }
            }
            // flip the reverse boolean
            rev = !rev;
            result.add(curLevel);
        }

        return result;

    }
}
