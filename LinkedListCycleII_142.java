public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode s = head, f = head;
        
        while(s!=null && f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s==f) break;
        }
        
        if(s!=f) return null;
        
        s = head;
        while(s!=f){
            s = s.next;
            f = f.next;
        }
        return s;
    }
}