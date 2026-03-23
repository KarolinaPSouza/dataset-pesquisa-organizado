import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class entry_7446861 {
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st;
        public FastReader() 
        { 
        br = new BufferedReader(new InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static long answer(long x, long y){
        long mx = Math.max(x,y);

        if(mx%2 == 0){
            if(y==1){
                return mx*mx;
            }
            if(x < mx){
                return answer(mx, mx) - (mx-x);
            }
            else if (x == mx){
                return mx*mx - (y-1);
            }
        }
        else{
            if(x == 1){
                return mx*mx;
            }
            else if(y < mx){
                return answer(mx,mx) - (mx-y);
            }
            else if(y == mx){
                return mx*mx - (x-1);
            }
        }
        return 0;
    }

    public static void main(String args[]){
        FastReader s = new FastReader();
        long t = s.nextLong();
        long x =0;
        long y =0;



        while(t --> 0){
            x = s.nextLong();
            y = s.nextLong();
            System.out.println(answer(x, y));

        }


    }
}

// import java.io.BufferedReader; 
// import java.io.IOException; 
// import java.io.InputStreamReader; 
// import java.util.Scanner; 
// import java.util.StringTokenizer; 

// public class entry_7446861 {
//     static class FastReader { 
//         BufferedReader br; 
//         StringTokenizer st; 

//         public FastReader() 
//         { 
//             br = new BufferedReader( 
//                 new InputStreamReader(System.in)); 
//         } 

//         String next() 
//         { 
//             while (st == null || !st.hasMoreElements()) { 
//                 try { 
//                     st = new StringTokenizer(br.readLine()); 
//                 } 
//                 catch (IOException e) { 
//                     e.printStackTrace(); 
//                 } 
//             } 
//             return st.nextToken(); 
//         }
//         long nextLong() { return Long.parseLong(next()); }
//     }
//     public static void main(String[] args) {
//         FastReader fr = new FastReader();
//         long testN = fr.nextLong();
//         long r=0,c=0;
//         while(testN-- > 0){
//             r = fr.nextLong();
//             c = fr.nextLong();
//             if (c > r) {
//                 if (c % 2 == 0) {
//                     System.out.println(((c - 1) * (c - 1)) + 1 + (r - 1));
//                 } else
//                     System.out.println(((c) * (c)) - (r - 1));
//             } else {
//                 if(r % 2 == 0){
//                     System.out.println(((r) * (r)) - (c - 1));
//                 } else
//                     System.out.println(((r - 1) * (r - 1)) + 1 + (c - 1));
//             }
//         }
//     }
// }