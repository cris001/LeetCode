题目描述

The string"PAYPALISHIRING"is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line:"PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3)should return"PAHNAPLSIIGYIR".
import java.util.*;
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() <= 1 || nRows <= 1){
            return s;
        }
        
        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>(nRows);
        for (int i = 0; i < nRows; i++) {
        	list.add( new StringBuilder());
		}
        int n = s.length();
        int i = 0;
        while(i < n){
            int k = i % (2* (nRows - 1));
            if (k >= nRows){
                k = 2* (nRows - 1) - k;
            }
            StringBuilder sb = list.get(k);
            sb.append(s.charAt(i));
            i++;
        }
        StringBuilder t = new StringBuilder();
        for(int j = 0;j<nRows;j++){
            t.append(list.get(j));
        }
        return t.toString();
    }
    
}