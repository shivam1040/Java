import java.util.*;
class VecStac<E>{ //stack:last in first out, last element inserted can be taken out first and first element inserted can be take out last
     //in vector data structure, mutli threading can't be done, synchronized and thread safe so more time, it is used in cases when multiple entries to list are happening at the same time and first come first input needs to be taken serious
    public static void main(String[] args) throws Exception{
        Stack<Integer> stk=new Stack<Integer>();
        stk.push(12);
        stk.push(24); //push one element above 12
        stk.pop(); //remove one element for top
        System.out.println(stk.peek()); //displays top element
        Stackm<String> obj1=new Stackm<String>();
        obj1.push("A");//callass manually implemented stack
        obj1.push("B");
        System.out.println(obj1.pop());
        System.out.println(obj1.pop());
        System.out.println(obj1.peek());//exception throwing empty no peeling
    }
    //manually implementing stack using linkedlist
static class Stackm<E>{ //static so that it can be used as a nested class and called from the main class
    
    LinkedList2<E> obj=new LinkedList2<E>(); //creating obj of manually implememnted linkedlist from Linkedlist2 class in4_linkedlist... file
    
    void push(E e){
        obj.add(e); //calls add function of manually implemented linkedist in above 4_linkedist_same...
        System.out.println("done push");
    }

    E pop() throws Exception{
        if(obj.isEmpty()){
            throw new Exception("Empty");
        }
        return obj.removelast();
    }
    E peek() throws Exception{
        if(obj.isEmpty()){
            throw new Exception("empty no peeking");
        }
        return obj.getlast();
    }
}
}