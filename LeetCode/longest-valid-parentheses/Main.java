题目描述

Given a string containing just the characters'('and')', find the length of the longest valid (well-formed) parentheses substring.
For"(()", the longest valid parentheses substring is"()", which has length = 2.
Another example is")()())", where the longest valid parentheses substring is"()()", which has length = 4.
import java.util.*;
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int last = -1;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0;i<n;i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                if (stack.isEmpty()){
                    last = i;
                }else{
                    stack.pop();
                    if (stack.isEmpty()){
                        ans = Math.max(ans,i-last);
                    }else{
                        ans = Math.max(ans,i-stack.peek());
                    }
                }
            }
        }
        return ans;
    }
}