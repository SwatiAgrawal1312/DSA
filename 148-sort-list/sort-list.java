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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=findMiddle(head);
        ListNode right=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        ListNode righthalf=sortList(right);
        return merge(left,righthalf);


        
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        }
        return slow;
    } 
    public ListNode merge(ListNode left,ListNode righthalf){
        ListNode dummy=new ListNode(-1);
        ListNode x=dummy;
        while(left!=null && righthalf!=null){
            if(left.val<=righthalf.val){
                x.next=left;
                x=x.next;
                left=left.next;

            }
            else{
                x.next=righthalf;
                x=x.next;
                righthalf=righthalf.next;

            }
        }
        while(left!=null){
           x.next=left;
                x=x.next;
                left=left.next;

        }
        while(righthalf!=null){
             x.next=righthalf;
                x=x.next;
                righthalf=righthalf.next;

        }
        return dummy.next;
    }

    
}