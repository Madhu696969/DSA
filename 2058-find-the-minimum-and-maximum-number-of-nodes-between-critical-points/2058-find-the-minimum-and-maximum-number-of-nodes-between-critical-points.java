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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode cur=head.next;
        int minDis=Integer.MAX_VALUE;
        int lstI=-1,fIdx=-1;
        int idx=1;
        while(cur.next!=null){
            ListNode nxt=cur.next;

            boolean Max=cur.val > prev.val && cur.val > nxt.val;
            boolean Min=cur.val < prev.val && cur.val < nxt.val;

            if(Max || Min){
                if(lstI==-1){
                    fIdx=idx;
                }
                else{
                    minDis=Math.min(minDis,idx-lstI);
                }
                lstI=idx;
            }
            idx++;
            prev=cur;
            cur=nxt;
        }
        int max=lstI-fIdx;
        if(fIdx==-1  || fIdx==lstI){
            return new int[]{-1,-1};
        }
        return new int[]{minDis,max};
    }
}