// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// Medium

class Solution {
    public int[] twoSum(int[] arr, int t) {
        // since it's sorted we can use the two pointer approach
        int f = 0;
        int l = arr.length - 1;
        while(f < l){
            int sum = arr[f] + arr[l];
            if(sum < t) f++; // since f is at smaller numbers, so if sum comes less than target that
                            // would mean we need a larger number.
            else if(sum > t) l--;
            else return new int[] {f + 1, l + 1};
        }
        return new int[] {-1 , -1};
    }
}