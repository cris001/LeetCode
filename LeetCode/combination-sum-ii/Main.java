题目描述

Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
The solution set must not contain duplicate combinations.

For example, given candidate set10,1,2,7,6,1,5and target8, 
A solution set is: 
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0){
            return ret;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Boolean> map = new HashMap<>();
        dfs(0,num,target,list,map);
        return ret;
    }
    
    public void dfs(int t,int[] num,int target,ArrayList<Integer> list,HashMap<Integer,Boolean> map){
        if (target == 0){
            ret.add(new ArrayList<>(list));
            return;
        }
        if (target < 0){
            return;
        }
        for(int i = t;i<num.length;i++){
            if (i>t && num[i] == num[i-1]){
                continue;
            }
            list.add(num[i]);
            dfs(i+1,num,target - num[i],list,map);
            list.remove(list.size()-1);
        }
    }
}