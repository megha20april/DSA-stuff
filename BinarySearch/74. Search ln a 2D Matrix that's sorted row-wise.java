// https://leetcode.com/problems/search-a-2d-matrix/
// Medium

/*
====================================Problem====================================
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/




//1st and better solution
// time complexity: O(logmn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1) return BS(matrix, target, 0); // if it only has one row then no need to get correct row
        int row = searchInLastCol(matrix, target);
        return BS(matrix, target, row);
    }
	// i first searched in last column of the matrix so that i can eliminate rows all together, 
	// and lastly end up with a single row which should have my answer
    int searchInLastCol(int[][] matrix, int target){
        int srow = 0;
        int erow = matrix.length - 1;
        int lastcol = matrix[0].length - 1;
        int mrow = srow + (erow - srow)/2; // errors if you don't initialize and return after loop; (which i haven't here) 
        while(srow < erow){
            mrow = srow + (erow - srow)/2;
            else if(target <= matrix[mrow][lastcol]) erow = mrow;
            else srow = mrow + 1;
        }
        return srow; // here start and end will become equal
    }

	// then i applied bs to that single row
    boolean BS(int[][] matrix, int target, int row){
        int scol = 0, ecol = matrix[0].length - 1, mcol;
        while(scol <= ecol){
            mcol = scol + (ecol - scol)/2;
            if(target == matrix[row][mcol]) return true;
            else if(target < matrix[row][mcol]) ecol = mcol - 1;
            else scol = mcol + 1;
        }
        return false;
    }
}



//2nd solution which i first got (it's an overhead)
// time complexity: O(logmn)
static int[] BS(int[][] arr, int target) {
	// i found the equivalent index of each element if it were in a 1D array 
        int si = 0, sj = 0; //start row(i), start collumn(j)
        int ei = arr.length - 1, ej = arr[0].length - 1;// end i, endj
        int ns = ((si + 1) * (arr[0].length)) - (arr[0].length - 1 - sj); //did some math to get equivalent index
        int ne = ((ei + 1) * (arr[0].length)) - (arr[0].length - 1 - ej);
        int nm, mid;
        while (ns <= ne) {
            nm = ns + (ne - ns) / 2; //found euivalent index of mid also 
            mid = arr[nm/arr.length][nm%(arr[0].length - 1)]; // then converted it back to 2D
            if (mid == target) return new int[]{nm/arr.length, nm%(arr[0].length - 1)};
            else if (target > mid) ns = nm + 1;
            else ne = nm - 1;
        }
        return new int[] {-1, -1};
    }
