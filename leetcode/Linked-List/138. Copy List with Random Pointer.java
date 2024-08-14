// https://leetcode.com/problems/copy-list-with-random-pointer/
// Medium


/*
Time complexity : O(n ^ 2)     Space complexity: O(n)

i made a new linked list any in a normal while loop copied all the values from the given linked list
now to get the random pointer node we NEED a unique identifier for it first:
Node'val can be duplicate so obv we can't use it
Node's next pointer also contains a reference which you can't compare here because we are making a new linked list
like what am i going to do with the reference of that random node, i can't compare it with any Node of my new linked list.

So that's why index of a node is the only unique identifier of that random node that i can use
*/
class LL{
    public Node headLL;
    public Node tailLL;

    public void addLast(int val){
        if(headLL == null){
            headLL = new Node(val);
            tailLL = headLL;
            return;
        }
        Node newNode = new Node(val);
        tailLL.next = newNode;
        tailLL = newNode;
    }    
}

class Solution {
    public Node copyRandomList(Node head) {
        LL newLL = new LL();
        Node temp = head;
        while(temp != null){
            newLL.addLast(temp.val);
            temp = temp.next;
        }

        temp = head; // original list head
        Node tempN = newLL.headLL; // new list head
        while(temp != null && tempN != null){
            if(temp.random != null){

              //first get the index of that random node in the original list
              int i = searchIndexInOrg(head, temp.random);

              // then get the node on that index in our new linked list
              tempN.random = returnIndexNodeFromNew(newLL.headLL, i);
            }
            tempN = tempN.next;
            temp = temp.next;
        }
        return newLL.headLL;
    }
    public int searchIndexInOrg(Node head, Node random){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp == random) return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public Node returnIndexNodeFromNew(Node headLL, int i){
        Node temp = headLL;
        while(i > 0){
            temp = temp.next;
            i--;
        }
        return temp;
    }
}

//==========Solution=2==============

// Both time and space complexity: O(n)

/*
to reduce the time complexity of the above solution from O(n^2)

we can optimise the part where we're travesing again and again in the new and old linked list to get the index of random node and stuff

by just using maps. Smort...right?XD

when we were creating our new linked list what if i make two maps
in map1, i'll store each original list's node's index
in map2, i'll store each node on index        //i can actually just make an arraylist as well here yk, that'll be easier
          because i want to find the node on the index, index that i'll get from the original list's random node
          basically i want to get node through my index

since we'll use maps, 
the get operations will have constant complexities, hence reducing our overall time complexity
*/


class LL{
    public Node headLL;
    public Node tailLL;


  // i'll now return the node that i added, to be able to store it in map2
    public Node addLast(int val){
        if(headLL == null){
            headLL = new Node(val);
            tailLL = headLL;
            return tailLL;
        }
        Node newNode = new Node(val);
        tailLL.next = newNode;
        tailLL = newNode;
        return tailLL;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        LL newLL = new LL();

        HashMap<Node, Integer> map1 = new HashMap<>();
        HashMap<Integer, Node> map2 = new HashMap<>();

        Node temp = head;
        Integer index = 0;
        while(temp != null){
            Node newN = newLL.addLast(temp.val);

            map1.put(temp, index);
            map2.put(index, newN);

            temp = temp.next;
            index++;
        }

        temp = head;
        Node tempN = newLL.headLL;
        while(temp != null && tempN != null){
            if(temp.random != null){
              int i = map1.get(temp.random); // constant time
              tempN.random = map2.get(i); // constant time
            }
            tempN = tempN.next;
            temp = temp.next;
        }
        return newLL.headLL;
    }
    
}

//================Solution 3===============
//time and space are linear

class Solution {
    public Node copyRandomList(Node head) {
       // we'll point from our original list's node to new node's
        // so that we can the new corresponding nodes easily
        // this way i won't have to do the index thing
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while(temp != null){
            // put a new node corresponding to each node of original list
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
           // this becomes so each now because we have mapped every node to it's corresponding one in the new list
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);

            temp = temp.next;
        }
        return map.get(head);
    }
    
}
