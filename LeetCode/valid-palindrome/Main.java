题目描述

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama"is a palindrome.
"race a car"is not a palindrome.
import java.util.*;
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z')){
                sb.append(c);
            }
            if ((c >= 'A' && c <= 'Z')){
                char ch = (char) (c-'A'+'a');
                sb.append(ch);
            }
            if ((c >= '0' && c <= '9')){
                sb.append(c);
            }
        }
        String t = sb.toString();
        for(int i=0;i<t.length()/2;i++){
            if (t.charAt(i) != t.charAt(t.length() - i -1)){
                return false;
            }
        }
        return true;
    }
}