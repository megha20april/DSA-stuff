// https://leetcode.com/problems/first-missing-positive/
// Hard
// tag: cyclic sort

// Time: O(n) and space: O(1)
// The problem is basically to identify that we'll have to use cyclic sort here
// the only solution i can think of for that, is basically sit with a pen and paper
// and look how you can get the answer, try to get to the pattern that we're actually searchin for numbers between 1 to n only
// only numbers from 1 to n matter to us
class Solution {
    public int firstMissingPositive(int[] arr) {
        int i = 0;
        while(i < arr.length){
          // here we're sorting the array in cyclic manner meaning placing the number on number - 1 index
            int correct = arr[i] - 1;
          // and ignoring the negative, 0 and numbers > arr.length
            if(correct >= 0 && correct< arr.length && arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else i++;
        }
        
        i = 0;
        while(i < arr.length){
          // this will return the first index that doesn't have the correct value on it
            if(arr[i] != i + 1) return i + 1;
            i++;
        }
        return arr.length + 1; // if everything was at it's place then just return this
    }
}
