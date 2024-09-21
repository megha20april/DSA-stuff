// https://leetcode.com/problems/single-number-ii/description/
// Medium

// Since we can only use constant space, we can't use hashmaps or something like that
// -2^31 <= nums[i] <= 2^31 - 1 through this we can tell that these numbers are 32-bit signed integers.
// So basically what we're doing here is, 
// Since each number appear thrice, those numbers will add their bits thrice right? BUT if a number only appears once or twice, it'll add it's bits only once or twice
// so if for each bit position, i go to each number in nums, and check if that number has any bit on that position.
// if it does then after the loop i get the total bits present on that position
// and then i can check if it's divisible by 3 or not, and store the result in sheep.
class Solution {
    public int singleNumber(int[] nums) {
        int[] output = new int[32];
        int sheep = 0;
        for(int bit = 0; bit < 32; bit++){
            int mask = 1 << bit; // mask for that particular position.
            for(int i = 0; i < nums.length; i++){
              // here if that number has 1 on that position, it'll increament the total bits for that position.
                if((nums[i] & mask)!=0) output[bit]++;
            }
          // now here, if the total bits are not divisible by 3 then that would mean there was a number, which was appearing only once,
          // had 1 on this position. And now if i store this position in sheep i'll eventually get the whole number.
            if(output[bit]%3 != 0) sheep+=mask;
        }
        return sheep;
    }
}
