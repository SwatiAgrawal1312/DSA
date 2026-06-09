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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1==null && list2==null){
            return null;
        }
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next=new ListNode(l1.val);
                l1=l1.next;
                dummy=dummy.next;

            }else{
                dummy.next=new ListNode(l2.val);
                l2=l2.next;
                dummy=dummy.next;
            }
        }
        while(l1!=null){
            dummy.next=new ListNode(l1.val);
                l1=l1.next;
                dummy=dummy.next;


        }
        while(l2!=null){
             dummy.next=new ListNode(l2.val);
                l2=l2.next;
                dummy=dummy.next;
            
        }
        dummy.next=null;
        return head.next;

        
    }
}