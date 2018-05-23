题目描述

Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example:
Given"25525511135",
return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
import java.util.*;
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0){
            return list;
        }
        int len = s.length();
        for (int i = 0;i<3 && i < len;i++){
            for (int j = i+1;j<i+4 && j < len;j++){
                for (int k = j+1;k<j+4 && k < len - 1;k++){
                        if (len - k >4){
	                		continue;
	                	}
                        int a = Integer.parseInt(s.substring(0,i+1));
                        int b = Integer.parseInt(s.substring(i+1,j+1));
                        int c = Integer.parseInt(s.substring(j+1,k+1));
                        int d = Integer.parseInt(s.substring(k+1,len));
                        if (a <= 255 && b <= 255 && c <= 255 && d <= 255){
                            String ip = a + "." + b + "." + c + "." + d;
                            if (ip.length() < len + 3)
                                continue;
                            list.add(ip);
                        }   
                }
            }
        }
        return list;
    }
}