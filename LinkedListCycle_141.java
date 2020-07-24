class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode s = head;
        ListNode f = head;
        
        while(s!=null && f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s==f) return true;
        }
        
        return false;
    }
}