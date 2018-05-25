题目描述

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 ="great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node"gr"and swap its two children, it produces a scrambled string"rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that"rgeat"is a scrambled string of"great".
Similarly, if we continue to swap the children of nodes"eat"and"at", it produces a scrambled string"rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that"rgtae"is a scrambled string of"great".
Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        int a[] = new int[30];
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1!=l2){
            return false;
        }
        for(int i = 0;i<l1;i++){
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for(int i = 0;i<=26;i++){
            if (a[i] != 0){
                return false;
            }
        }
        for(int i = 1;i<l1;i++){
            if (isScramble(s1.substring(0,i),s2.substring(0,i)) 
                && isScramble(s1.substring(i),s2.substring(i))){
                return true;
            }
            if (isScramble(s1.substring(0,i),s2.substring(l2-i)) 
                && isScramble(s1.substring(i),s2.substring(0,l2-i))){
                return true;
            }
        }
        return false;
    }
}