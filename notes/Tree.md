trees are similar to linked list based on structure

### Why do we use trees?
- most operations can be done in O(logN) time complexity which is more efficient than linked list.
- nodes are stored in such a order that it makes operations easier to perform
- cost efficient as it doesn't need to restructure itself when a lot of data is added

![image](https://github.com/user-attachments/assets/a0d24f5a-975e-40ca-ae00-774cdddc1a5f)

in this case all the operations do become same as linked list, this is called an unbalanced binary tree.

## Some of the trees usecases:
- file system, ml decision trees, networking algos, file compression, other data structures like graph and heap etc...

## Properties
- SIZE ---> Total no. of nodes
- CHILD and PARENT relationship
- SIBLING ---> if they have the same parent
- EDGE ---> line connecting two nodes
- LEAF NODES ---> no children
- HEIGHT ---> max no. of edges from the node to the leaf nodes. (you can't go backwards when counting height)
- LEVEL ---> height of root - height of that node ---> level of root is 0.
- ANCESTOR and DESCENDANT ---> An ancestor of a node is any other node on the path from the node to the root. A descendant is the inverse relationship of ancestor.

One Node ---> two pointers ----> left and right

## Types of Binary tree

### Complete Binary Tree
- all the levels are full apart from the last level, but the last left fills from left to right.

### Full Binary Tree
- every node has either 0 or 2 children.
- usecase --> compression of files

### Perfect Binary Tree
- All levels are full
- hence, all the leaf nodes are full in the last level.
- it's a combination of full and complete.

### Height Balanced Binary Tree
- avg height is O(logN)

### Skewed Binary Tree
- every node has one child --> like linked list

### Ordered Binary Tree
- every node has some property like in BST


## Some more Properties

- Perfect BT ---> height h ----> perfect bt has max nodes ---> 2^(h+1) - 1
  sum of gp is  Sn = a(1 - r^n) / (1 - r) where r is 2 and n is h+1(total levels)
  
![image](https://github.com/user-attachments/assets/93543180-05f2-4c78-85c6-1bab0ec0aba5)

  
- no. of nodes on level no. i ---> 2^i nodes

![image](https://github.com/user-attachments/assets/b7a18e01-7ac1-4db1-a6ca-b0c0a68915af)

- total no. of leaf nodes in perfect BT ---> 2^h (height)
- now internal nodes will be:

![image](https://github.com/user-attachments/assets/5e2dde74-e03a-4703-953c-896b84ecfb4f)
