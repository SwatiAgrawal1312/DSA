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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp=head;
        int size=1;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }
        if(size==n){
            return head.next;

        }
        
        int idx=size-n;
        int i=0;
        temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;

        }
        temp.next=temp.next.next;
        return head;

        
    }
}