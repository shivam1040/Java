import java.util.*;
class Arrdeq{ //add/remove elements from both end :doublyendedqueue
    //offerfirst, pollfirst, peekfirst, offerlast, polllast, peeklast: return false/null, addfirst, removefirst, getfirst, addlast, removelast, getlast:throws exception
    public static void main(String [] args){
        ArrayDeque<Integer> a1=new ArrayDeque<Integer>();
        a1.addFirst(12);
        a1.addFirst(13);
        a1.addFirst(14);
        a1.push(11);
        a1.pop(); //array dequ can be used as stack too since array deq extends queue class, faster than stack because, satck extended from vector and vector are thread safe, so no multi operation for one task
        System.out.println(a1);
        DoubleList<Integer> a2=new DoubleList<Integer>();
        a2.addhead(1);
        a2.addhead(2);
        System.out.print(a2.removelast());
    }
}
