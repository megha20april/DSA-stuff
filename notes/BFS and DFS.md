<ins> BFS - Bredth first search </ins>
- level order traversal

  ![image](https://github.com/user-attachments/assets/49b2c6a2-7af8-48fc-bd71-77d9f89122cf)

when to use this?
- when answer lies near the root node.
- when you're asked to search by level.


> Use queue for implementation
> - as it follows FIFO
> - at each node print its value and then add it's left and right node into the queue.

The time complexity for this is O(n) since it traverses through each node once.
The space complexity for this will also be O(n) because in the worst case it'll store all the leaf nodes of a perfect binary tree which will be equal to (n+1)/2 which rounds up to be n.
