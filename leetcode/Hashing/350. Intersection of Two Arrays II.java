// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// Easy

// Time complexity: O(n+m) and space complexity: O(n)
// if done with sorting the time complexity will be O(nlogn + mlogm) but constant space complexity

// here we have to retain the duplicacy of common elements hence we'll use hashmaps otherwise we could've just used hashset.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

      // put all the elements of the first array into the map with no. of times they appear.
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1); 
        }
      
        ArrayList<Integer> al = new ArrayList<>();

      // now here we'll add the common elements, of the second array and the above map, into the arraylist.
      // and then remove them from the map as well.
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                al.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int n=al.size(); //fetching list size
        int[] arr1 = new int[n]; // making a new array
        int i = 0;
        for(int num : al){ // converting list to array
            arr1[i++] = num;
        }
        return arr1;
    }
}

//======================FOLLOW UPS===========================

// 1st follow up:
     in case of already sorted arrays, we can use the two pointers algorithm which will save us space complexity.

// 2nd follow up:
    use the smaller array for the frequency map to save space complexity.

         
