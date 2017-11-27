题目描述

The set[1,2,3,…,n]contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):
."123"
."132"
."213"
."231"
."312"
."321"

Given n and k, return the k th permutation sequence.
Note: Given n will be between 1 and 9 inclusive.
import java.util.*;
public class Solution {
    public String getPermutation(int n, int k) {
        int a[] = new int[n+1];
        for(int i = 1;i<=n;i++){
            a[i] = i;
        }
        for(int i = 1;i<=k-1;i++){
            nextPermutation(a);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append((char)(a[i]+'0'));
        }
        return sb.toString();
    }
    public void nextPermutation(int[] a){
        int len = a.length;
        int i = len - 2;
        while(i>=0 && a[i+1]<a[i]){
            i--;
        }
        if (i>=0){
            int j = i+1;
            while(j < len && a[j]>a[i]){
                j++;
            }
            j--;
            swap(a,i,j);
        }
        reverse(a,i+1,len-1);
    }
    
    public void swap(int[] a ,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void reverse(int[] a ,int l,int r){
        for(int i = l;i<=(l+r)/2;i++){
            swap(a,i,r-(i-l));
        }
    }
}