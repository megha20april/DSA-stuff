// https://leetcode.com/problems/lru-cache/description/
// Medium

// O(1) time complexity

// your first thought could be to do this with map, BUT it doesn't have any order and you have to track the least used node, so we can't use that
// my second thought was what if i make an array that maintains the order for me BUT in remove and add operations, time complexity will increase
// so in these kind of questions, we use a combination of doubly linked list and map (mapping: key --> corresponding Node)
// Why Doubly linked list? because we can maintain order and easily remove and add from start and end of list
// Why MAP? to search an element we'll still have to traverse through the list
// hence, we can use map for that BUT we could've also done a simple mapping of key --> value
// BUT we can't do that because in order to maintain the order of keys being used
// we'll remove the last used node from the list and then add it to the last position of the linked list
// for that we'll have to get that node, without traversing through it
// hence we map from key --> Node

class LRUCache {
    int capacity;
    class Node{ // simple node class
        Integer key;
        Integer val;
        Node next;
        Node prev;
        Node(Integer key, Integer val){
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map; // mapping

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    private void removeHead(){ 
    // if the node is head, then we use this
        head = head.next;
        head.prev = null;
    }

    private void removeInBetween(Node n){
      // if node is in the middle of the list
        Node pre = n.prev;
        Node nex = n.next;
        pre.next = nex;
        nex.prev = pre;
    }
    public int get(Integer key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            
            if(n == tail) return n.val; 
            // if the node is tail then we don't have to remove and add anything
            else if(n == head) removeHead();
            else removeInBetween(n);

          // at last we add it to tail
            tail.next = n;
            n.prev = tail;
            tail = n;
          
            return n.val;
        }
        return -1;
    }

    public void put(Integer key, int value) {
        if(head == null){ // when there's nothing
            head = new Node(key, value);
            tail = head;
            map.put(key, tail);
            capacity--;
        }
        else if(map.containsKey(key)){
          // here we'll update the value
            Node n = map.get(key);
            n.val = value; // updated the value
            if(n == tail) return; // if it's tail then we don't need to remove or add anything
            else if(n == head) removeHead();
            else removeInBetween(n);

            // then we add it to tail
            tail.next = n;
            n.prev = tail;
            tail = n;
            
        }
        else if(capacity > 0){
            Node newNode = new Node(key, value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            map.put(key, tail);
            capacity--; // decrement the capacity
        }
        else{ //when capacity is full, we have to remove the least used node
            map.remove(head.key);
          // check if only one there is only one node
            if(head == tail){
                head = null;
                tail = null;
                head = new Node(key, value);
                tail = head;
            }else{
                head = head.next; // remove the head
                head.prev = null;
                Node newNode = new Node(key, value);
                tail.next = newNode; // add it to tail
                newNode.prev = tail;
                tail = newNode;
            }
            // at last add that key to map as well
            map.put(key, tail);
        }
    }
}
