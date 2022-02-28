import java.util.*;
class HasheandEqual { //hashcode and equals are methods of object class
    public static void main(String[] args){
        Pen pen1=new Pen(10, "blue");
        Pen pen2=new Pen(10, "blue");
        System.out.println(pen1==pen2); //same content in object but since loaction is diff so pen1!=pen2, this behaviour can be changed in equals method
        System.out.println(pen1.equals(pen2)); //sysout will return false for pen1==pen2
        Set<Pen> pens=new HashSet<Pen>(); //creation of hashset to store class objects
        pens.add(pen1);
        pens.add(pen2); //this will add only one object since hashcode has been overriden and for the current input it'll give same hashcode
    }
}
class Pen{
    int price;
    String color;
    Pen(int price, String color){
        this.price=price;
        this.color=color;
    }
    @Override //overrides the equal method in Object class
    public boolean equals(Object obj){
        Pen that=(Pen) obj; //casting inputted object to object of pen
        boolean iseq=this.price==that.price && this.color.equals(that.color); //this refrences to pen1 object
        System.out.println(this.color);
        return iseq;
    }
    @Override
    public int hashCode(){
        return price+color.hashCode();
    }
}

//hAShcode and equals method should always overriden together, hashcode to find location and equals to find if already present
//contract-all elements have unique haschode, two hascodes can be same but not element
//use same attributes for both equal and hascode while overriding
//a.equals(b) then a.hashcode()=b.hashcode()