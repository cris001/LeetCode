题目描述

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
import java.util.*;
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2){
            return points.length;
        }
        int ans = 0;
        for(Point a:points){
            int x1 = a.x;
            int y1 = a.y;
            int same = 1;
            int m = 0;
            HashMap<Double,Integer> mp = new HashMap<>();
            for(Point b:points){
                if (a.equals(b)){
                    continue;
                }
                int x2 = b.x;
                int y2 = b.y;
                if (x2 == x1){
                    if (y1 == y2){
                        same++;
                    }else{
                        m++;
                    }
                    continue;
                }
                double scope = getScope(x1,y1,x2,y2);
                if (!mp.containsKey(scope)){
                    mp.put(scope,1);
                }else{
                    int k = mp.get(scope);
                    mp.put(scope,k+1);
                }

            }
            int ma = m;
            for(HashMap.Entry<Double,Integer> e : mp.entrySet()){
                ma = Math.max(ma,e.getValue());        
            }
            ans = Math.max(ans,ma + same);
        }
        
        return ans;
        
    }
    public double getScope(int x1,int y1,int x2,int y2){
        return (y1-y2)*1.0/(x1-x2);
    }
    
}