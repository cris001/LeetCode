题目描述

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
import java.util.*;
public class Solution {
    ArrayList<String> list = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        if (n <= 0){
            return list;
        }
        StringBuilder s = new StringBuilder();
        getParenthesis(0,0,n,s);
        return list;
    }
    
    public void getParenthesis(int l,int r,int n,StringBuilder s){
        if (l == n && r == n){
            list.add(s.toString());
            return;
        }
        if (r > n){
            return;
        }
        StringBuilder t = new StringBuilder(s);
        if (l >= n){
            getParenthesis(l,r+1,n,s.append(")"));
        }else if (l == r){
            getParenthesis(l+1,r,n,s.append("("));
        }else if (r < l){
            getParenthesis(l+1,r,n,s.append("("));
            getParenthesis(l,r+1,n,t.append(")"));
        }
    }
}