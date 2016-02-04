
public class LinkedList {

    private LinkedListNode head = null;
    
    private static class LinkedListNode {
        
        Object object = null;
        LinkedListNode next;
        LinkedListNode previous;
        
        LinkedListNode(Object object) {
            this.object = object;
        }
    }

    public void add(Object object) {
        
        if (head == null) {
            head = new LinkedListNode(object);
            return;            
        }
        
        LinkedListNode tmp = head;
        
        while (tmp.next != null) {                     
            tmp = tmp.next;
        }
        
        tmp.next = new LinkedListNode(object);
        tmp.next.previous = tmp;
    }
    
    public Object get(int index) {
        int i = 0;
        LinkedListNode tmp = head;
        
        while (tmp != null) {
            if (i == index) return tmp.object;
            
            tmp = tmp.next;
            ++i;
        }

        return tmp == null ? null : tmp.object;
    }
    
    public void delete(int index) {
        
        if (index == 0) {
            head = head.next;
            head.previous = null;
            return;
        }
        
        int i = 0;
        LinkedListNode tmp = head;        
        while (tmp != null) {
            if (i == index) {
                tmp.previous.next = tmp.next;
                tmp.next.previous = tmp.previous;
                return;
            }
            
            tmp = tmp.next;
            ++i;
        }
    }

    public static void main(String [] args) {
        LinkedList ll = new LinkedList();
        
        ll.add("1");
        ll.add("2");
        ll.add("3");
        
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        System.out.println(ll.get(2));
        
        ll.delete(1);
        
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        System.out.println(ll.get(2));        
    }
    
}