题目描述
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.

import java.util.*;
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int pre = 0;
        for(int i = s.length()-1;i>=0;i--){
            int t = map.get(s.charAt(i));
            if (t>=pre){
                ans+=t;
            }else{
                ans-=t;
            }
            pre = t;
        }
        return ans;
    }
}