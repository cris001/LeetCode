题目描述

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
import java.util.*;
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }
        if (lists.size() == 1){
            return lists.get(0);
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if (o1.val > o2.val){
                    return 1;
                }else if (o1.val < o2.val){
                    return -1;
                }
                return 0;
            }
        });
        int n = lists.size();
        for(int i = 0;i<n;i++){
            if (lists.get(i) != null){
                queue.add(lists.get(i));
            }
        }
        ListNode p = new ListNode(-1);
        ListNode t = p;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            t.next = node;
            t = node;
            if (node.next != null){
                queue.add(node.next);
            }
        }
        return p.next;
    }
}