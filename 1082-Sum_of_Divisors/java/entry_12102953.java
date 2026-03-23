    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Map;
    import java.util.Scanner;
    import java.util.StringTokenizer;

    public class entry_12102953 {
        static long MOD=1000000007;
        static long TWO_MOD_INV=500000004;
        public static void main(String[] args) throws IOException {

            Scanner  sc=new Scanner(System.in);
            long n=sc.nextLong();
           long ans=0;

           for(long i=1;i<=n;){
               long q=n/i;
               long lastSame=n/q;
               ans=(ans+(sum(i,lastSame)*q))%MOD;
               i=lastSame+1;

           }
            System.out.println(ans);

        }
        private static  long sum(long start,long end){
            return ((((end-start+1)%MOD)*((start+end)%MOD)%MOD)*TWO_MOD_INV%MOD);

}

    }