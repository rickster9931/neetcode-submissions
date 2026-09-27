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
    public void reorderList(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two.next != null && two.next.next != null) {
            one = one.next;
            two = two.next.next;
        }
        ListNode prev = null;
        ListNode curr = one.next;
        one.next = null;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        ListNode track = head;
        ListNode inter = prev;
        while (inter != null) {
            ListNode nxt2 = track.next;
            track.next = inter;
            track = nxt2;
            ListNode nxt3 = inter.next;
            inter.next = nxt2;
            inter = nxt3;
        }
    }
}
