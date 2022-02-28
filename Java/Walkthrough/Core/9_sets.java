import java.util.*;
class Sets {
    public static void main(String[] args){ //O(n) complexity
        Set<String> fruits=new HashSet<String>(); //Set is an interface implemented by Hashset class, use LinkedHashSet to print the value in sequential inputted order but increase in complexity, TreeSet to get the output in sorted form
        fruits.add("Ba");
        fruits.add("Ap");
        fruits.add("Ki");
        fruits.add("Ki");
        //fruits.addAll(fruits1); will result to union of two sets in fruits
        //fruits.retainAll(fruits1); will perform intersection and store in fruits
        //fruits.containsAll(fruits1); checks if fruits1 is subset of fruits
        System.out.println(fruits); //ascend unordered list and no addition of repeated element
        //hashset goes through a hashfunction which always returns constant value for a give input, this value is used to store input, check for dupicate etc.
    }
}
