题目描述

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (n == 0 || k>n){
            return ret;
        }
        for(int i = 0;i<(1<<n);i++){
            int m = 0;
            int count = 0;
            while( i >= (1<<m)){
                if ((i & (1<<m)) != 0 ){
                    count++;
                }
                m++;
            }
            if (count == k){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int j = 0;j<n;j++){
                    if ((i & (1<<j)) != 0 ){
                        list.add(j+1);
                    }
                }
                ret.add(list);
            }
        }
        
        Collections.sort(ret,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                for(int i = 0;i<o1.size();i++){
                    if (o1.get(i) != o2.get(i)){
                        return o1.get(i).compareTo(o2.get(i));
                    }
                }
                return 0;
            }
        });
        return ret;
    }
}