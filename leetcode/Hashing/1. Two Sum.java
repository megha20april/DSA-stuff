// https://leetcode.com/problems/two-sum/description/
// Easy


// this is my brute force solution
// time complexity O(n^2) (approx) space complexity is constant
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[] {i,j};
            }
        }
        return new int[] {-1, -1};
    }
}


//Better and Optimised solution

//Thinking process

// so i want to lower my time complexity, from O(n^2) let's say to O(n) 
// then that means i can traverse through each element only once
// and at each element what am i searching for arr[i] and some element should add upto target
// so i can search for the other pair element i.e. target - arr[i]
// but now how do i search for this pair element in array
// i think if i use array now then i'll have to traverse through the whole thing again
// so here comes the idea that we should use hash maps
// the hash maps can store the elements that we have already traversed in the array with their corresponding indexes
// so as i traverse through our array, i'll check for target - arr[i] in the map, if it exists then return i and index of that element through map
// if it doesn't exist then i'll just store that element in my map and move forward


// time and space complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int key = target - nums[i];
            if(map.containsKey(key)) return new int[] {i,map.get(key)};
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}