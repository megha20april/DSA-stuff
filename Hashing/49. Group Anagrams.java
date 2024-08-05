// https://leetcode.com/problems/group-anagrams/submissions/1344826340/
// Medium

// so one way to solve this could be if i sort each string of my array and then make a map which maps the sorted string to all it's anagrams
// String --map-to-->> list of strings
// and then i can just return all the values of our map


// The time complexity of this solution is O(n * m * log m), 
// where n is the number of strings in the input array and m is the average length of each string. 
class Solution{
  public List<List<String>> groupAnagrams(String[] strs) {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String newString = new String(ch);
            map.putIfAbsent(newString, new ArrayList<>());
            map.get(newString).add(strs[i]);

        }
        List<List<String>> ls = new ArrayList<>(map.values()); 
    // map values returns a collection view of values so to match the return type we have to convert it
        return ls;
  }
}


// conversion to a string using Arrays.toString(count), can be relatively slow compared to simple string operations.
// Each conversion involves creating a new string representation of the array, which can add significant overhead.

// ==============other perspectives=====================
// 2nd
// you could've also made the mapping of
// Sorted char array --map-to----> List of Strings
// But in this way when you'll use map.put() then you'll have to convert array to string otherwise it'll store it's reference here
// so essentially it'll be the same as before but a little slower because of Arrays.toString()
// String --map-to-->> list of strings


// 3rd
// or you could've made a count array of size 26 which will contain count of each character in each string
// then map this array with list of string having same count array
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String i : strs){
            int[] count = new int[26];
            for(int j = 0; j<i.length(); j++){
                count[i.charAt(j)-'a']++;
            }
            map.putIfAbsent(Arrays.toString(count), new ArrayList<>());
            map.get(Arrays.toString(count)).add(i);
        }
        List<List<String>> ls = new ArrayList<>(map.values());
        return ls;
    }
}

//time complexity O(m n)

