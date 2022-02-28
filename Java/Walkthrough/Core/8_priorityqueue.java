import java.util.*;
class Priorq{ //elements in PQ are put in unsorted but gets sorted after storing
    public static void main(String[] args){
    PriorityQueue<String> pq=new PriorityQueue<String>(); //to define priority, comparator needs to be defined and passed else PQ follows default ascending sortiing order
    pq.add("B");
    pq.add("A");
    pq.add("D");
    System.out.println(pq); //prints sorted order but not always
    System.out.println(pq.remove()); //while removing, gets removed in sorted order
    }
}