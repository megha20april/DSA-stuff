- Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search, insert and delete.
- Reason for above statement: Because in a BST, when you're searching or inserting or deleting, the system would only go over one node at a level, hence it'll always max to max traverse to logn no. of nodes as height is logn

  ![image](https://github.com/user-attachments/assets/ecb34b0b-cd1e-4f0d-a429-92ef2982fdac)
  ![image](https://github.com/user-attachments/assets/10af6483-aeef-4724-a49e-391c11bfe6be)

 
Problem of BST =====>> Skewed BST
  ![image](https://github.com/user-attachments/assets/946d4367-b2bf-480a-9b3e-17776481b972)

For function implementations for BST (like insert, populate, populate sorted, balanced),
Refer Intellij code

## Traversal Methods

### 1. Pre-order
- Node -> Left -> Right
- Used for evaluating math expressions
- or making a copy
- in conversion of string or array to tree, which is called Serialization

```java

private void preOrder(Node n){
  if(n == null) return;
  System.out.println(n.val);
  preOrder(n.left);
  preOrder(n.right);
}

```

  
### 2. In-order
- Left -> Node -> Right
- Used for **visiting nodes of a BST in a sorted manner**

![image](https://github.com/user-attachments/assets/77672fe5-17cb-4717-9297-96f2c7c46ac5)

```java

private void inOrder(Node n){
  if(n == null) return;
  inOrder(n.left);
  System.out.println(n.val);
  inOrder(n.right);
}

```
### 3. Post-order
- Left -> Right -> Node
- used when you wanna delete binary tree
- used in bottom-up calculations like calc diameter or height etc.

```java

private void postOrder(Node n){
  if(n == null) return;
  postOrder(n.left);
  postOrder(n.right);
  System.out.println(n.val);
}

```
