题目描述

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from startto end, such that:
.Only one letter can be changed at a time
.Each intermediate word must exist in the dictionary
For example,
Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]
As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.
import java.util.*;
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        HashMap<String,Integer> map = new HashMap<>();
        Iterator<String> iterator = dict.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            map.put(s,Integer.MAX_VALUE/2);
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        map.put(start,1);
        int ans = 0;
        while(!queue.isEmpty()){
            String s = queue.poll();
            if (s.equals(end)){
                return map.get(s);
            }
            if (canReach(s,end)){
                return map.get(s) + 1;
            }
            Iterator<String> it = dict.iterator();
            while(it.hasNext()){
                String t = it.next();
                if (canReach(s,t)){
                    int step = map.get(s);
                    map.put(t,step + 1);
                    queue.add(t);
                    it.remove();
                }
                
            }
        }
        return ans;
    }
    public boolean canReach(String s,String t){
        int n = s.length();
        int m = t.length();
        int l = Math.min(n,m);
        int count = 0;
        for(int i = 0;i<l;i++){
            if (s.charAt(i) != t.charAt(i)){
                count++;
            }
        }
        count+=Math.abs(n - m);
        return count == 1;
    }
    
}