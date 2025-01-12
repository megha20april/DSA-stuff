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


// ==============================SOLUTION 2=================================

// solution with constant space complexity
// for constant space complexity, we'll have to eliminate the use of queue right?
// and leverage the things given in the question itself
// so i know i have to connect all level nodes with each other right?
// so what if, for ex., at root node, i first connect it's children nodes i.e. left and right
// so what we're doing is, at each level we're connecting nodes of the next level
// and to ensure we have a next level we can use conditions like cur.left != null
// because it's a perfect BT, if the leftest node of a level doesn't have a left node than that would mean
// that there's no next level

// now if my current node is 2, then i connect 4 and 5 BUT then the problem comes, how do i connect 5 and 6?
// for this you should make a diagram
// you should remember that we've already connected 2 and 3, so we have an access point to next level node
// so at each node i'll have two tasks to do, first to connect its children nodes
// then secondly we'll check if our node has a level successor node or not, because if it doesn't that means
// it's the last node in the whole level (for ex. in case of node 3, it doesn't have a next node since it's the last node in the whole level)
// if the node has a next node, then we do temp.right.next = temp.next.left; (now this will connect 5 to 6)
// and then we can move to next node i.e. 3 using temp = temp.next;

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        // we'll have two loops
        // the outer one will move from level to level i.e. top to bottom
        // and the inner one will move from left to right inside a level to connect the nodes of the next level
        // now to track the current level in the outer node we use this pointer
        Node curLevel = root;

        // at the last level, we don't have to do anything
        // our work is done at second last level
        // hence we use the below conditions
        while(curLevel.left != null){
            Node temp = curLevel;
            
            while(temp != null){ 
                // for each non-null node in the level we need to do the below step
                // this tree is perfect BT, hence each node will definetly have two children
                temp.left.next = temp.right;
                
                // then we check if there's any successive level node ahead of temp
                // because if there is, then that means that scuccessive node'll also have 2 children
                // which need to be connected to our current node's right node.
                if(temp.next != null) temp.right.next = temp.next.left;
                
                // if there's no successive level node, then temp becomes null
                // otherwise it traverses in the level
                temp = temp.next;
            }

            // move to the next level
            curLevel = curLevel.left;
        }

        return root;
    }
}
