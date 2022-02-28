public class Pair<X, Y> { //Generic class
    X x;
    Y y;
    public Pair(X x, Y y){
        this.x=x;
        this.y=y;
    }
    public void getdesc(){
        System.out.println(x+" and "+y);
    }
}

//{"status": "OK", "status_code": 200, "data": {"applicantRegiatrationStatus": {"isTaggedToEvent": true, "isTaggedToJob": true, "isRegistrationDone": true, "isReRegistrationAllowed": false, "isReRegistrationDone": false, "isDisableRegistration": false, "isAllowedToTag": true, "reasonCodeForNotAllowedToTag": null}}, "statusCode": 200}