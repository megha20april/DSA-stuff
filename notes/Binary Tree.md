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
- HEIGHT ---> max no. of edges from the node to the leaf nodes. (you can't go backwards when counting height) ---> The height of a tree is a height of the root.
  
  ![image](https://github.com/user-attachments/assets/e76aa1bb-3f99-4d3c-8c13-c2bb1c1f5cd9)

- DEPTH ---> no. of edges between that node and the root ---> depth of root is 0.
- LEVEL ---> if level of root is 0, then level = depth otherwise level = depth + 1
- ANCESTOR and DESCENDANT ---> An ancestor of a node is any other node on the path from the node to the root. A descendant is the inverse relationship of ancestor.
- DEGREE ---> the no. of nodes a node is pointing to. Since we're talking about binary trees, the max degree a node can have is 2.


One Node ---> two pointers ----> left and right

## Types of Binary tree

### On the basis of no. of children

### Full Binary Tree (/Proper Binary Tree)
- every node has either 0 or 2 children.
- usecase --> compression of files
  
  ![image](https://github.com/user-attachments/assets/39722a13-212d-490f-81e9-5b62c165123d)

### Degenerate or pathalogical tree
- every node has one child --> like linked list
  
 ![image](https://media.geeksforgeeks.org/wp-content/uploads/20221124105941/degeneratetree.png)

- A skewed binary tree is a pathological/degenerate tree in which the tree is either dominated by the left nodes or the right nodes. Thus, there are two types of skewed binary tree: left-skewed binary tree and right-skewed binary tree.
  
  ![image](https://media.geeksforgeeks.org/wp-content/uploads/20221130172501/skewed1.png)


### On the basis of the completion of levels

### Complete Binary Tree
- all the levels are full apart from the last level, but the last level fills from left to right.
- The last leaf element might not have a right sibling i.e. a complete binary tree doesn’t have to be a full binary tree.

    ![image](https://media.geeksforgeeks.org/wp-content/uploads/20221130172411/completedrawio.png)

### Full Binary Tree
- all the nodes either have 0 or 2 child nodes.

  ![image](https://github.com/user-attachments/assets/3c7a3fa5-5f30-4515-b76d-92d0bdac0b2c)


### Perfect Binary Tree
- All levels are full
- hence, all the leaf nodes are on the same level.
- it's a combination of full and complete.

  ![image](https://media.geeksforgeeks.org/wp-content/uploads/20221124094547/perfect.png)

### Height Balanced Binary Tree
- avg height is O(logN)
- It is a type of binary tree in which the difference between the height of the left and the right subtree for each node is either 0 or 1.

   ![image](https://www.growingwiththeweb.com/images/2015/11/14/balanced-trees.svg)

- Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search, insert and delete.
- Reason for above statement: Because in a BST, when you're searching or inserting or deleting, the system would only go over one node at a level, hence it'll always max to max traverse to logn no. of nodes as height is logn.

    ![image](https://github.com/user-attachments/assets/5ab48221-79e8-48ab-9a75-4d1308fa2265)

    ![image](https://github.com/user-attachments/assets/96196c83-f022-4590-9895-927af167ce06)


### Ordered Binary Tree
- every node has some property like in BST


## Some more Properties

- Perfect BT ---> height h ----> perfect bt has max nodes ---> 2^(h+1) - 1
  sum of gp is  Sn = a(1 - r^n) / (1 - r) where r is 2 and n is h+1(total levels)
  
![image](https://github.com/user-attachments/assets/93543180-05f2-4c78-85c6-1bab0ec0aba5)

  
- no. of nodes on level no. i ---> 2^i nodes

![image](https://github.com/user-attachments/assets/b7a18e01-7ac1-4db1-a6ca-b0c0a68915af)

- total no. of leaf nodes in perfect BT ---> 2^h (height)
- now internal nodes will be: 2^h - 1

![image](https://github.com/user-attachments/assets/5e2dde74-e03a-4703-953c-896b84ecfb4f)

- n no. of leaf nodes then
     logn + 1 levels atleast

- n no. of total nodes then
     log(n+1) min levels

- if in strict BT, n leaf nodes then
      n = 2^h ==> h = logn (height)
      internal nodes ==> 2^(logn) - 1 = n - 1

  #### Hence, No. of leaf nodes = no. of internal nodes + 1 in a strict Binary Tree

  ![image](https://github.com/user-attachments/assets/4c342874-dd22-40be-9389-b683667cfde4)


 ## Implementation

 ### Linked Representation

 #### Insertion

 - since we go back and forth with left and right of each node in tree, we'll use recursion.
 - insert{
     insert(left);
     insert(right);
   }

   ```java
    public void populate(Scanner sc){
        System.out.println("Enter the root Element: ");
        int val = sc.nextInt();
        root = new Node(val);
        // now we'll move on to the helper function which will take our node and scanner and
        // add elements further
        populate(sc, root);
    }

    private void populate(Scanner sc, Node n){
        System.out.println("Do you want to add to the left of "+ n.data + " ?");
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the left element: ");
            n.left = new Node(sc.nextInt());
            // now we'll do recursion and check for this new element's next
            populate(sc, n.left);
        }

        System.out.println("Do you want to add to the right of "+ n.data + " ?");
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the right element: ");
            n.right = new Node(sc.nextInt());
            // same for this new node as well
            populate(sc, n.right);
        }
        else return; // this line is not necessary though

    }
   ```

#### Display

```java
public void display(){
        // this is my helper function
        display(root, "");
        prettyPrint(root, 0);
    }
    private void display(Node n, String s){
        if(n == null) return;
        display(n.right, s+"\t");
        System.out.println(s + n.data);
        display(n.left, s+"\t");
    }
```
Output:
![image](https://github.com/user-attachments/assets/59359bf6-39ba-4eda-b5df-d84ff63a1e8c)

### Pretty Print

```java
private void prettyPrint(Node n, int levelIndent){
        // this level indent is used because i want to print "|  "
        // acc to the no. of levels we are in the tree

        if(n == null) return;

        prettyPrint(n.right, levelIndent + 1);

        // if we're at root we don't want any indentation
        if(levelIndent == 0) System.out.println(n.data);
        else{
            // at level l, i want l-1 indentation
            for(int i = 0; i< levelIndent - 1;i++){
                System.out.print("|\t"); // this print shouldn't add new line
            }
            // after the indentation, i can just print the data
            System.out.println("|-->"+n.data);
        }

        prettyPrint(n.left, levelIndent + 1);
    }
```

Output:
![image](https://github.com/user-attachments/assets/acdf6d14-5078-4bdd-9c8a-c1ad56cc3b8b)
