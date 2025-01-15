// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Easy

// A two pointer approach where we'll keep track of the non-duplicate numbers and move them at their right place.

class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicate = 1; // this is already one since index 0th element will be smallest hence, shouldn't be interfered with. So, we've already conunted it

        // and since the 0th index already has the smallest element, we start from index 1.
        for(int i = 1; i < nums.length; i++){
            // since, we started from index 1, we compare the element with its predecessor
            if(nums[i] != nums[i-1]){
                // for example, nonDuplicate is 1, and when we get a non-duplicate no. it becomes 2
                // this is telling us that this non-duplicate element can take the 2nd positon in the array
                // since it's the second unique no.
                
                nonDuplicate++; // this will only be incremented when there's a non-duplicate number
                nums[nonDuplicate - 1] = nums[i]; // swap with the last non-duplicate no.'s place
            }
        }
        return nonDuplicate;
    }
}
