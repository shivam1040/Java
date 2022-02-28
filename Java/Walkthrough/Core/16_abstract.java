abstract class Base {
    void hello(){
        System.out.println("Hey");
    }
    abstract void greet();

}

class Sub extends Base{
    @Override
    void greet(){  //extending abstract class means all the abstract methods of base class must be defined in subclass
        System.out.println("hi");
    }
}
class Sub2 extends Base{ //to do further extending, either implement all abstract methods or define this class as abstract class
    void hi(){
        System.out.println("H"); //and unless all the methods are implemented objecs can't be created for required class, so in this case base class can't be insantiated   
    }
    //Base obj=new Sub(); this is allowed, dynamic method dispatch, base obj is refrence class while new Sub is object of concrete sub class
}
