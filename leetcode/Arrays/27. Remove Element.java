// https://leetcode.com/problems/remove-element/
// Easy


// In this solution, i couldn't find another way to keep track of the occurences of val to swap the non-val numbers with.
// so i thought let's keep track of no-val numbers only whnever there'll be a val the non-val counter won't consider it.
// and any non-val number will be then placed at the val's place.
class Solution {
    public int removeElement(int[] nums, int val) {
        int nonVal = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[nonVal] = nums[i];
                nonVal++;
            }
        }
        return nonVal;
    }
}
