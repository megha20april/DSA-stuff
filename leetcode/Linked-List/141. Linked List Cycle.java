// https://leetcode.com/problems/linked-list-cycle/description/
// Easy

// Time and space both linear
// it's not a very good solution but honestly i find it very cool, 
// since we're storing references of each node in arraylist
// and then nextly checking if the next node is already present in the arraylist
// that would tell us we've already traversed through it once
public class Solution {
    public boolean hasCycle(ListNode head) {
        ArrayList<String> ls = new ArrayList<>();
        // instead of references, i could've just added the nodes itself to the arraylist
        // that would've also done the job
        
        ListNode temp = head;
        while(temp != null){
            ls.add(temp.toString());
            if(temp.next != null && ls.contains(temp.next.toString())) return true;
            temp = temp.next;
        }

        return false;
    }
}

//=============Solution 2=============

// time complexity is O(n)
// This is because in the worst case scenario, the fast pointer will traverse the entire linked list once before detecting a cycle.

// Constant space complexity

// this is my second and better approach
// basically i here, tried to see if i could forcefully do something with two pointers
// since i've seen it getting used so much in linked list ques
// here i basically returned true when slow == fast
// if there is a cycle, the fast pointer will eventually catch up to the slow pointer. 
// If there is no cycle, the fast pointer will reach the end of the list.

// but there's one problem with this, i.e. initially with slow == fast == head
// it would always return true
// so i had to first move them forward and then check
public class Solution {
    public boolean hasCycle(ListNode head) {
        

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
