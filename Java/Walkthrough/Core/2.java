import java.io.*;


import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'sortOrders' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY orderList as parameter.
     */

    public static List<String> sortOrders(List<String> orderList) {
    // Write your code here
    //Set<String> temp=new TreeSet<String>(orderList);
    List<String> temp1=new ArrayList<String>(orderList);
    List<String> temp2=new ArrayList<String>();
    Collections.sort(temp1);
    for(String t:temp1){
        int i=t.indexOf(" ");
        String temp=t.substring(i, t.length());
        temp=temp.replaceAll(" ", "");
        if(temp.matches("[a-zA-Z]+")){
            temp2.add(t.substring(i+1, t.length())+" "+t.substring(0, i));
            //System.out.println(temp.substring(0, i));
        }
    }
    Collections.sort(temp2);
    for(int i=0; i<temp2.size(); i++){        
            String t3=temp2.get(i);
            int index=t3.lastIndexOf(" ");
            temp2.set(i, t3.substring(index+1, t3.length())+" "+t3.substring(0, index));
    }
    for(int i=0; i<orderList.size(); i++){
        if(!temp2.contains(orderList.get(i))){
            temp2.add(orderList.get(i));
        }
    }
   
        return temp2;

    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int orderListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> orderList = IntStream.range(0, orderListCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

            System.out.println();
        List<String> result = Result.sortOrders(orderList);
        for(String tx:result){
            System.out.println(tx);
        }

    }
}