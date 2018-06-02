题目描述

Given a set of distinct integers, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

For example,
If S =[1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if ( S == null || S.length == 0){
            return ret;
        }
        Arrays.sort(S);
        int n = S.length;
        
        for(int i = 0;i<(1<<n);i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0;j<n;j++){
                if ((i & (1<<j)) != 0){
                    list.add(S[j]);
                }
            }
            ret.add(list);
        }
        Collections.sort(ret,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                Integer l1 = o1.size();
                Integer l2 = o2.size();
                if (l1 != l2){
                    return l1.compareTo(l2);
                }
                for(int i = 0;i<l1;i++){
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