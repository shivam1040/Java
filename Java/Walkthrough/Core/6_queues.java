import java.util.*;
class Queues{  //FIFO, first person to enter wiil go out first
    public static void main(String[] args){
        Queue<Integer> q=new LinkedList<Integer>();
        //add(), remove(), element() give exception when error offer(), poll(), peek() give false/null when error
        q.add(12);
        q.add(13);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        //System.out.println(q.remove());
        Qum<Integer> q1=new Qum<Integer>();
        q1.enq(1);
        q1.enq(2);
        System.out.println(q1.deq());
        //System.out.println(q1.deq());
        //System.out.println(q1.deq());
    }
    static class Qum<E>{
        Node<E> head, rear;
        
        void enq(E e){ //add element
            Node<E> add=new Node<E>(e);
            if(head==null){
                head=rear=add; //condition true means empty list so both head rear same
                System.out.println("s"+add.next);
                return;
            }
            rear.next=add; //adds data object to data as given in Node class
            rear=rear.next; //adds null object to next
            System.out.println("entered");
        }
        
         E deq(){
            
            if(head==null){
                return null;
            }
            Node<E> temp=head;
            head=head.next;
            System.out.println();

            if(head==null){ //to make sure that rear is null too since head null means empty queue
                rear=null;
            }
            return temp.data;
        }

    }
}
