// https://leetcode.com/problems/single-number/description/
// Easy


// there was no other way to solve this in the constraint of linear time complexity and constant space complexity.

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

      // simple XOR operation as:
      // A ^ A = 0
      // A ^ 0 = A
        for(int num : nums){
            res = res ^ num;
        }
        return res;
    }
}
