class Varargs {

    static int sum(int ...arr){ //this parameter is way to give mutltiple arguements, int ...arr this is the syntax to accept multiple integers, the below statements return sum, this feature generally stores the multiple arguements in the form of arrray and the user doesn't need to enter array he can enter multiple values till required and if no value is given then the function is executed by takng null value
    // the sum fucntion can be called as sum(...arr:1, 2, 3);
        int result=0;
        for(int a:arr){
            result+=a;
        }
        return result;
    }
    
}
