// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// Medium

// so basically here obviously we'll do BFS and then for that we'll use queue
// but now we'll have to connect each level nodes with each other
// but to connect each nodes in one iteration i'll need the access of both the current node and the next node in that level
// BUT at the same time i don't want to poll the next level node from my queue as it can lead to further complications
// HENCE, we used the peek method of queues.
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();

            for(int i = 1; i <= levelSize; i++){
                Node temp = q.poll();

                if(i != levelSize) temp.next = q.peek(); 
                // we don't want to connect the last node of a level with anything
                // hence, the above condition is used.
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }

        return root;
    }
}
