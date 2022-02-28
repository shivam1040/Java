import java.util.*;
class LinkedList2<E> {
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>();
        l1.add(12); // functions of arraylist present in linkedlist
        l1.add(13); // l1.add(0,13); adds 13 at 0 index, rest shift towards end
        // l1.toArray(); to basic array
        // l1.getClass().getName(); returns name of the class for object l1

        System.out.println(l1.get(0)); // returns element at 0 index

        LinkedList2<String> l2 = new LinkedList2<String>(); //object to call manual add method of linkedlist below
        l2.add("15");
        l2.add("16");
        l2.print(); //l2 gets passed as object data to head classname variable
    }
//manual implementation of linkedlist below
     public class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            next = null;
        }
    }

    Node<E> head; //classname variable

    void add(E data) {   //stores data at the end
        Node<E> add1 = new Node<E>(data);

        if (head== null) {
            head = add1;
            return;
        }
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = add1;
    }

    boolean isEmpty(){
        return head==null;
    }

    E removelast() throws Exception{ //generic function for removing last ele
        Node<E> temp=head;
       
        if(temp==null){ //when list has no element
            throw new Exception("empty list no remove");
        }
        
        if(temp.next==null){ //when list has only one element
            Node<E> remove=head;
            head=null;
            return (E) remove.data; //casting optional 
        }

        
        while(temp.next.next!=null){ //iterate until a step before next is null
            temp=temp.next; 
        }
        Node<E> remove=temp.next; //stores last element
        temp.next=null;  //removing the address of second last element
        return remove.data; 
    }

    E getlast() throws Exception{
        Node<E> temp=head;
        if(temp==null){
            throw new Exception("Can't peak");
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.data;
    }

     Node<E> add1(Node<E> h, int i){ //another way to create class method of Node
        return h;
    }

    void print(){
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }
}