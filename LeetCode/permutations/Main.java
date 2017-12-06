题目描述

Given a collection of numbers, return all possible permutations.
For example,
[1,2,3]have the following permutations:
[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null || num.length == 0){
            return ret;
        }
        Arrays.sort(num);
        int n = num.length;
        dfs(0,n,num);
        Iterator<ArrayList<Integer>> it = set.iterator();
        while(it.hasNext()){
            ret.add(it.next());
        }
        return ret;
    }
    public void dfs(int t, int n, int[] num){
        if (t >= n){
            return;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<n;i++){
            list.add(num[i]);
        }
        set.add(list);
        for(int i = t+1;i<n;i++){
            swap(num,t,i);
            dfs(t+1,n,num);
            swap(num,t,i);
        }
        dfs(t+1,n,num);
    }
    
    public void swap(int[] num,int i,int j){
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}