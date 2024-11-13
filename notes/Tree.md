trees are similar to linked list based on structure

### Why do we use trees?
- most operations can be done in O(logN) time complexity which is more efficient than linked list.
- nodes are stored in such a order that it makes operations easier to perform
- cost efficient as it doesn't need to restructure itself when a lot of data is added

![image](https://github.com/user-attachments/assets/a0d24f5a-975e-40ca-ae00-774cdddc1a5f)

in this case all the operations do become same as linked list, this is called an unbalanced binary tree.

### Some of the trees usecases:
- file system, ml decision trees, networking algos, file compression, other data structures like graph and heap etc...

### Properties
- SIZE ---> Total no. of nodes
- CHILD and PARENT relationship
- SIBLING ---> if they have the same parent
- EDGE ---> line connecting two nodes
- LEAF NODES ---> no children
- HEIGHT ---> max no. of edges from the node to the leaf nodes. (you can't go backwards when counting height)
- LEVEL ---> height of root - height of that node ---> level of root is 0.
- ANCESTOR and DESCENDANT ---> An ancestor of a node is any other node on the path from the node to the root. A descendant is the inverse relationship of ancestor.

### Types of Binary tree

#### Complete Binary Tree - all the levels are full apart from the last level, but the last left fills from left to right.
- 

One Node ---> two pointers ----> left and right
