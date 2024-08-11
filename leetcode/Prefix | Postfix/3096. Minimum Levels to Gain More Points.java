// https://leetcode.com/problems/minimum-levels-to-gain-more-points/description/
// Medium

// Time and Space complexity: O(n)

// we first make a prefix sum array for scores
// then at each index compare that index's score and all the left elements' score
class Solution {
    public int minimumLevels(int[] possible) {
        int[] scores = new int[possible.length + 1];
        for(int i = 1; i < scores.length; i++){
            scores[i] = scores[i - 1] + ((possible[i - 1] == 0)? -1 : 1);
        }
      // iterate to n-2 only, because every player plays at least one time
        for(int i = 1; i < scores.length - 1; i++){
            int bobSum = scores[scores.length - 1] - scores[i];
            if(scores[i] > bobSum) return i;
        }
        return -1;
    }
}
