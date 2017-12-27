题目描述

Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
import java.util.*;
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        if (digits == null){
            return list;
        }
        String[] dic = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int n = digits.length();
        list.add("");
        for(int i = 0;i<n;i++){
            int t = digits.charAt(i) - '0';
            int m = list.size();
            for(int j = 0;j<m;j++){
                String s = list.get(j);
                for(int k = 0;k < dic[t].length();k++){
                    list.add(new String(s+dic[t].charAt(k)));
                }
            }
            for(int j = 0;j<m;j++){
                list.remove(0);
            }
        }
        return list;
    }
}