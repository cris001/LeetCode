题目描述

Validate if a given string is numeric.
Some examples:
"0"=>true
" 0.1 "=>true
"abc"=>false
"1 a"=>false
"2e10"=>true
public class Solution {
    public boolean isNumber(String s) {
        try{
            char c = s.charAt(s.length() - 1); 
            if (c == 'f' || c == 'F' ||c == 'd' ||c == 'D'){
                return false;
            }
            Double a = Double.valueOf(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}