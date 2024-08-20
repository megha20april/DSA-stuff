// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
// Easy
// tag: cyclic sort, 

// since values are in the range 1 to n, we'll do cyclic sort here
// ignore the values that are equal to their correct index's value(means we ignore duplicate elements)
// then again traverse through the whole array, and push the indexes(+1) that don't have the correct values.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
          // there's a better way to handle these conditions that's mention below this soln
            if(arr[i] == arr[arr[i] - 1]) i++;
            else if(arr[i] == i + 1) i++;
            else {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for(int j = 0; j<arr.length; j++){
            if(arr[j] != j+1) ls.add(j+1);
        }
        return ls;
    }
}

        while(i < arr.length){
          int correct = arr[i] - 1;
          if(arr[i] != arr[correct]) --> swap   // this will automatically ignore the duplicate elements
          else ----> i++;


// Solution 2, O(n) time and O(1) space
/*
Iterate over the array, every time we see a number, say 4, we mark the 4th number (index 3) as a negative(only if it's positive, if it's already -ve that would mean it's seen). 
Since numbers in the range are always positive, we can use a negative to easily indicate that that number (by its index) has been seen. 
For example: [4, 3, 1, 2, 3], when we see the 4, we make the 2 a -2. Do this for all numbers. 
Now, we iterate over the array again, and any number that is still positive means there was no number that pointed to that, so we construct our result.
*/
