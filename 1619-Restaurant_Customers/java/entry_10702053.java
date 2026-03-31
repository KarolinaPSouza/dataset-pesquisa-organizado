import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
   public class entry_10702053 {

    public static void main(String args[]) throws Exception
    {

        // if (System.getProperty("ONLINE_JUDGE") == null) {
        // // Redirect standard input to input.txt
        // System.setIn(new FileInputStream("input.txt"));
        // // Redirect standard output to output.txt
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        // }

        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));

        long t =1; // Integer.parseInt(infile.readLine());
        while(t-- > 0 ){
            StringTokenizer st = new StringTokenizer(infile.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(infile.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i][0]=  a ;
                arr[i][1] = b;
            }

            Arrays.sort(arr , (a,b) ->{
                if(a[0] != b[0]){
                    return a[0] -b[0];
                }else{
                    return a[1] - b[1];
                }
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int ans =  0;
            for(int[] ar : arr){
                int a = ar[0];
                int b = ar[1];

                while(pq.size() > 0 && pq.peek() < a){
                    pq.poll();
                }

                pq.add(b);

                ans = Math.max(ans , pq.size());
            }
            System.out.println(ans);


        }
        }
    }

