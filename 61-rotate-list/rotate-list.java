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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null ||k==0){
            return head;
        }
        ListNode tail=head;
        int count=1;
        while(tail.next!=null){
            count++;
            tail=tail.next;
        }
        k=k%count;
        if(k==0){
            return head;
        }
        int sz=count-k-1;
        ListNode prev=head;
        int i=0;
        while(i<sz){
            prev=prev.next;
            i++;

        }
        ListNode start=prev.next;
        prev.next=null;
        tail.next=head;
        return start;
        
    }
}