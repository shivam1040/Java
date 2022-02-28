public class DoubleList<E> { //manual implementation of doubly ended queue using list
    class Node<E>{
        E data;
        Node<E> next, prev;
        Node(E d){
            this.data=d;
            this.next=this.prev=null;
        }
    }
    Node<E> head, tail;
    
    void addhead(E dat){
        Node<E> add=new Node<E>(dat);
        if(head==null){
            head=tail=add;
            System.out.println("done");
            return;
        }
        head.next=add; //adding element next of head
        add.prev=head; //pointing add prev to head
        head=add; //making add the head, since last added elemnt needs to be seen first
        System.out.println("doneA");
    }
    E removelast(){
        if(head==null){ //checking if data present at head not address
            return null;
        }
        Node<E> remov=tail;
        tail=tail.next;
        tail.prev=null;
        remov.next=null; //nullimg address of initial tail
        if(tail==null){
            head=null;
        }
        return remov.data;
    }    
}
