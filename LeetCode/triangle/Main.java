题目描述
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
import java.util.*;
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0){
            return 0;
        }
        for(int i = len - 2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                int x = triangle.get(i+1).get(j);
                int y = triangle.get(i+1).get(j+1);
                int k = triangle.get(i).get(j);
                triangle.get(i).set(j, k + Math.min(x,y) );
            }
        }
        return triangle.get(0).get(0);
    }
}