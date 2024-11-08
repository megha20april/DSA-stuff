// https://leetcode.com/problems/plus-one/description/
// Easy


// there's a more straightforward answer below this one
class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        int add = 1;
        int i = digits.length - 1;
        while(add > 0){
            if(i < 0){ // when we've iterated through the whole array but add > 0
                int[] n = new int[digits.length + 1];
                n[0] = 1;
                return n; // this case can only be when the answer is something like 1000....
            }
            sum = digits[i] + add;
            digits[i--] = sum%10;
            add = sum/10;
        }
       return digits;
    }
}


// more straightforward answer

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                break; // we don't need to iterate unnecessarily here
            }
            digits[i] = 0; // if it's 9 then make it 0 and go to the next digit
        }

        if(digits[0] == 0){ // this is only possible when all the other digits are also 0
            int[] al = new int[digits.length + 1];
            al[0] = 1;
            return al;
        }
       return digits;
    }
}
