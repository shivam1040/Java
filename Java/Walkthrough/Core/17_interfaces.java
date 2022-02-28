interface Interfa { //in inerfae class all the methods are abstract while in abstract class some can be defined some can be abstract
    public void a();
    public void b();
    int a=45; //this attribute can't be modified from classes which implement it since the attribute is final but a new attribute can be created with the same name, basically overriding, interfaces are public by default
    default void k(){ //used to update the interface method, since defininig without would lead to defining the function in all the classes implementing this interface, and default methods can be overridden too
        hi(); //private method is used in the cases where default field gets big, basically used to breaks down the default method
        System.out.println("a");
    }
    private void hi(){ //
        System.out.println("h");
    }
}

interface Inter1 extends Interfa{
    void c(); //inherits void a and b of interfa interface-demonstrating inheritance in interfaces
}

class Sub implements Inter1{ //to implement multiple interfaces just separate them with comma
    public void a(){ //if implemented an interface then it's neccesaary to define all the methods
        System.out.println("1");
    }
    public void b(){
        System.out.println("2");
    }
    public void c(){ //withouth defining void c, program will return error, sinc the implemented interface extends anothe interface and the methods need to be defined
        System.out.println("s");
    }
}
//multiple interfaces can be implemented while abstract class can't be multiple extended

