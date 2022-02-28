import java.util.List;
import java.util.ArrayList;
 class Arraylist {
    public static void main(String args[]) { 
        ArrayList<String> fruits=new ArrayList<>(); //Angular bracket is generics used to define list type, it can be run without defining type too
        List<String> vege=new ArrayList<>();
        vege.add("tom"); //add element
        fruits.add("Apple");
        fruits.add(1, "2"); //inserts 2 at 1
        System.out.println(fruits);
        
        //ArrayList<Integer> marks=new ArrayList<>();
        
        Pair<String, Integer> p1=new Pair<>("A", 45); //creating object for class pair and defining datatypes
        
        p1.getdesc(); //method in pair.java
        fruits.addAll(vege); //add collection
        fruits.get(1); //gets eleme at index 1
        fruits.set(1,"2"); //sets 2 at index 1
        fruits.remove(1); //removes element at index 1
        fruits.clear(); //removes all element
        fruits.removeAll(vege); //removes elements from a list using a list
        fruits.size(); //finds size of list
        fruits.contains("o"); //checks if o is present in fruits
        fruits.isEmpty(); //checks if list is empty
        String tem[]=new String[fruits.size()];
        fruits.toArray(tem); //conversion of list to string
        System.out.println(fruits.get(0)); //gives element at 0
        System.out.println(fruits);
    }
}