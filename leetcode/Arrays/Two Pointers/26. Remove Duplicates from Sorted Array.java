// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Easy

// A two pointer approach where we'll keep track of the non-duplicate numbers and move them at their right place.

class Solution {
    public int removeDuplicates(int[] nums) {
        int no = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[no] = nums[i]; // swap with the last non-duplicate no.'s place
                no++; // this will only move when there's a non-duplicate number
            }
        }
        return no;
    }
}