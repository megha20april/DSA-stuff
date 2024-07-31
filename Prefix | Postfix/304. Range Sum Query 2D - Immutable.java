// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
// Medium



// the time complexity of the constructor is O(n*m) and the space complexity is O(n*m)

// one way to solve this would be to do prefix sum on each row or column independently, 
// and in sumRegion method iterate through each row from upper bound to lower bound to get the answer

//But a better way would be (also we need sumRegion method to be of O(1) time complexity) to decide which prefix sum array will be best suited here
// like should i do sum through each row or column independtly or row-wise in a fashion in which it's kinda spread out (like 1D array)
// or should you do it diagonally or matrix wise 


class NumMatrix {

    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        sumMatrix[0][0] = matrix[0][0];

        // instead of this the best way would be to make sumMatrix = new int[matrix.length + 1][matrix[0].length + 1]
        // this will initialize all the elments to 0
        // so that i wouldn't have to worry about the case when i'm on row 0 or coulmn 0
        for (int i = 1; i<matrix.length; i++){
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j<matrix[0].length; j++){
            sumMatrix[0][j] = sumMatrix[0][j - 1] + matrix[0][j];
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(col1 == 0 && row1 == 0) return sumMatrix[row2][col2];
        else if(col1 == 0) return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2];
        else if(row1 == 0) return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1];
        int sum = sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1] - sumMatrix[row1 - 1][col2] + sumMatrix[row1 - 1][col1 - 1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
