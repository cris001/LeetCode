题目描述

Given a collection of integers that might contain duplicates, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

For example,
If S =[1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
import java.util.*;

public class Solution {


public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 1)
            return res;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        solve(nums, 0, res, list);
        return res;
    }
 
    private void solve(int[] nums, int start, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        res.add(new ArrayList<Integer>(list));
        if (start >= nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            solve(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}