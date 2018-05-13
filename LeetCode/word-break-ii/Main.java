题目描述

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].

import java.util.ArrayList;
import java.util.Set;
 
public class Solution {
      
    private ArrayList<String> list=new ArrayList<String>();
    private boolean[] flag;
 
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        flag =new boolean[s.length()];
        recursion(s,dict,s.length(),new StringBuilder());
        return list;
    }
 
    private void recursion(String s,Set<String> dict,int last,StringBuilder share){
        for(int i=last-1;i>=0;i--){
            String tempString=s.substring(i,last);
            if(!flag[i] && dict.contains(tempString)){
                StringBuilder tempBuilder=new StringBuilder(share);
                if(i==0){
                    tempBuilder.insert(0,tempString);
                    list.add(tempBuilder.toString());
                }else{
                    int oldSize=list.size();
                    tempBuilder.insert(0," "+tempString);
                    recursion(s,dict,i,tempBuilder);
                    if(oldSize==list.size())
                        flag[i]=true;
                }
            }
        }
    }
}