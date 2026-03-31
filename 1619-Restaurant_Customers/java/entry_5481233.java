import java.util.*;
import java.io.*;
import java.math.*;
public class entry_5481233 {
    static FastReader in=new FastReader();
    static final Random random=new Random();
    static long mod=1000000007l;
    public static void main(String args[]) throws IOException {
        FastReader sc=new FastReader();
        //int tt=sc.nextInt();
        int tt=1;
        while(tt-->0){
            int n=sc.nextInt();
            //int sum=sc.nextInt();
            ArrayList<Pair> p = new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                p.add(new Pair(a,1));
                p.add(new Pair(b,-1));
            }
            Collections.sort(p,new Sorting());

            int cur=0;
            int max=0;
            for(int i=0;i<2*n;i++){
                cur+=p.get(i).v;
                max=Math.max(max,cur);
            }
            System.out.println(max);


}

}

    static boolean possible(int mid,int []arr){
        int n=arr.length;
        int brr[]=new int[n];
        ArrayList<Integer> rem=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]<=mid || arr[i]>=(n-mid+1)){

            }
            else{
                rem.add(arr[i]);
            }

        }
        //System.out.println();
        for(int i=0;i<mid;i++){
            brr[i]=i+1;
        }
        for(int i=n-1;i>=n-mid;i--){
            brr[i]=i+1;
        }
        int val=0;

        for(int i=0;i<n;i++){
            if(brr[i]==0){
//                System.out.println(i);
                brr[i]=rem.get(val);
                val++;
            }
        }
        for(int i=0;i<n;i++){
            if(brr[i]!=i+1){
                return false;
            }
        }
        return true;



    }
    static int lowerbound(int arr[],int ele){
        int l=0;
        int h=arr.length-1;
        while(h-l>1){
            int mid=(l+h)/2;
            if(arr[mid]<ele){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        if(arr[l]>=ele){
            //System.out.print("TT");
            return l;
        }
        if(arr[h]>=ele){
            return h;
        }
        return -1;
    }
    static int upperbound(int arr[],int ele){
        int l=0;
        int h=arr.length-1;
        while(h-l>1){
            int mid=(l+h)/2;
            if(arr[mid]>ele){
                h=mid-1;
            }
            else{
                l=mid;
            }
        }
        if(arr[h]<=ele){
            return h;
        }
        if(arr[l]<=ele){    
            return l;
        }
        return -1;
    }
    static boolean coprime(int i,int j){
        if(gcd(i,j)==1){
            return true;
        }
        return false;
    }

    static long comb(int n,int k){        
        return factorial(n) * pow(factorial(k), mod-2) % mod * pow(factorial(n-k), mod-2) % mod;
    }
    static long pow(long a, long b) {
        long res = 1; 
        while (b != 0) {
            if ((b & 1) != 0) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        return res;
    }

    static boolean isPowOfTwo(long n){

        if((n&(n-1))==0){
            return true;
        }
        return false;
    }





    static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static long  factorial(int n){
        long ret = 1;
        while(n > 0){
            ret = ret * n % mod;
            n--;
        }
        return ret;
    }


    static String reverse_String(String s){
        String ans="";
        for(int i=s.length()-1;i>=0;i--){
            ans+=s.charAt(i);
        }
        return ans;
    }

    static void reverse_array(int arr[]){
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }




    static int msb(int x){
        int ans=0;
        while(x!=0){
            x=x/2;
            ans++;
        }
        return ans;
    }
    static void ruffleSort(int[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            int temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static  long gcd(long a,long b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }


static class Pair{
        int u,v;
        public Pair(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    static class Sorting implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p2.u==p1.u){
                return p1.v-p2.v;
            }
            return p1.u - p2.u;
        }
    }


    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }




    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }



    }

}