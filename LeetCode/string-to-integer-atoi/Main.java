题目描述
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
spoilers alert... click to show requirements for atoi.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
public class Solution {
    public int atoi(String str) {
        if (str == null || str.trim().length() == 0){
            return 0;
        }
        str = str.trim();
        int len = str.length();
        int sign = 1;
        int s = 0;
        
        if (str.charAt(0) == '-'){
            sign = -1;
            s++;
        }else if (str.charAt(0) == '+'){
            s++;
        }
        long ans = 0;
        for(int i = s;i<len;i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if (ans > 2147483647 / 10 || ans == 2147483647/10 && str.charAt(i) > '7'){
                    if (sign == 1){
                        return 2147483647;
                    }else{
                        return -2147483648;
                    }
                }
                ans = ans*10 + str.charAt(i) - '0';
            }else{
                break;
            }
        }
        return (int)ans*sign;
    }
}