// https://leetcode.com/problems/find-pivot-index/description/
// Easy

// O(n) time and O(1) space.
// this is much simpler approach then mine(scroll down)

// insted of finding the whole prefix array we just compare leftSum and rightSum as we iterate through the array
class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num; 
        }
        
        int leftTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightTotal = total - leftTotal - nums[i]; // reducing it as we move forward
            if (rightTotal == leftTotal) {
                return i;
            }
            leftTotal += nums[i]; // updating it as we move forward
        }

        return -1;        
    }
}



// O(n) time and O(1) space.

//This is a longer solution and my first approach.
//first we make a prefix sum array then i do linear search on the whole array 
// in which for each element we're checking the leftSum and the rightSum


// The main thing here is that you also could've done binary search on the prefix array....right?
// NOOO... cuz in case of positive elements, this will be sorted BUT in case of negative elements, the array will no longer be sorted.
class Solution {
    public int pivotIndex(int[] nums) {
        return findPivot(sumArray(nums));
    }
    int[] sumArray(int[] nums){
        for(int i = 1; i<nums.length; i++){
            nums[i] += nums[i - 1]; // i made changes in the original array itself, hence my space complexity is constant.
        }
        return nums;
    }
    int findPivot(int[] nums){
        int rightSum, leftSum;
        for(int i = 0; i<nums.length; i++){
            leftSum = (i == 0)? 0 : nums[i - 1]; // did this to not get ArrayOutOfBound error and it's also mentioned in the problem
            rightSum = nums[nums.length - 1] - nums[i];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}
