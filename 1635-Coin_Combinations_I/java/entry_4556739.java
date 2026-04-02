/*
                                             بسم الله الرحمن الرحيم 
                                          /$$$$$  /$$$$$$  /$$    /$$  /$$$$$$                                                                  
   |__  $$ /$$__  $$ |$$    |$$ /$$__  $$                                                                 
          | $$| $$  \ $$|    $$|$$| $$  \ $$                                                                 
          | $$| $$$$$$$$|  $$ / $$/| $$$$$$$$                                                                 
/ $$  | $$| $$__  $$ \  $$ $$/ | $$__  $$                                                                 
| $$  | $$| $$  | $$  \  $$$/  | $$  | $$                                                                 
|  $$$$$$/| $$  | $$   \  $/   | $$  | $$                                                                 
 \______/ |__/  |__/    \_/    |__/  |__/    
 /$$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$  /$$      /$$ /$$      /$$ /$$$$$$$$ /$$$$$$$ 
| $$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$__  $$| $$$    /$$$| $$$    /$$$| $$_____/| $$__  $$
| $$  \ $$| $$  \ $$| $$  \ $$| $$  \__/| $$  \ $$| $$  \ $$| $$$$  /$$$$| $$$$  /$$$$| $$      | $$  \ $$
| $$$$$$$/| $$$$$$$/| $$  | $$| $$ /$$$$| $$$$$$$/| $$$$$$$$| $$ $$/$$ $$| $$ $$/$$ $$| $$$$$   | $$$$$$$/
| $$____/ | $$__  $$| $$  | $$| $$|_  $$| $$__  $$| $$__  $$| $$  $$$| $$| $$  $$$| $$| $$__/   | $$__  $$
| $$      | $$  \ $$| $$  | $$| $$  \ $$| $$  \ $$| $$  | $$| $$\  $ | $$| $$\  $ | $$| $$      | $$  \ $$
| $$      | $$  | $$|  $$$$$$/|  $$$$$$/| $$  | $$| $$  | $$| $$ \/  | $$| $$ \/  | $$| $$$$$$$$| $$  | $$
|__/      |__/  |__/ \______/  \______/ |__/  |__/|__/  |__/|__/     |__/|__/     |__/|________/|__/  |__/
                                                                                                                                                                                                                                                                                                                                                                                                                                 TREESET.HIGHER() METHOD GIVES THE LEAST STRICTLY GREATER VALUE THAN THE PARAMETER;
 IF NO SUCH ELEMENT EXISTS IT RETURN NULL
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_4556739 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        try {
            // Scanner sc=new Scanner(System.in);
            FastReader sc = new FastReader();
            int t = 1;//sc.nextInt();
            while (t-- > 0) {

                int n=sc.nextInt();
                int x=sc.nextInt();

                int[] arr=new int[n]; for(int i=0;i<n;i++){ arr[i]=sc.nextInt(); }
                int[] dp=new int[x+1];
                dp[0]=1;
                for(int i=1;i<=x;i++){
                    for(int j:arr){
                        if(j<=i){
                            dp[i]=((dp[i]+dp[i-j])%1000000007);
                            // dp[i]%=1000000007;
                        }
                    }
                }
                System.out.println(dp[x]);
                /*
                 * long[] arr=new long[n]; for(int i=0;i<n;i++){ arr[i]=sc.nextLong(); }
                 */

            }
        } catch (Exception e) {
            return;
        }

    }

    public static class pair {
        int ff;
        int ss;

        pair(int ff, int ss) {
            this.ff = ff;
            this.ss = ss;
        }
    }

    public static void rsa(int[] arr2){
        Arrays.sort(arr2);

        int size = arr2.length;
        for (int left = 0; left < size / 2; left++) {
            int right = size - left - 1;
            int temp = arr2[right];
            arr2[right] = arr2[left];
            arr2[left] = temp;
        }
    }
    public static boolean checkBothTheArraysSame(int[] a, int[] b, int i, int j) {
        int n = a.length;
        int[] a1 = a;
        int[] b1 = b;
        if (i >= 0 && j >= 0) {
            for (int k = i; k <= j; k++) {
                a1[k] += 1;
            }
        }

        Arrays.sort(a1);
        Arrays.sort(b1);
        for (int ii = 0; ii < n; ii++) {
            if (a1[ii] != b1[ii])
                return false;
        }
        return true;
    }

    static int BS(int[] arr, int l, int r, int element) {
        int low = l;
        int high = r;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] == element) {
            return low;
        } else if (arr[high] == element) {
            return high;
        }
        return -1;
    }

    static int lower_bound(int[] arr, int l, int r, int element) {
        int low = l;
        int high = r;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] >= element) {
            return low;
        } else if (arr[high] >= element) {
            return high;
        }
        return -1;
    }

    static int upper_bound(int[] arr, int l, int r, int element) {
        int low = l;
        int high = r;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] > element) {
            return low;
        } else if (arr[high] > element) {
            return high;
        }
        return -1;
    }

    public static long gcd_long(long a, long b) {
        // a/b,a-> dividant b-> divisor
        if (b == 0)
            return a;
        return gcd_long(b, a % b);
    }

    public static int gcd_int(int a, int b) {
        // a/b,a-> dividant b-> divisor
        if (b == 0)
            return a;
        return gcd_int(b, a % b);
    }

    public static int lcm(int a, int b) {
        int gcd = gcd_int(a, b);
        return (a * b) / gcd;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        double nextDouble() {
            return Double.valueOf(Integer.parseInt(next()));
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
    }

    /*
     * JAVA STRING CONTAINS METHOD--------->str1.contains(str2)-->if(str2 is present
     * in str1){ return true; } else return false;
     */

    public static boolean contains(String main, String Substring) {
        boolean flag = false;
        if (main == null && main.trim().equals("")) {
            return flag;
        }
        if (Substring == null) {
            return flag;
        }

        char fullstring[] = main.toCharArray();
        char sub[] = Substring.toCharArray();
        int counter = 0;
        if (sub.length == 0) {
            flag = true;
            return flag;
        }

        for (int i = 0; i < fullstring.length; i++) {

            if (fullstring[i] == sub[counter]) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == sub.length) {
                flag = true;
                return flag;
            }

        }
        return flag;

    }
    //FACTORISATION OF A NUMBER ---> OPTIMISED CODE 
    //TC -->O(sqrt(N));
    public static void factorize(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                int cnt=0;
                while(n%i==0){
                    n/=i;
                    cnt++;
                }
                System.out.println("DIVISOR is "+i+" "+"COUNT is "+cnt);
            }
        }
        if(n!=1){
            //n is prime number
            System.out.println("DIVISOR is "+n+" "+"COUNT is "+1);
        }
    }

    //DISJOINT SET UNINION  OPTIMALLY IMPLEMENTED USING PATH COMPRESSION AND RANK ARRAY------>>>>>>>>>>>>>>>>>>>>>
    //parent[i].ff==parent of i and parent[i].ss gives the rant of the set in which i belongs to
    public static int find_set(int a,pair[] parent){
        if(parent[a].ff==a)return a;
        return parent[a].ff=find_set(parent[a].ff,parent);
    }
    public static void union_set(int a,int b,pair[] parent){
        int a_root=find_set(a, parent);
        int b_root=find_set(b, parent);
        if(a_root==b_root)return;
        if(parent[a_root].ss<parent[b_root].ss){
            parent[a_root].ff=b_root;
        }
        else if(parent[a_root].ss>parent[b_root].ss){
            parent[b_root].ff=a_root;
        }
        else{
            parent[b_root].ff=a_root;
            parent[a_root].ss++;
        }
    }

}

/*
 * public static boolean lie(int n,int m,int k){ if(n==1 && m==1 && k==0){
 * return true; } if(n<1 || m<1 || k<0){ return false; } boolean
 * tc=lie(n-1,m,k-m); boolean lc=lie(n,m-1,k-n); if(tc || lc){ return true; }
 * return false; }
 */