// https://leetcode.com/problems/palindrome-linked-list/description/
// Easy

// CAN BE DONE WITH RECURSION, though i don't know how


// at first as i only had linked list in my head i only tried to use linked list 
// which has O(n) time complexity
// and O(1) space complexity

// what i thought was since i can't reach the last element without looping through the whole thing again and again 
// so what if i create another reversed linked list then i can just run a loop to compare it 
// but i don't need the reverse the whole thing, i can reverse only the second half of the list


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        
        //One thing to be noted is that:
        // even if i reverse the second half, it wouldn't detach itself from the first half
        // as the last node of first half would still be refering to the last element of the reversed second half
        // to imagine this, it would sorta become like an arrow shape.

        // honestly i didn't really need to do this
        // i could've just done rev(slow) and then 
        // run the last loop until any one of temp or og become null
        ListNode l2 = fast != null? rev(slow.next) : rev(slow); // i had to remove this from an if else block beacuse it was creating scope issues like l2 is not defined outside.
        

        ListNode temp = l2;
        ListNode og = head;
        while(temp != null){
            if(temp.val != og.val) return false;
            temp = temp.next;
            og = og.next;
        }
        return true;
    }
    ListNode rev(ListNode head){
        ListNode prev = null, cur = head, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}


// A much much simpler way is to just convert the linked-list to an arraylist 
// because then you can point to the last element as well and traverse backwards easily

// time and space O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int left = 0;
        int right = list.size()-1;
        while(left < right) {
            if(list.get(left) != list.get(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

// one other way to do ths was using stack
// i can push all the list elements to stack
// then pop them one by one and check
//time and space is linear

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr != null && curr.val == stack.pop()) {
            curr = curr.next;
        }
        return curr == null;
    }
}

//one last way is to do this with recursion, for that look for the solution
