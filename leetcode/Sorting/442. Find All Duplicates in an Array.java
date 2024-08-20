// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// Medium
// tag: cyclic sort

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {

            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) { // this condition will automatically ignore the duplicate values
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else
                i++;

        }
      // Before i was trying to do this step in the same loop,
      // my logic was: when you find a duplicate value add it to the list, but that way that value could be added multiple times in the list
      // because of continuous shuffling, then to avoid it i thought of using !ls.contains condition, but this ran me into TLE
      // because ls.contains method has O(n) time complexity, hence my solution then became of O(n^2)
      // so to avoid it just use a simple separate loop
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) 
                ls.add(arr[i]);
        }

        return ls;
    }
}

// Approach 2:
/*
Each element appears once or twice, and refers to some 1-indexed index in the array. 
So iterate through, marking the number at that index as negative. If it were already negative(this would mean i have already traversed through that index, hence that index is duplicate), 
we add it to the result, since elements appear at most twice. 
*/
