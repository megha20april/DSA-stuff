// https://leetcode.com/problems/add-two-numbers/description/
// Medium

// Time and Space : O(Max(N,M)) where N and M are lengths of both linked lists respectively


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode dumHead = dummy;

      // first we check if any of the two given numbers are 0
        if(l1.val == 0 && l1.next == null){
            if(l2.val == 0) return dummy;       // if both are 0 then return 0 (dummy.val is 0)
            return l2;         // if only l1 is 0 then return l2
        }else if(l2.val == 0 && l2.next == null) return l1;

        
        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
          
            if(sum > 9){
                carry = sum/10;
                sum %= 10;
            }else carry = 0;
          // instead of this i could've just simply done:
            /*  carry = sum/10;      if sum is of one digit this will simply put carry to 0
                 sum %=10;           and sum to sum itself
            */

            dummy.next = new ListNode(sum);

            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }


      // what if l1's length > l2's length
        while(l1 != null){
            int sum = l1.val + carry;
            if(sum > 9){
                carry = sum/10;
                sum %= 10;
            }else carry = 0;

            dummy.next = new ListNode(sum);

            dummy = dummy.next;
            l1 = l1.next;
        }

      // what if l2's length > l1's length
         while(l2 != null){
            int sum = l2.val + carry;
            if(sum > 9){
                carry = sum/10;
                sum %= 10;
            }else carry = 0;

            dummy.next = new ListNode(sum);

            dummy = dummy.next;
            l2 = l2.next;
        }

      // what if after traversing through both given numbers there is
      // still some carry left from the last operation
        if(carry != 0){
            dummy.next = new ListNode(carry);
        }
        
        return dumHead.next;
    }
}

=============!!!IMPORTANT NOTE!!!=================
  /*
  instead of making these three loops i could've done this in a single loop

  while (l1 != null || l2 != null || carry != 0) {
            // here i'll make checks to avoid the nullPointerException
            // like if l1 is null then -> null or 0(based on requirement), otherwise l1.val or l1.next
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum %= 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
    }
  */
