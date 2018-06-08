题目描述

Clone an undirected graph. Each node in the graph contains alabeland a list of itsneighbors.

import java.util.*;
public class Solution {
    HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node);
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node){
        if (node == null){
            return null;
        }
        if (map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode t = new UndirectedGraphNode(node.label);
        map.put(node.label,t);
        for(UndirectedGraphNode p : node.neighbors ){
            t.neighbors.add(dfs(p));
        }
        return t;
    }
}