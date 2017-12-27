题目描述

Given a string containing just the characters'(',')','{','}','['and']', determine if the input string is valid.
The brackets must close in the correct order,"()"and"()[]{}"are all valid but"(]"and"([)]"are not.
import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i = 0;i<n;i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
                continue;
            }
            char c = s.charAt(i);
            if (c == ')'){
                if (stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
            }
            if (c == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
            }
            if (c == '}'){
                if (stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
            }
            stack.pop();
        }
        
        return stack.isEmpty();
    }
}