// https://leetcode.com/problems/valid-parentheses/description/
// Easy

// Best way to solve this is using stack


== stack solution == 


// without stack solution
// time complexity: O(n^2)
// This is because in the worst case scenario,
// we may need to iterate through the string multiple times to remove all valid pairs of parentheses.
// now one thing to note here is that in the question it says, "Open brackets must be closed in the correct order."
// this implies that an input like this "({[)}]" will return false as the order of prantheses is wrong.
// which is also why every input string will contain at least one pair of parentheses together meaning that at least () or [] or {}
// will be written like this together in that input string.
// hence, in the below solution we remove the pair by pair.
class Solution {
    public boolean isValid(String s) {
        while(!s.isEmpty()){
            if(s.contains("()")) s = s.replace("()","");
            else if(s.contains("[]")) s = s.replace("[]","");
            else if(s.contains("{}")) s = s.replace("{}","");
            else return false;
        }
        
        return true;
    }
}
