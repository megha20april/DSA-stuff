// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Medium

// Solution 2:
// although same complexities, it's a bit clever
// we can use two pointers for that
// the two pointers have n distance (achieved by moving the second pointer to n steps ahead) b/w them,
// then we traverse through the list until the second(ahead one) pointer becomes null
// and then remove the element after the first pointer

// time complexity : linear and constant space complexity
// pretty basic solution
// first we count the length then reach the node right before the one that's to be removed
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        count -= n;

        // this is the main shit aka the edge case
       // that i first ignored 
      // that what if the head is the one that needs to be removed
        if(count == 0) return head.next;

        temp = head;
        while(count > 1){
            count--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
