题目描述

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3→1,3,2
3,2,1→1,2,3
1,1,5→1,5,1
import java.util.*;
public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0){
            return;
        }
        int len = num.length;
        int i = len-2;
        while(i>=0 && num[i+1]<=num[i]){
            i--;
        }
        if (i>=0){
            int j = i+1;
            while(j<len && num[j]>num[i]){
                j++;
            }
            j--;
            swap(num,i,j);
            reverse(num,i+1,len-1);
        }else{
            Arrays.sort(num);
        }
    }
    
    public void swap(int[] num,int i,int j){
        int t =num[i];
        num[i] = num[j];
        num[j] = t;
    }
    
    public void reverse(int[] num,int l, int r){
        for(int i = l;i<=(l+r)/2;i++){
            swap(num,i,r-(i-l));
        }
    }
}