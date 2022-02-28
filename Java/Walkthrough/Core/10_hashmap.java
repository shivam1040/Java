import java.util.*;
import java.util.Map.Entry;
class Hashmap { //key is unique no repitition //O(1) complexity
    public static void main(String[] args){
        Map<String, Integer> obj=new HashMap<String, Integer>();
        obj.put("one", 1); //add values, key should be always constant, values change is a convention
        obj.put("two", 2);
        obj.put("one", 10); //doesn't repeat but updates one with 10
        //putAll(); adds map to the given map
        obj.putIfAbsent("one", 20); //inserts value only if one is absent key
        obj.get("two"); //returns value at two else null for no present
        obj.containsKey("one"); //checks if key is present
        obj.containsValue(1); //checks if value 1 is present
        obj.remove("two"); //removes key two and its value
        obj.keySet(); //returns entire key in a set
        obj.entrySet(); //returns entire key value in set
        Set<Entry<String, Integer>> entries=obj.entrySet(); //gets obj in Entry format
        for(Entry<String, Integer> entry:entries){
            entry.setValue(entry.getValue()*100); //changes the values of obj keys by 100
        }
        System.out.println(obj); //returns updated obj //
        //hash function always return long
        //Chaining is techniUe to avoid collision, repetition of hascode leading to storage of values in the same index
    }
}
