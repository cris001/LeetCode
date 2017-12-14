题目描述

You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
For example, given:
S:"barfoothefoobarman"
L:["foo", "bar"]
You should return the indices:[0,9].
(order does not matter).
import java.util.*;
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (S == null || L == null){
            return list;
        }
        if (S.length() == 0 || L.length == 0 || L[0].length() == 0){
            return list;
        }
        int n = L.length;
        int m = L[0].length();
        if (S.length() < n*m){
            return list;
        }
        ArrayList<String> d = new ArrayList<String>();
        for(String str : L){
            d.add(str);
        }
        for(int i = 0;i<=S.length() - m;i++){
            String t = S.substring(i,i+L[0].length());
            ArrayList<String> dic = new ArrayList<String>(d);
            if (dic.contains(t)){
                dic.remove(t);
                for(int j = i+m;j<=S.length() - m;j+=m){
                    String p = S.substring(j,j+m);
                    if (dic.contains(p)){
                        dic.remove(p);
                    }else{
                        break;
                    }
                }
            }
            if (dic.size() == 0){
                list.add(i);
            }
        }
        return list;
    }
}