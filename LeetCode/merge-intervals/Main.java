题目描述

Given a collection of intervals, merge all overlapping intervals.
For example,
Given[1,3],[2,6],[8,10],[15,18],
return[1,6],[8,10],[15,18].
import java.util.*;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        if (intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        for(int i = 1;i<intervals.size();i++){
            int preStart = intervals.get(i-1).start;
            int preEnd = intervals.get(i-1).end;
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            if (curStart <= preEnd){
                intervals.set(i, new Interval(preStart, Math.max(preEnd, curEnd)));
                intervals.set(i-1, null);
            }
        }
        while(intervals.remove(null)){}
        return intervals;
    }
}