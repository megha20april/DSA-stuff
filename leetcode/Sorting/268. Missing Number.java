// https://leetcode.com/problems/missing-number/description/
// Easy
// tag: bit manipulation, cyclic sort, simple maths, arrays.sort()

// cyclic sort
// time: linear and constant space
// since in the ques it was given that values are in the range 1 to n, we'll use cyclic sort
// we'll put every no. at its index
// for element = arr.length we'll ingnore it and move foward
// and store the last ignored index( that will be the missing no. itself ) in a variable 
// if nothing was ignored, that would mean that arr.length no. was the missing no. 
// so we'll just initialize ignored as arr.length
class Solution {
    public int missingNumber(int[] arr) {
        int i = 0;
        int ignored = arr.length;
        while(i < arr.length){
            if(arr[i] == arr.length){ 
                ignored = i;
                i++;
            }
            else if(arr[i] != i){
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }else i++;
        }
        return ignored;
    }
}

// solution 2: subtract sum of given array from numbers from 1 to n
// solution 3: using XOR
