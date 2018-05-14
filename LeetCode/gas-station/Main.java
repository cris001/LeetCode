题目描述

There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note: 
 The solution is guaranteed to be unique.
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int now = 0;
        int sum = 0;
        int k = -1;
        for(int i = 0 ;i < gas.length;i++){
            sum += gas[i] - cost[i];
            now += gas[i] - cost[i];
            if (now < 0){
                k = i;
                now = 0;
            }
        }
        if (sum < 0){
            return -1;
        }
        return k + 1;
    }
}