// Working program with FastReader

import java.io.*;
import java.util.*;

//
public class entry_3576038 {
    static BufferedWriter bw;
    static {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
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
    public static void print(String a) throws IOException {
        bw.write(a);
    }


    public static void printSp(String a) throws IOException {
        bw.write(a + " ");
    }

    public static void println(String a) throws IOException {
        bw.write(a + "\n");
    }

    static int min = Integer.MAX_VALUE;
    static boolean tt = true;
static  long mod= (long) (1e9+7);
static long minDIff=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
       // BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
        int t=1;
        while (t>0) {
            t--;
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(sc.nextInt());
            }
           // int m=sc.nextInt();
            List<Integer> list1=new ArrayList<>();
            for(int i=0;i<m;i++){
                list1.add(sc.nextInt());
            }
            Collections.sort(list1);
            Collections.sort(list);
            int i=0;
            int j=0;
            int ans=0;
            while (i<n && j<m){
                if(list.get(i)-k>list1.get(j)){
                    j++;
                }else if(list.get(i)+k<list1.get(j)){
                    i++;
                }else{
                    ans++;
                    i++;
                    j++;

                }
            }
            System.out.println(ans);
        }

    }

    private static void premutate(char[] cc, int i, int i1,Set<String> set,List<String> list) {
        if(i==i1){
            if(set.add(String.valueOf(cc))){
                list.add(String.valueOf(cc));
            }

        }else{
            for(int i2=i;i2<=i1;i2++){
                swap(cc,i,i2);
                premutate(cc,i+1,i1,set,list);
                swap(cc,i,i2);
            }
        }
    }
    public  static void isolve(long curr,long sum,int[]ar,int i){
        if(i==ar.length){
            minDIff=Math.min(minDIff,Math.abs(2*curr-sum));
            return;
        }
        minDIff=Math.min(minDIff,Math.abs(2*curr-sum));
        isolve(curr,sum,ar,i+1);
        isolve(curr+ar[i],sum,ar,i+1);

    }

    private static void solve(int s, int d, int h, int n) {
if(n==1){
    System.out.println(s+" "+d);
}else{

    solve(s,h,d,n-1);
    System.out.println(s+" "+d);
    solve(h,d,s,n-1);

}
    }

    private static long power(long b, long c,long mod) {

        long ans=1;
        while (c>0){
            if(c%2==0){
                c=c/2;
                b=((b*b)%mod);
            }else{
                c--;
                ans=((ans*b)%mod);
            }
        }
        return  ans;
    }

    private static void swap(char[] ar, int i, int i1) {
        char temp = ar[i];
        ar[i] = ar[i1];
        ar[i1] = temp;
    }


    private static void reverse(int[] ar, int i, int j) {
        while (i < j) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;
            j--;
        }
    }


    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public    static Stack<Integer> reverseTheGroups(Stack<Integer> s, int n, int k) {
        // Write your code here.
        Deque<Integer> qu= new LinkedList<>();
        while(s.size()>=k){
            Stack<Integer> temp= new Stack<>();
            int tempnum=k;
            while(tempnum!=0){
                tempnum--;
                temp.push(s.pop());

            }
            while(temp.size()>0){
                qu.addLast(temp.pop());
            }

        }
        while(s.size()>0){
            qu.add(s.pop());
        }
        Stack<Integer> st= new Stack<>();
        while(qu.size()>0){
            st.push(qu.pollLast());
        }
        return st;

    }

}