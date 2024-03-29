package _00_Problems_Sorted_By_Patterns;

public class LinkedList<I extends Number> {

    public LinkedList(){}
    ListNode first;
    ListNode last;
    public LinkedList(Integer[] ar){
        first = null;

        ListNode prev = null;
        for(Integer elem : ar){
            //head.data = elem;
            ListNode current = new ListNode(elem);
            if(prev != null){
                prev.next = current;
                //System.out.println(" prev "+prev.data+" --> "+prev.next.data);
            }
            if(first == null){
                first = current;
            }
            //head = current;
            prev = current;
        }
    }
    public ListNode getHead(){
        //System.out.println(" returning head of LL as "+first.data);
        return first;
    }

    public ListNode getLast(){
        last = first;
        if(last == null){
            return last;
        }
        while(last.next != null){
            last = last.next;
        }
        //System.out.println(" returning tail of LL as "+last.data);
        return last;
    }



    public static void printList(ListNode head){
        ListNode result = head;
        System.out.println("\n.....list here");
        while(result!=null){
            System.out.print(result.data+" -> ");
            result= result.next;
        }
        System.out.println();
    }
    static class ListNode {
        Integer data;
        ListNode next;
        public ListNode(){

        }
        public ListNode(Integer data){
            this.data = data;
        }
    }
}



