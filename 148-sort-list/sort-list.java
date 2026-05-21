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

        
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(arr);
        // create new LinkedList
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        for(int i=0;i<arr.size();i++){
            curr.next=new ListNode(arr.get(i));
            curr=curr.next;
        }
        return dummy.next;
        

        
        


        
        
    }
}