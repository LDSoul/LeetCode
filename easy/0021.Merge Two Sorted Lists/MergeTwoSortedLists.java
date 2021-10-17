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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
            分析: 
                1. ListNode中的val是每個node的值、next是指向下一個node。
                2. 兩者比較，比較小的就先放，放完後指向下一個node，繼續做比較，直到空為止。
            
            解題:
                1. 若L1全空，則不須排序答案為L2，反之L2。
                2. 比較小的就先放頭，放完後該L指向下一個node。
            
            補充:
                a -> c -> b
                ListNode b = a.next;
                ListNode c = new ListNode(20);
                a.next = c;
                c.next = b;
        */
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        /*
            1,3,5
            2,2,4
                1. l1.next = ((3,5), (2,2,4)) return l1(1)
                2. l2.next = ((3,5), (2,4)) return l2(2)
                3. l2.next = ((3,5), (4)) return l2(2)
                4. l1.next = ((5),  (4)) return l1(3)
                5. l2.next = ((5), ()) return l2(4)
                6. return l1(5)
                ==> 1 2 2 3 4 5
        */
    }
}