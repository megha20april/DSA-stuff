// https://leetcode.com/problems/symmetric-tree/
// Easy

class Solution {
    public boolean isSymmetric(TreeNode root) {
       
        return worker3(root);
    }

  // Since we want symmetry across a level, we can use BFS or queue for the iterative solution
  // now what i first thought was that i wanted to only incorporate some small changes in the original BFS algo
  // hence i made up a curLevel array at each level half the size of that level, which is then filled by half the nodes of that level
  // and then i stopped filling the array, and started checking each node with its corresponding node in the array
  // for example, if a level has 6 nodes then the 4th node is going to be checked with the 3rd node and the 5th node is going to be checked with the 2nd node etc.
  
  // BUTT A MAJOR MISTAKE THAT I DID IN THIS WAS:
  // that i should've paid more attention to the examples given
  // that is why when i was making up the current node, i didn't consider null nodes
  // because if we do not consider them the order of nodes in the curLevel array gets messed up
  // because you no longer know where exactly does that node lie in that particular level

    boolean worker2(TreeNode root){// time and space are linear
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){

            int levelSize = q.size();

          // Integer array is used because we also want null values.
            Integer[] curLevel = new Integer[levelSize/2];
            // since i'm also taking null values
            // levelSize will always be even
            // so i don't need to worry about the case, when it wouldn't be

            for(int i = 0; i < levelSize; i++){
                TreeNode temp = q.poll();
              // safegaurd for when temp is null, since we're also considering null nodes
                Integer value = temp == null? null : temp.val;
                if(i < levelSize/2){
                  // halfway through the loop, we're just adding nodes here
                    curLevel[i] = value;
                }else{
                  // after filling up the array we start checking equality of nodes
                    if(curLevel[levelSize - i - 1] != value) return false;
                }

              // we don't have left and right pointer of a null node
                if(temp != null){
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }

        }
        return true;
    }

  // SMART SOLUTION
  // For recursive method, at a time we only consider two nodes and their values
  
  // TIme: O(N) since we're visiting each node once
  // Space: O(logN) since it's doing DFS traversal so it's worst case should be the height of a skewed tree BUTT here that's not the case
  // because here if we had a skewed tree, it would've returned false on the first go
  // hence here, the worst case will be to actually check all the nodes of a balanced tree (a lot of nodes), whose height is logN
    boolean workerRecur(TreeNode n1, TreeNode n2){
      // we first check if both of them are null
        if(n1 == null && n2 == null) return true;
      // then we check if one of them is null while the other isn't
      // then checking if their values are equel
        if((n1 == null || n2 == null) || (n1.val != n2.val)) return false;

      // if the above conditions are satisfied, we can move on to the next nodes
      // now here's the caveat, when you move further from root.left and root.right node
      // then you should remember that n1.left is corresponding to n2.right in a mirror
        boolean t = worker(n1.left, n2.right);
        if(!t) return false;

      // if the above part is also satisfied we then finally check for the other subtrees as well
        return worker(n1.right, n2.left);
    }

  // Then we can also implement the above solution (which is smarter) iteratively like this:
  
    boolean worker3(TreeNode root){
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
          // considering two nodes at once
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
          // same conditions as the recursive solution
            if(n1 == null && n2 == null) continue; 
          // at first i wrote in the above condition return true; (same as recursion)
          // which threw error, that worked in recursion because that return won't break the whole recursion call routine
          // but here if i did that, it will break the loop, which i don't want
          // i just want it to check further, hence, we do continue;
          
            if(n1 == null || n2 == null || n1.val != n2.val) return false;

          // here's the caveat, you want to keep the order of level so that the mirror pair of nodes come together
            q.offer(n1.left);
            q.offer(n2.right);
            q.offer(n1.right);
            q.offer(n2.left);
        }

        return true;
    }
}
