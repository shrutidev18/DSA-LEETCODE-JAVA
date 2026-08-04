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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        while(cur != null){
            ListNode start = cur;
            ListNode prev = null;
            ListNode temp = null;

            //checking
            int check=1;
            while(check<k && cur.next !=null){
                    cur=cur.next;
                    check++;
                }
            cur=start;
            if(check != k) break;
            else{
                for(int i=1;i<=k;i++){
                    temp=cur.next;
                    cur.next=prev;
                    prev=cur;
                    cur=temp;
                }
            }
            last.next=prev;
            start.next = cur;
            last = start;

        }
        return dummy.next;
    }
}