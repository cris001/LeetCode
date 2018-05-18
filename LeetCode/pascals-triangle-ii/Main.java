题目描述

Given an index k, return the k th row of the Pascal's triangle.
For example, given k = 3,
Return[1,3,3,1].

import java.util.*;
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
      
        int f[] = new int[rowIndex+1];
        f[0] = 1;
        for(int i =1;i<=rowIndex;i++){
            for(int j = i;j>=1;j--){
                f[j]+=f[j-1];
            }
        }
        for(int i =0;i<=rowIndex;i++){
            list.add(f[i]);
        }
        return list;
    }
}