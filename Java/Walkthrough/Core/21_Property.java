import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
//implementation of property features which store the value in a file form of key vale pairs, generally used for creating project setting files
class Propert {
    public static void main(String[] args) {
        try{
            String file=System.getProperty("user.dir"); //getting the current user directory
            Properties p=new Properties();
            FileInputStream in=new FileInputStream(file); //getting the content of file from given location
            p.load(in); //loading contents of property type file in property obj
            String val=p.getProperty("a");
            p.setProperty("a", "v"); //setting a key value 
            in.close();
            FileOutputStream out=new FileOutputStream("file");
            p.store(out, "");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
