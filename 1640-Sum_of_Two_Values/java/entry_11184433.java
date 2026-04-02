import java.util.*;
import java.io.*;

public class entry_11184433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int target = Integer.parseInt(line[1]);
        thing: {
            line = br.readLine().split(" ");
            Map<Integer, Integer> nums = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(line[i]);
                int need = target - num;
                if (nums.containsKey(need)) {
                    System.out.println((nums.get(need)+1)+" "+(i+1));
                    break thing;
                }
                nums.put(num, i);
            }
            System.out.println("IMPOSSIBLE");
        }

//        String[] line = br.readLine().split(" ");
//        int N = Integer.parseInt(line[0]);
//        int target = Integer.parseInt(line[1]);
//
//        line = br.readLine().split(" ");
//        int[] values = new int[N];
//        for (int i = 0; i < N; i++) {
//            values[i] = Integer.parseInt(line[i]);
//        }
//        Map<Integer, Integer> valuetoindex = new HashMap<>();
//        found: {
//            for (int i = 0; i < N; i++) {
//                if (valuetoindex.containsKey(target - values[i])) {
//                    System.out.println((i+1) + " " + valuetoindex.get(target-values[i]));
//                    break found;
//                }
//                valuetoindex.put(values[i], i +1);
//            }
//            System.out.println("IMPOSSIBLE");
//        }

//        line = br.readLine().split(" ");
////
////        Map<Integer, Integer> req = new HashMap<>();
////
////        List<Integer> nums = new ArrayList<>();
////
////        for (int i = 0; i < N; i++) {
////            int num = Integer.parseInt(line[i]);
////            req.put(num, X-num);
////            nums.add(num);
////        }
////        found: {
////            for (Map.Entry<Integer, Integer> entry : req.entrySet()) {
////                int num = entry.getKey();
////                int need = entry.getValue();
////                if (nums.contains(need) && nums.indexOf(num) != nums.indexOf(need)) {
////                    System.out.println((nums.indexOf(num)+1) + " " + (nums.indexOf(need)+1));
////                    break found;
////                }
////            }
////            System.out.println("IMPOSSIBLE");
//        }
    }

}