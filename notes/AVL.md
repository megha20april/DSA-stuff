Problem of BST are skewed trees (which is pretty much same as a linked list, hence, it doesn't utilize trees data structure's benefits) which is solved by AVL trees.

# AVL TREES (One of the example of Balancing trees)
Adelson-Velskii and Landis

For every Node, | height(left subtree) - height(right subtree) | <= 1 or we can say it can be -1, 0 or 1 (as sometimes you can get -2 value which means one side is heavier, and needs to be rotated in the opposite side to become balanced.

![image](https://github.com/user-attachments/assets/1d65fea2-4550-4445-9d11-2a7fb77b2b19)

<ins>Algoritm to make a tree balance itself</ins>

- first add the node n normally
- then identify the node which is making the tree unbalanced
- then identify all the subtrees attached to it
- mark them
- parent is the node which is making the tree unbalanced
- then there are child nodes connected to it
- and the grandchild node is the node at which you connected your inital node n which made the whole tree unbalanced.

![image](https://github.com/user-attachments/assets/f90b0a0e-d453-4cac-975a-0700c6a4a61c)
in the above image, the node marked with 'yes' is unbalanced and the circled area is the subtree attached to it

- then either rotate the identifed node to the left or right according to 4 rules:
- your motivation should be to first bring grandchild node, the child node and the parent node in the same line (by right or left rotate) then either do right or left rotate again accordingly to balance the tree.
- and by all this rotating, i made the particular subtree balanced which will not affect the already balanced rest of the tree.
  

![image](https://github.com/user-attachments/assets/f0bd626c-1f54-40fa-bbeb-b013455210a4)

![image](https://github.com/user-attachments/assets/5300d2bd-1365-48c5-aa96-11289583306a)

![image](https://github.com/user-attachments/assets/53f16a3b-a1a1-430e-9c13-d4165c28917e)

![image](https://github.com/user-attachments/assets/98dc3322-8725-48cd-a5b9-295575fde3ad)

![image](https://github.com/user-attachments/assets/85c31926-8692-4569-8f0a-113b510365de)

Example:
![image](https://github.com/user-attachments/assets/a9d51b75-c06a-43d1-9e58-37cf51702d81)

