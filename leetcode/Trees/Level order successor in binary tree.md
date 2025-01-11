##  Level order successor in binary tree
The question is to find the level order successor of the given value in the given tree

![image](https://github.com/user-attachments/assets/2683a7b9-de70-4e95-bb61-d84c44865c4f)

in this one we'll obviously apply BFS and thus, queue.

```java

public TreeNode LevelSuccessor(TreeNode root, int key){
  if (root == null) return null;

  Queue<Integer> q = new LinkedList<>();
  q.offer(root);

  while(!q.isEmpty()){
    // in this question i don't need to keep track of levels
    // i just need the successor of the given key
    // hence i don't need the for loop

    TreeNode temp = q.poll();
    if(temp.left != null) q.offer(temp.left);
    if(temp.right != null) q.offer(temp.right);

    // i did the check after adding left and right nodes
    // because what if there's nothing next to the queried value like when the input is the root node
    // hence we'll first add it's left and right nodes

    if(temp.val == key) break;
    
  }

  return q.peek();
}

```
