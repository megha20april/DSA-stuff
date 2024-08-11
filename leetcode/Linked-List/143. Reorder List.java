// https://leetcode.com/problems/reorder-list/
// Medium

// CAN BE DONE WITH RECURSION, though i don't know how

// Time complexity : O(n) and constant space complexity
class Solution {
    public void reorderList(ListNode head) {
      // this line is so essential !!!
        if (head == null && head.next == null && head.next.next == null) return;

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rev = rev(slow);

            ListNode dummy = new ListNode();
            ListNode dumHead = dummy;

            // i found this boolean value such a clever idea to switch between the two halfs
            boolean incOrgList = true;
      //though it is clever i didn't need to do this 
      // because within the same iteration i can add an item of og list and an item of rev list
      // and in this process, the dummy pointer will just have to be moved twice

            while (rev != null && head != null) { // at first i was getting so hella confused with these conditions
                if (incOrgList) {
                    dummy.next = head;
                    head = head.next;
                    incOrgList = false;
                } else {
                    dummy.next = rev;
                    rev = rev.next;
                    incOrgList = true;
                }
                dummy = dummy.next; // this is the common part so i took it out here
            }


          // i can't return anything here so i'll have to make changes to the original list
            head = dumHead.next; // we don't want to include the first empty node
        
    }

    ListNode rev(ListNode node) {
        ListNode prev = null, cur = node, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

// Honestly the easiest way would be to convert the linked list to array list and then i can make a new array using two pointers
// and then convert it back to linked list
