class Threa extends Thread { //implementing threads using thread class
    @Override
    public void run(){ //run method needs to be defined 
        while(true){  //while is just to showcase the implementation of thread

        System.out.println("HA");
        }
    }
}

class Threa2 extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("HA2");
            } 
    }
}

class Threada3 implements Runnable{ //using thread by implementing runnable interface

    @Override
    public void run() {
        while(true){
        // TODO Auto-generated method stub
        System.out.println("Runnable");
        }
    }
    
}

class Threada4 implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
        System.out.println("Runnable2");
        }
    }
    
}

class Runn{

    public static void main(String[] args) {
        Threa obj=new Threa(name:"a"); //to give name to thread
        Threa2 obj2=new Threa2();
        //obj.start();
        obj.join(); //ensures that obj2 thread isnt run until obj thread is complete
        obj2.sleep(555); //holds the obj2 thread for 555ms
        //obj2.start();
        obj2.setPriority(9); //sets   priority to 9
        obj2.(Thread.MAX_PRIORITY); //sets max priority for obj2 thread
        Threada3 bullet=new Threada3(); 
        Thread gun=new Thread(bullet); //for runnable method the created object needs to be passed through object of thread class, self explainable by gun bullet example
        Threada4 bulle2=new Threada4();
        Thread gun2=new Thread(bulle2);
        gun.start();
        gun2.start(); //this start is used to fire threads
        //t.getId(); to get the id of thread, to get other functions refer to java docs
        System.out.println(Thread.currentThread().getState());  //gets the referene of executing thread and prints its state
    }
}