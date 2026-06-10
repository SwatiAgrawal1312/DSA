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
        if(headA==null || headB==null){
            return null;
        }
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
        int diff=Math.abs(sz1-sz2);
        
        if(sz1>sz2){
            while(diff>0){
                headA=headA.next;
                diff--;

            }
           
        }
       
        if(sz2>sz1){
            while(diff>0){
                headB=headB.next;
                diff--;

            }
            
        }
        
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headB=headB.next;
            headA=headA.next;

        }
        return null;
    }
}