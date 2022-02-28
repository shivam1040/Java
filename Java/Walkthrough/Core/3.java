import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'applicationPairs' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY. The function accepts
     * following parameters: 1. INTEGER deviceCapacity 2. 2D_INTEGER_ARRAY
     * foregroundAppList 3. 2D_INTEGER_ARRAY backgroundAppList
     */

    public static List<List<Integer>> applicationPairs(int deviceCapacity, List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList) {
        // Write your code here
        List<Integer> temp2 = new ArrayList<Integer>();
        List<Integer> temp3 = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int m = 7; m > 0; m--) {
            for (int i = 0; i < foregroundAppList.size(); i++) {
                
                    int temp = deviceCapacity - foregroundAppList.get(i).get(1);
                    // System.out.println(temp);
                    for (int k = 0; k < backgroundAppList.size(); k++) {
                    
                            if (backgroundAppList.get(k).get(1) == temp) {
                                // System.out.println(temp);
                                temp2.add(foregroundAppList.get(i).get(0));
                                temp2.add(backgroundAppList.get(k).get(0));
                                temp3.addAll(temp2);
                                temp2.clear();
                                // deviceCapacity--;
                                // continue;
                            }
                        

                    }

                
            }
            if (!temp3.isEmpty()) {
                int s = 0;
                int e = 2;
                for (int n = 0; n < temp3.size() / 2; n++) {
                    if(!result.contains(temp3.subList(s, e))){
                    result.add(temp3.subList(s, e));
                    s += 2;
                    e += 2;
                }
            }
                break;
            } else {
                deviceCapacity--;
            }
        } // result.add(temp3);
        return result;
    }

}

class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int deviceCapacity = Integer.parseInt(bufferedReader.readLine().trim());

        int foregroundAppListRows = Integer.parseInt(bufferedReader.readLine().trim());
        int foregroundAppListColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> foregroundAppList = new ArrayList<>();

        IntStream.range(0, foregroundAppListRows).forEach(i -> {
            try {
                foregroundAppList.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("\t"))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int backgroundAppListRows = Integer.parseInt(bufferedReader.readLine().trim());
        int backgroundAppListColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> backgroundAppList = new ArrayList<>();

        IntStream.range(0, backgroundAppListRows).forEach(i -> {
            try {
                backgroundAppList.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result1.applicationPairs(deviceCapacity, foregroundAppList, backgroundAppList);

        System.out.println();
        if (!result.isEmpty()) {
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < result.get(i).size(); j++) {
                    System.out.print(result.get(i).get(j) + " ");

                }
                System.out.println();
            }
        } else {
            System.out.println("[()]");
        }

        bufferedReader.close();

    }
}