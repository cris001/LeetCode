题目描述

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
Your algorithm should run in O(n) complexity.
import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Boolean> mp = new HashMap<Integer,Boolean>();
        for(int t:num){
            mp.put(t,false);
        }
        Iterator<Integer> it = mp.keySet().iterator();
        int ans = 0;
        while(it.hasNext()){
            Integer t = it.next();
            if (mp.get(t)){
                continue;
            }
            mp.put(t,true);
            int count = 1;
            int s = t-1;
            while(mp.containsKey(s)){
                count++;
                mp.put(s,true);
                s--;
            }
            int b = t+1;
            while(mp.containsKey(b)){
                count++;
                mp.put(b,true);
                b++;
            }
            ans = Math.max(ans,count);
            
        }
        return ans;
    }
}