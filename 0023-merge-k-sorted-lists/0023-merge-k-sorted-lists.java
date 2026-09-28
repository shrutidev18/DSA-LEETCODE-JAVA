/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode res = new ListNode(0);
        ListNode cur = res;
        for(ListNode l : lists){
            if (l != null) {
                pq.offer(l);
            }
        }
        while(!pq.isEmpty()){
            ListNode val = pq.poll();
            cur.next=val;
            cur=cur.next;
            if (val.next != null) {
                pq.offer(val.next);
            }           
        }
        return res.next;
        
    }
}