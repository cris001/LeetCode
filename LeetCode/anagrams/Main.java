题目描述

Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
import java.util.*;
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();
        if (strs == null || strs.length == 0){
            return ret;
        }
        HashMap<String,ArrayList<String>> mp = new HashMap<String,ArrayList<String>>();
        for(String s:strs){
            String t = sortString(s);
            if (!mp.containsKey(t)){
                mp.put(t,new ArrayList<String>());
            }
            mp.get(t).add(s);
        }
        for(String s :mp.keySet()){
            if (mp.get(s).size() > 1){
                ret.addAll(mp.get(s));
            }
        }
        
        return ret;
    }
    
    public String sortString(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}