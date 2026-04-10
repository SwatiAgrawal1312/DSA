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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode head=dummy;
        int carry=0;
        int sum=0;
        int res=0;
        while(l1!=null && l2!=null){
            sum=carry+l1.val+l2.val;
            res=sum%10;
            dummy.next=new ListNode(res);
            dummy=dummy.next;

            carry=sum/10;

            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            sum=l1.val+carry;
            res=sum%10;
            dummy.next=new ListNode(res);
            dummy=dummy.next;

            carry=sum/10;

            l1=l1.next;


        }
        while(l2!=null){
            sum=l2.val+carry;
            res=sum%10;
             dummy.next=new ListNode(res);
            dummy=dummy.next;

            carry=sum/10;

            l2=l2.next;

        }
        if(carry!=0){
            dummy.next=new ListNode(carry);
        }
        return head.next;

    }
}