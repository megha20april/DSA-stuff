// https://leetcode.com/problems/subarray-sum-equals-k/description/
// Medium

class Solution {
    public int subarraySum(int[] arr, int k) {
        // sliding window won't work because of negative no.'s
        // so the brute force method could be that for each element of array, we get a prefix sum array
        // but that would be n^2 time complexity

        // we can track the prefix sums for each element (let's say index b) starting from index 0
        // we know sum_from_0tob, but what about sum_from_atob (where 0 < a < b)
        // so for that what if we keep track of all the prefix sum that we get for each element in a hashmap
        // 'the prefix sum value' ---->> 'no. of subarrays (starting from index 0) had this prefix sum value'
      
        // like if we're at index b, we'll obviously have sum_from_0tob
        // then we can get sum_from_0tob - k = t (the amount of sum that needs to be removed from this sum)
        // and once we get this t, we check if there previously existed a prefix sum equal to t in the hashmap

        // example:
        // suppose for index b = 4, sum_from_0to4 = 10 and k was 5
        // then i'll do 10 - 5 = 5, and check if there was a prefix sum that had value 5 
        // and after checking in the hashmap i found, there were two subarrays before this who had
        // 5 prefix sum, so here that would mean that we can remove those two subarrays from our 
        // index 0 to index 4 subarray, which will result in two subarrays having the sum as k

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        int result = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            int diff = sum - k;

            if(map.containsKey(diff)) result += map.get(diff);
            if(diff == 0) result++; // add the subarray itself

            map.put(sum, map.getOrDefault(sum, 0) + 1); // add/incremetn this particular prefix sum value's count
        }

        return result;
    }
}
