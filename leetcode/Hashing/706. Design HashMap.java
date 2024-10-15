// https://leetcode.com/problems/design-hashmap/submissions/

// Time complexity: O(n) for put, get and remove

// we'll make a linked list node on each element of the hashmap array to handle collisions.
class Node{
    int key;
    int val;
    Node next;
    Node(int key, int val, Node next){
     this.key=key;
     this.val=val;
     this.next=next;
    }
}
class MyHashMap {
    int size = 13337; // this is a prime no. generally, prime no.'s are preferred for size to minimize collisions.
                      // in the question the no. of operations is given as 10^4 these could all be put as well, hence we can think of
                      // this as the size...right 
                      // load factor = no. of elements / size and usually 0.7 or 0.75 lf is preferred. hence, i did 10000/0.75 to get the size
                      // which was 13333 but it's not prime so i chose 13337 as it is prime.
    Node[] data;

    public MyHashMap() {
        data = new Node[size];
    }
    
    public int hash(int k){
        return k%size; // a simple hash function
    }
    
    public void put(int key, int value) {
        int h = hash(key);
        remove(key); // here we first remove it, if this key existed already, to update it
        Node n = new Node(key, value, data[h]);
        data[h]=n;
    }
    
    public int get(int key) {
        int h = hash(key);
        Node temp = data[h];
        for(;temp!=null;temp=temp.next){
            if(temp.key == key) return temp.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        Node temp = data[h];
        if(temp==null) return;
        else if(temp.key == key) data[h]=temp.next;
        else for(;temp.next!=null;temp=temp.next){
            
            if(temp.next.key == key){
                temp.next=temp.next.next;
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
