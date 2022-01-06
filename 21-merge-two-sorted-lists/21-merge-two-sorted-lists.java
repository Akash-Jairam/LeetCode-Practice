class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(-1);
        ListNode copy = list3;
        
        while(list1 != null && list2 != null){
        
        if(list1.val < list2.val){
            copy.next = new ListNode(list1.val);
            copy = copy.next;
            list1 = list1.next;
        } else if(list2.val < list1.val){
            copy.next = new ListNode(list2.val);
            copy = copy.next;
            list2 = list2.next;
        } else{
            copy.next = new ListNode(list1.val);
            list1 = list1.next;
            copy = copy.next;
            copy.next = new ListNode(list2.val);
            copy = copy.next;
            list2 = list2.next;
        }
            
        
    
        }
        
        if(list1 != null)
            copy.next = list1;
        
        if(list2 != null)
            copy.next = list2;
        
        return list3.next;
    }
}