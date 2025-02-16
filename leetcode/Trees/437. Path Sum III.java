// https://leetcode.com/problems/path-sum-iii/
// Medium but felt like Hard



class Solution { // Side effects (modifying a global variable in recursion) --> might seem easier but is not preferred

  // in path sum 2, we just had to maintain one array and return the path from the root
  // but in this question, the root is not mandatory
  // hence, we need to do something else
  // so here we did the same thing as the question, "Subarray sum equals k"
  // where using a hashmap, we managed the prefix sums of different sub arrays

  // ============IMPORTANT===============
  // look at the constraints, the numbers are two big and would overflow int data type
  // hence, we'll have to use long datatype
  
    HashMap<Long, Integer> map = new HashMap<>(); // this was done, so that i won't have to pass it as an argument
    int result = 0; // reason's same as above BUT:
                    // if i do it like this then the original value of this result variable will be manipulated
                    // and if i had passed it as an argument then it would be like the soution 2
                    // but solution 2 is the better way, because it makes the function reusable
    public int pathSum(TreeNode root, int targetSum) {
        long prfSum = 0;

        dfs(root, (long) targetSum, prfSum);
        return result;
    }
    public void dfs(TreeNode node, long t, long prfSum){
        if(node == null) return;

        prfSum += node.val;
        long diff = prfSum - t;

        if(map.containsKey(diff)) result += map.get(diff);
      // or you can just do this as well:
      // result += map.getOrDefault(diff, 0);
      
        if(diff == 0) result++;

        map.put(prfSum, map.getOrDefault(prfSum, 0) + 1);

        dfs(node.left, t, prfSum);
        dfs(node.right, t, prfSum);
      
        map.put(prfSum, map.get(prfSum) - 1); // removed the sum from map, when backtracking
      // NOTE: i didn't need to subtract the node.val from prefSum, because in the stack call it will return to it's corresponding value
    }
}


// ======================Solution 2==========================
// Accumulation return values in recursion

class Solution {
    HashMap<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        long prfSum = 0L;
        return dfs(root, (long) targetSum, prfSum);
    }

    public int dfs(TreeNode node, long t, long prfSum) {
        if (node == null)
            return 0;

        prfSum += node.val;
        long diff = prfSum - t;

      // for each node, i'll have a result value,
      // which will have contain the final result resulting from the operations on that node, its left and right subtrees
        int result = map.getOrDefault(diff, 0);
        if (diff == 0)
            result++;

        map.put(prfSum, map.getOrDefault(prfSum, 0) + 1);

        result += dfs(node.left, t, prfSum) + dfs(node.right, t, prfSum);

        map.put(prfSum, map.get(prfSum) - 1);
        return result;
    }
}

