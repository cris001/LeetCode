题目描述

Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as1and0respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is2.
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*if (obstacleGrid == null || obstacleGrid.length == 0){
            return 1;
        }*/
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int f[][] = new int [row+1][col+1];
        if (obstacleGrid[0][0] == 0){
            f[0][0] = 1;
        }else{
            f[0][0] = 0;
        }
        for(int i=1;i<col;i++){
            if (obstacleGrid[0][i] == 1){
                f[0][i] = 0;
                continue;
            }
            f[0][i] = f[0][i-1];
        }
        for(int i=1;i<row;i++){
            if (obstacleGrid[i][0] == 1){
                f[i][0] = 0;
                continue;
            }
            f[i][0] = f[i-1][0];
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if (obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                    continue;
                }
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[row-1][col-1];
    }
}