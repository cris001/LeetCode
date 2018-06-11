题目描述

Implementint sqrt(int x).
Compute and return the square root of x.
public class Solution {
    public int sqrt(int x) {
        if (x == 0){
            return 0;
        }
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if (mid > (x / mid)){
                right = mid - 1;
            }else{
                if ( (mid + 1) > (x / (mid + 1)) ){
                    return mid;
                }
                left = mid + 1;
            }
        }
        return right;
    }
}