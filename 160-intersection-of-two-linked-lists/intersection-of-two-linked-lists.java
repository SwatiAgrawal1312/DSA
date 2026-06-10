/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x=headA;
        ListNode y=headB;
        int sz1=0;
        while(x!=null){
            sz1++;
            x=x.next;

        }
        int sz2=0;
        while(y!=null){
            sz2++;
            y=y.next;
        }
        int d1=0;
        if(sz1>sz2){
            d1=sz1-sz2;
        }
        int d2=0;
        if(sz2>sz1){
            d2=sz2-sz1;
        }
        while(d2>0){
            headB=headB.next;
            d2--;
        }
        while(d1>0){
            headA=headA.next;
            d1--;
        }
        while(headA!=headB){
             headB=headB.next;
              headA=headA.next;

        }
        return headA;
    }
}