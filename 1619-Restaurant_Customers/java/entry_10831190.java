import java.io.*;
import java.util.*;

class Event{
    int type,val;
    Event(int val,int type){
        this.val = val;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", val=" + val +
                '}';
    }
}



public class entry_10831190 {
    public static void main(String[] args) {
        entry_10831190 main = new entry_10831190();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        scanner = new MyScanner();
        main.testcase();
        out.close();
    }
    public static PrintWriter out;
    public static MyScanner scanner;
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) {
                        throw new NoSuchElementException("End of input reached.");
                    }
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    void input(){

        int n  = scanner.nextInt();
        List<Event> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            l.add(new Event(a,1));
            l.add(new Event(b,2));
        }
        Collections.sort(l,(x,y)->{
            return x.val!=y.val ? x.val-y.val : x.type-y.type;
        });
        int count=0,mx=0;
        for(int i=0;i<l.size();i++){
            Event e = l.get(i);
            if(e.type==1){
                count++;
                mx= Math.max(mx,count);
            }
            else{
                count--;
            }
        }
        out.println(mx);

    }


    void testcase() {

        int t = 1;
        while (t-- > 0) {
           input();
        }
    }
}