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
        if(head==null || head.next==null|| k==0){
            return head;
        }
        ListNode temp=head;
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
            count++;//5
        }
        temp.next=head;
        k=k%count;
        if(k==0){
            temp.next=null;
            return head;
        }
        int index2find=count-k;
        for(int i=0;i<index2find-1;i++){
            head=head.next;


        }
        ListNode newtail=head;
        head=head.next;
        newtail.next=null;
        
        return head;

       
        
    }
}