// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/
// Medium

//Time O(mn)
//Space O(mn)



//OOooh this took me forever to do!
// so first i was foolishly trying to just make one sum matrix by assigning for ex 1 to X and 2 to Y, but the problem was
// there were too many conditions and no matter how hard you try to make a pattern there's definetly going to be a combination of numbers
// that is going to break the pattern. so making a pattern in that way is just not possible :(

// hence we made separate matrix for X and Y, then compared there values and that's it!
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        return count(grid);
    }
    int count(char[][] grid){
        int[][] X = new int[grid.length + 1][grid[0].length + 1];
        int[][] Y = new int[grid.length + 1][grid[0].length + 1];

        int count = 0;
        
        for(int i = 1; i < X.length; i++){
            
            for(int j = 1; j < X[0].length; j++){
                
                X[i][j] = X[i][j - 1] + X[i - 1][j] - X[i - 1][j - 1] + (grid[i - 1][j - 1] == 'X'? 1 : 0);

                Y[i][j] = Y[i][j - 1] + Y[i - 1][j] - Y[i - 1][j - 1] + (grid[i - 1][j - 1] == 'Y'? 1 : 0);

                if(X[i][j] == Y[i][j] && X[i][j] != 0) count ++; //we need atleast one X so it shouldn't be zero
            }
        }
        return count;
    }
    
}
