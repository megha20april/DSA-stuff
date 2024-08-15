// https://leetcode.com/problems/find-the-duplicate-number/description/
// Medium

// Constraints:
// can't modify array: so can't sort it or anything
// constant space complexity: so can't use hashmaps or hashsets

/* Identifying linked list cycle:
    Think of this array: [1, 3, 4, 2, 2]
    since all the values are in the range [1, n] and we have n+1 array length
    this means i'll have index from 0 to n
                    and values from 1 to n
    which means if i take each index as a node as in 0node, 1node ...... nnode,
    and the value at each index as their next pointer, then 0node will point to 1node(since 0 has value 1)

    and no value will ever point to 0 index, because 0 value is not possible meaning no index node will have 0 next pointer

    this means if there were to be a cycle, it would never begin on 0 index, it'll only begin after 0 index node

    so in our example, cycle could be like
        0node --> 1node --> 3node --> 2node --> 4node
                                         ^________|      
*/

/* Floyd's Algo:
    now we just need to get the start of the cycle
    we take two pointer fast and slow
    since there's a cycle, there will always be a node where fast and slow coincide inside the cycle
    but the node where they coincide could be anywhere in the cycle 
    so now to get only the start of the cycle, (this happens in another loop)
        *Once we know for sure that a loop is present.
        *Move the slowPointer to the start of the list,(i.e headNode) and let fastPointer remain there at the meeting point.
        *Now move both the pointers one node at a time(Yes! You heard it right. Now even fastPointer moves at one node at a time).
        *The point where both pointers will meet is our required start of the loop.(says floyd's algo)

        How?
        now the time comes to prove what floyd's algo says:
            let the dist of the node at which fast and slow coincide from the start node of cycle be y
            let the dist of the whole cycle be C
            let the dist from start of linked list(0node) to start of cycle(2node) be x

            Distance travelled by slowPointer before meeting= x + c - y

            Distance travelled by fastPointer before meeting = (x + c) + c - y 
                                                             = x + 2c - y
            Since fastPointer travels with double the speed of slowPointer
            2 * slow's dist = fast's dist
               2(x+c-y)= x+2c-y

            => x=y

            So by moving slowPointer to the start of the linked list, 
            and making both slowPointer and fastPointer move one node at a time, 
            they both will reach the point where the loop starts in the linked list.

*/
 
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0; //0node (remember index is our node)
        int fast = 0; //0node
        do{ // we're using do-while because initially they'll be equal and 0 is anyway not our answer
            slow = nums[slow]; // index's value is next node
            fast = nums[nums[fast]]; // next's next
        }while(slow != fast);
        
        slow = 0; // again index 0node
        do{// we can use do-while here because i know that 0 is not included in the cycle otherwise use while
            slow = nums[slow];
            fast = nums[fast];
        }while(slow != fast);

        return slow;
    }
}