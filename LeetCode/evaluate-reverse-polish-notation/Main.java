题目描述

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int len = tokens.length;
        for(String s : tokens){
            if (! "+".equals(s) && ! "-".equals(s) && ! "*".equals(s) && ! "/".equals(s)){
                stack.push(Integer.parseInt(s));
            }else{
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer c = 0;
                switch(s){
                    case "+" : c = a + b;
                        break;
                    case "-" : c = a - b;
                        break;
                    case "*" : c = a * b;
                        break;
                    default : c = a / b;
                        break;
                }
                stack.push(c);
            }
        }
        return stack.pop();
    }
}