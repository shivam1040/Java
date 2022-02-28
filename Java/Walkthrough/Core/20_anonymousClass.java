interface Anoy{
    void met();
}
class Anon implements Anoy{
    public void met(){
        System.out.println("H");
    }


}
class Ma{
    public static void main(String[] args) {
    Anoy obj=new Anoy(){ //implementation of anonym.. class, a class w/o any name
        public void met(){
            System.out.println("Anonymous");
        }
    };

    Anoy obj3=()->{ //implentation of above instruction in lambda form
        System.out.println("a");
    };

}
}
