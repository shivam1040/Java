import java.util.*;

class LinkedList1 {
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>();
        l1.add(12); // functions of arraylist present in linkedlist
        l1.add(13); // l1.add(0,13); adds 13 at 0 index, rest shift towards end
        // l1.toArray(); to basic array
        // l1.getClass().getName(); returns name of the class for object l1

        System.out.println(l1.get(0)); // returns element at 0 index

        LinkedList1 l2 = new LinkedList1(); //object to call manual add method of linkedlist below
        l2.add(15);
        l2.add(16);
        l2.print(); //l2 gets passed as object data to head classname variable
    }
//manual implementation of linkedlist below
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head; //classname variable

    void add(int data) {   //stores data at the end
        Node add1 = new Node(data);

        if (head== null) {
            head = add1;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = add1;
    }

    static Node add1(Node h, int i){ //another way to create class method of Node
        return h;
    }

    void print(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }
}
