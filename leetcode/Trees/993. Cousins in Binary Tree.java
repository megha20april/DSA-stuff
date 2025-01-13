// https://leetcode.com/problems/cousins-in-binary-tree/
// Medium

// here we're asked for nodes on same level, hence obv we're going to use BFS
// now i could've easily tracked if they are on the same level or not by using two bool pointers
// but we have to make sure they don't have same parent also, which is the catch of this question
// so for that i used integer pointers which will store the parent's value (all the nodes value are UNIQUE)
// with initial value as -1 which will tell me if they exist on the same level or not

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;

        // okay the first condition says x != y, that means root node is out of the question
        // so if either x or y matches root.val, we return false
        if(root.val == x || root.val == y) return false;

        // then the second condition says that x and y should have different parents
        // then that checks out root.left and root.right nodes.
        if(root.right != null && (root.right.val == x || root.right.val == y)) return false;
        // before checking both these nodes' values, we first check if they are not null to avoid nullPointerException
        if(root.left != null && (root.left.val == x || root.left.val == y)) return false;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            
            int levelSize = q.size();

            // at each level i reset these parents, because i need them to be set on the same level
            // hence, i don't need to preserve the value of previous levels.
            // when xParent gets set, it tells me that 'yes' x exists in this level,
            // and then i store x's parent element in this pointer
            // same for yParent, and when they both get set, i check if they are different or not.
            int xParent = -1;
            int yParent = -1;

            for(int i = 1; i <= levelSize; i++){
                TreeNode temp = q.poll();

                if(temp.left != null){
                    q.offer(temp.left);

                    // since i want to compare x and y's parents, hence,
                    // we check each level's nodes for x and y in the earlier node
                    if(temp.left.val == x) xParent = temp.val;
                    else if(temp.left.val == y) yParent = temp.val;
                }  
                if(temp.right != null){
                    q.offer(temp.right);
                    if(temp.right.val == x) xParent = temp.val;
                    else if(temp.right.val == y) yParent = temp.val;
                }
            }

            // if both of them become set and are different then they are cousins!!
            if(xParent > 0 && yParent > 0 && xParent != yParent) return true;

            // if both of them become set and are same then they are not cousins
            if(xParent > 0 && yParent > 0 && xParent == yParent) return false;

            // if even one of them becomes set, while the other is still -1,\
            // then that would mean they are on different level
            // which is a BIG NO for them to be cousins!!
            if(xParent < 0 && yParent > 0) return false;
            if(yParent < 0 && xParent > 0) return false;

        }

        return false;
    }
}



// Solution 2

// this approach is like very straight-forward.
// the first condition was to check if thery're on the same level or not, so we check that
// then the second condition was that they should have different parent, hence we also check that
// if both the above conditons are satisfied, we just return true!!

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
       // checking if on same level or not
       if(Level(root, x, 0) != Level(root, y, 0)) return false;

       // checking if they have different parent
       if(Parent(root, x, -1) == Parent(root, y, -1)) return false;

       // if(isSibling(root, x, y)) return false;  ---> too complicated, but noteworthy

       // if both conditions are satisfied, then return true
       return true; 
    }

    int Level(TreeNode node, int n, int level){
        if(node == null) return -1; // we couldn't find the node

        // found the node
        if(node.val == n) return level;

        // if we don't find the node, then we go to the left route
        int l = Level(node.left, n, level+1);
        // if we did get a positive value, that means that we found the node
        // hence we can just return it without checking any further
        if(l > 0) return l;

        // if we didn't find it on the left way, then we go to the right route
        return Level(node.right, n, level+1); // since we don't have any other route left, we just return the response we get from this
    }

    int Parent(TreeNode node, int n, int parent){
        if(node == null) return -1; // we couldn't find the node
        if(node.val == n) return parent;

        int l = Parent(node.left, n, node.val);
        if(l > 0) return l;
        return Parent(node.right, n, node.val);
    }

    // another way of checking same parents
    // BUT i found it way more complicating, because of all the conditionals
    boolean isSibling(TreeNode n, int x, int y){
        if(n == null) return false;
                                                        
        return ((n.left != null && n.right != null && ((n.left.val == x && n.right.val == y) || (n.left.val == y && n.right.val == x))) || isSibling(n.left, x, y) || isSibling(n.right, x, y));
    }
}
