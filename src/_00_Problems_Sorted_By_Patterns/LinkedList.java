package _00_Problems_Sorted_By_Patterns;

public class LinkedList<I extends Number> {

    public LinkedList(){}
    NodeLinkList first;
    NodeLinkList last;
    public LinkedList(Integer[] ar){
        first = null;

        NodeLinkList prev = null;
        for(Integer elem : ar){
            //head.data = elem;
            NodeLinkList current = new NodeLinkList(elem);
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
    public NodeLinkList getHead(){
        //System.out.println(" returning head of LL as "+first.data);
        return first;
    }

    public NodeLinkList getLast(){
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



    public static void printList(NodeLinkList head){
        NodeLinkList result = head;
        System.out.println("\n.....list here");
        while(result!=null){
            System.out.print(result.data+" -> ");
            result= result.next;
        }
        System.out.println();
    }
    static class NodeLinkList{
        Integer data;
        NodeLinkList next;
        public NodeLinkList(){

        }
        public NodeLinkList(Integer data){
            this.data = data;
        }
    }
}

class NodeLinkList{
    Integer data;
    NodeLinkList next;
    public NodeLinkList(){

    }
    public NodeLinkList(Integer data){
        this.data = data;
    }
}

