import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.BreakIterator;


/*JDBC(java database connectivity)-api in java to connect java program with database(java.sql package), other ways are vendor specific api, odbc(open database connectivity)
jdbc driver-implementation of jdbc api in java language
4 types of jdbc driver so that jdbc api could be used with non java progreams too
1-jdbc odbc bridge-type 1, too much performance overhead, query conversion from java to jdbc to odbc to database
2-native driver-type2, jdbc-database api-database, disadvantage that database neeed to be installed on every client
3-driver server-type3, same as above but instead of client the database api need to be installed on server
4-thin driver-type4 (commonly used), jdb-any type of database, no other requirements but internally uses native drivers so different driver for different database

jdbc apis of java.sql are as follows
driver-provides implementation of different database, driver of database jar implements driver of java.sql package
connection-establishes connection/session b/w program and database
drivermanager-managing establishing connections, ensures if db pacjage arevright
stataement
prepared statement
resultset
resultsetmetadata
callablestatement
sql exception

when class is dynamically loaded for registering, driver class of java.sql is called then from there it goes to drivermanager and gets stored in its class variable

when getconnection is called for establishing connection then getconnection method of java.sql is called which returns connection object(the linking between registration and connection details is linked by connect method)

Driver is an interface and implementation is provided by different db vendors, eseentially responsible for connecting java call to sql call

Class which iimplements driver interface is called driverclass

Drivermanager, manages all the type of drivers provided by db vendors, creates objects and returns to program 

Connection's object is also factory for preparedstatement and statement, basically used to create object for prepredstatement and statement

Statement is implement by diff vendors and object of implementing class is responsible for creating a session b/w db and program to execute sql statements queries

factory method are  the ones which return something 

making the constructor of class private ensures that not more than one object is created(singleton class) and declaring the class final ensures that it can't be inherited

metadata-data about data,eg-dictionary

getmetadat method is used to return the type of fields or count of fields etc. this can be run with the objects of connection or resultset

Callablestatement of Statement of interface is used for calling  stored procedures and functions

*/
class A{
    static int a=5;
    static{
        System.out.println("b");
    }
}
class firstconn{

    static{ //static loading example, runs before method method
        System.out.println("runs before main");
    }
    public static void main(String[] args) throws Exception {
        Connection conn=null;
        try{
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); //way to regisatering database driver, static loading, setting classpath to driver is also static loading
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //this is mostly used, imploys class loading(THIS METHOD IS dynamic loading way), class loading means storing specific information of class in memory, static class loading compiler knows the information while in dynamic class loading it doesn't
            //above code provides a facility to the user to enter drivername and registers to the drivermanager using static block of driver class
            //System.out.println(args[0]);//this can print b of class a if arguement 'A' is passed to main method at runtime, similarly for other sets of classes too, this is known as dynamic loading
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=java;user=root;password=root"; //url, user, pass for mssql type db

             conn = DriverManager.getConnection(dbURL); //establishing a connection b/w java and database, here an instance is returned by driver class of database jdbc and storred as interface refrence, basically object of class implementing the connection interface (implementation provided by db vendors)
            //above syntax means getconnectionmethod of drivermanager class
            if (conn != null) {
                System.out.println("Connected");
            }
            
            Statement s=conn.createStatement(); //handles performing of sql operations and their conversion to db specific, this object is returned by the implementing class of the jdbc driver
            
            
            
            long i=s.executeUpdate("insert into a");//this method is not preferred since end user can give subqueries insted of record data and cause sql injection, overhead in performance since query is translated everytime one by one, readability issues due to concatenation of queries

            PreparedStatement prep=conn.prepareStatement("insert into java values(?,?,?)"); //? (positional parameter) is way to insert multiple values for a given field, in preparedstatement queries are precompiled, basically compile once use many times
            prep.setInt(1, 2);//sets value of first question mark to 2
            i=prep.executeUpdate(); //executes the above query and returns a value more than 0 if succesful, no sql injection due to no concatenation of inputs
            
            String s2="query1";
            String s1="query2";
            String s3="query3";
            s.addBatch(s1); //way to execute queries in batches
            s.addBatch(s2);
            s.addBatch(s3);
            int n[]=s.executeBatch(); //since mutliple queries are executed in batch so every batch would return some value which can be used to check if quey was succesful or not

            String file=System.getProperty("user.dir");
            file+="\\src\\a.jpg"; //this is done to ensure that program runs fine anywhere irrespective of directory changes
            FileInputStream obj=new FileInputStream(file);
            prep.setBinaryStream(1,obj,obj.available()); //way to insert binary content in db, sql stores binary in form of blobs(binary large object)


            

            ResultSet rs=s.executeQuery("select * from java"); //in resultset db buffer is created in memory in which db data is stored and data can be shown by traversing one by one

            Blob b=rs.getBlob(1); //returns blob from db at column1, use Clob for big character files stored in data

            byte ab[]=new byte[(int)b.length()];
            ab=b.getBytes(1, (int)b.length()); //stors blob in bytes
            FileOutputStream ba=new FileOutputStream("a.jpg"); //way to get blob and store it
            ba.write(ab);



            System.out.println(rs);
            while(rs.next()){
                System.out.println(rs.getString(1)); //way to access of records from column 1 and column name could also be given
            }
            Clob aa=rs.getClob(1);  //way to get character file data from db
            Reader re=aa.getCharacterStream();
            FileWriter bx=new FileWriter("a.java");
            
            while(true){ //writing contents from char stream created above
                int ii=re.read();
                if(i==-1){
                    break;
                }
                bx.write((char)i);

            }

            CallableStatement cs=conn.prepareCall("{call a(?)}"); //way to run call a stored procedure
            cs.setString(1, "b");
            cs.executeUpdate();
            cs=conn.prepareCall("{?=call sum(?,?)}");//way to call a function
            cs.registerOutParameter(1, Types.INTEGER); //this states that return type of above called function is int as given first question mark
            cs.execute();
            int bb=cs.getInt(1); //gets the result of above called function

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            conn.close();
        }
    }
}


/* below is a code for trasaction query, implement in try catch
register driver
create connectio
estsablish
obj.setautocommit(false);
perform operations
at last end the block with obj.commit();
if exceptions occurs then end the catch block with obj.rollback()
*/

/*resulset got two properties one for navigation which has its method for different traversal in db and then sensitivity which can be tweaked to ensure that if somebody changes data in the db, after resultset initially stores data, they get reflected in resultset too
and an add on is concurrency which allows conurrent acces of db for multiple queries at once

Statement s=conn.createStatement(Resultset.type_scroll_sensitive, Resultset.concur_updatable) //waqys to set those properties
*/