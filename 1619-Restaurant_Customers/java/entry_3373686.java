/*import java.io.*;
import java.util.*;
 public class entry_3373686 {
    static class Point implements Comparable<Point>{
        int t;
        boolean enter;
        Point(int a, boolean b) {
            t = a;
            enter = b;
        }
         @Override
        public int compareTo(Point o) {
            return t-o.t;
        }
    }
    static int N;
    static Point[] times;
    public static void main(String[] args) throws IOException {
        String name = "entry_3373686";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        times = new Point[2*N];
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            times[2*i] = new Point(a, true);
            times[2*i+1] = new Point(b, false);
        }
        Arrays.sort(times);
         int max = -1;
        int curr = 0;
        int num = 0;
        for (int i = 0; i<2*N; i++) {
            if (num==N) {
                break;
            }
            if (times[i].enter) {
                num++;
                curr++;
                max = Integer.max(max, curr);
            } else{
                curr--;
            }
        }
        System.out.println(max);
    }
}*/

import java.util.*;
import java.io.*;
public class entry_3373686 {
    static int n;
    static ArrayList<Customer> customers;
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        customers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Customer c1 = new Customer(Integer.parseInt(st.nextToken()), 1);
            Customer c2 = new Customer(Integer.parseInt(st.nextToken()), -1);
            customers.add(c1); customers.add(c2);
        }
        Collections.sort(customers);
        //for(Customer x : customers) System.out.println(x.type);

        int result = 0;
        int sum = 0;
        for(Customer x : customers) {
            sum += x.type;
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }

    static class Customer implements Comparable<Customer>{
        int time; int type;
        Customer(int time, int type){
            this.time = time;
            this.type = type;
        }

        public int compareTo(Customer o) {
            return this.time - o.time;
        }
    }

}