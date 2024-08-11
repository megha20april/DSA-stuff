// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
// Medium



/* =====================Problem=============================
  Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

  Integers in each row are sorted in ascending from left to right.
  Integers in each column are sorted in ascending from top to bottom.
*/

// time complexity: O(n + m) time and O(1) space. 


//Solution
//Our goal is to locate a number in a semi-sorted matrix, so binary should come to mind. The goal of binary is to try to find a pivot point and discard some of the possibilities by making one of two choices. What do we know about the matrix? Numbers are always increasing left to right and top to bottom. This means the top left corner is the smallest, and the bottom right is the biggest, these wouldn't make for good starting pivots! However the top right and bottom left could, as they are bigger than some elements, but not necessarily all elements. For instance the bottom left is bigger than everything below it, but smaller than everything to the right. We just need to know this small part to get started, we don't need to necessarily bisect the whole matrix, as that isn't possible. We compare the cell, and move up or right depending on how it compares to our target, until we either go out of bounds, or find the target. We can't just use the center as the pivot point to begin with, because then we might have two choices for bigger numbers (down or right), for example. We wouldn't know which way to go. Whereas if we start from the bottom left, and move right, we are safe to prune all the numbers to the left.

// * other worse solutions would be n log m (do a binary search for each row), or log n! which is do two binary searches for every element in the diagonal, for example in a 3x4 we can do: log3+log2+log1 + log4+log3+log2, which in time complexity would reduce to log4! upper bound, where 4 is the longest diagonal, but I think technically it is faster than the n log m solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0]) return false;
        if(target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(col >= 0 && row < matrix.length){
            if(target == matrix[row][col]) return true;
            else if(target > matrix[row][col]) row++;
            else col--;
        }
        return false;
    }
}
