题目描述
Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
The solution set must not contain duplicate combinations.

For example, given candidate set2,3,6,7and target7, 
A solution set is: 
[7]
[2, 2, 3]

import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0){
            return ret;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(0,candidates,target,list);
        return ret;
    }
    
    public void dfs(int t, int[] candidates, int target, ArrayList<Integer> list){
        if (target == 0){
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0){
            return;
        }
        for(int i = t;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(i,candidates,target - candidates[i] ,list);
            list.remove(list.size()-1);
        }
    }
    
}