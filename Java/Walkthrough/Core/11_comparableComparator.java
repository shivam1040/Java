import java.util.*;

class Studm{
    public static void main(String[] args){
        List<Stud> studs=new ArrayList<Stud>(); //creating arraylist of type Stud
        studs.add(new Stud(1, "C"));
        studs.add(new Stud(2, "B"));
        studs.add(new Stud(3, "C"));
        //Collections.sort(studs); //will not work normally since Stud class doesn't extend comparable and it's been passed as a type to the list above
        //Collections.sort(studs, new SortbyNamethenMarks()); //used to sort in the user defined order by using comparator class, 
        Collections.sort(studs, new Comparator<Stud>(){ //This type of comparator definition is also called anonymous class
            @Override //same as above Collections.sort
            public int compare(Studm.Stud o1, Studm.Stud o2) {
                // TODO Auto-generated method stub
                if(o1.name.equals(o2.name)){
                    return o1.marks-o2.marks;
                } //sorting in descending order
                else{
                    return o1.name.compareTo(o2.name);
                }
            } 
        });
       
        Collections.sort(studs, (Studm.Stud o1, Studm.Stud o2) -> { //implementation of above collection.sort using lambda functions
                // TODO Auto-generated method stub
                if(o1.name.equals(o2.name)){
                    return o1.marks-o2.marks;
                } //sorting in descending order
                else{
                    return o1.name.compareTo(o2.name);
                }
        });

        //Collections.sort(studs, Comparator.comparing(Stud::getname).thenComparing(Stud::getmark)); this is way of making user defined comparisons using user built functions, eg. states comparing is done according to getname function of Stud class, thencomparing compares further using given function if a match is founf, thenComparing(Stud:getname).reversed()--this makes sures that data is reversed after match is found in thencomparing
        studs.forEach(System.out::println); //lambda function, for each system.out it'll print stud with line break
    }
static class Stud {
    int marks;
    String name;
    Stud(int marks, String name){
        super();
        this.marks=marks;
        this.name=name;
    }
 
    @Override
    public String toString(){
        return "Stud [mark="+marks+", name="+name+"]";
    }
    int getmark(){
        return marks;
    }
    void setmark(int marks){
        this.marks=marks;
    }
    String getname(){
        return name;
    }
    void setname(String name){
        this.name=name;
    }

    //@Override
    //public int compareTo(Studm.Stud o) { //compare can only return integer signed or zero
        // TODO Auto-generated method stub
      //  if(this.marks>o.marks)  return -1;
        //else if(this.marks<o.marks) return 1;
        //return 0;
        //return this.name.compareTo(o.name);// compareto() is present in string class; makes sure when above criteria is equal, sorting is done on the basis of another criteria for that one criteria
        //above code will return elements in descending order, to change the order just reverse the signs
    //} to use this code implement current scope class with comparable


}
static class SortbyNamethenMarks implements Comparator<Stud>{

    @Override
    public int compare(Studm.Stud o1, Studm.Stud o2) {
        // TODO Auto-generated method stub
        if(o1.name.equals(o2.name)){
            return o1.marks-o2.marks;
        } //sorting in descending order
        else{
            return o1.name.compareTo(o2.name);
        }
    }
    
}
}
//implementig comparable changes the natural order of the given class so class objects are sorted in the user defined way everytime
//implementing comparator class gives flexibility by enabling the user to pass sorting order as a parameter or sort naturally or have different sorting methods