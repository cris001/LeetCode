题目描述

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1: 
Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].
Example 2: 
Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].
This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].
import java.util.*;
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        int index = 0;
        for(Interval a : intervals){
            if (a.start > newInterval.end){
                list.add(a);
            }else if (a.end < newInterval.start){
                list.add(a);
                index++;
            }else{
                newInterval.start = Math.min(a.start,newInterval.start);
                newInterval.end = Math.max(a.end,newInterval.end);
            }
        }
        list.add(index,newInterval);
        return list;
    }
}