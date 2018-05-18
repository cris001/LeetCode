题目描述

Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();    
        if (numRows == 0){
            return ret;
        }
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=1;j<=i+1;j++){
                if (j==1 || j==i+1){
                    list.add(1);
                    continue;
                }
                int a = ret.get(i-1).get(j-2);
                int b = ret.get(i-1).get(j-1);
                list.add(a+b);
            }
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }
}