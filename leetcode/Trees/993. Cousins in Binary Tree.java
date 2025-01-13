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
