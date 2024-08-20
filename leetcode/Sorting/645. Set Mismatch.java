// https://leetcode.com/problems/set-mismatch/description/
// easy
// tag: cyclic sort

// since it's mentioned elements are from 1 to n in the array, we're using cyclic sort
// time linear and space is constant


/*
==============NOTE===============
in these cyclic questions, i always try to do everything in one loop
DO NOT DO THAT!!
since it just leads to too many condition checks and confusion, keep things separate
since it doesn't affect the time complexity anyway
*/
class Solution {
    public int[] findErrorNums(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else i++;
            
        }
        i = 0;
      // after sorting the whole thing
      // we just return the wrong value and the right value
        while(i < arr.length){
            if(arr[i] != i + 1) return new int[] {arr[i], i+1};
            else i++;
        }
        return new int[] {-1, -1};
    }
}
