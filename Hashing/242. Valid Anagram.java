// https://leetcode.com/problems/valid-anagram/description/
// Easy


//one way to solve could be sort the strings by converting them first to char array then sorting them then converting back to string
// other way could be to make a count array of size 26 for string s then for string t do decrement in the same count array then check if any value is negative
// that will be to avoid making two count arrays


// My naive approach:
// i made two separate hashmaps for each string and just compared them
//time and space complexity O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(createMap(s).equals(createMap(t))) return true;
        return false;
    }
    HashMap<Character, Integer> createMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<str.length(); i++){
            Character ch = str.charAt(i);
          // instead of this comparison i should've used the method getOrDefault(key, defaultValue)
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else map.put(ch, 1);
        }
        return map;
    }

}

// better solution but with same time and space complexity
// here instead of making two different maps we only updated one map
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}
