import java.util.*;
public class entry_9645129 {

    static int MOD = 1000000007;

    public static long  inv(long l) {
        return l <= 1 ? l :  MOD - ((long)(MOD/l) * inv(MOD % l) % MOD);
      }
    public static long pow(int a, int b,int MOD){

        if(b == 0){
            return 1;
        }

        long ans = (pow(a,b/2,MOD));

        ans = (ans) * (ans) % MOD;

        if(b % 2 == 1){
            ans =  (ans * (a))  % MOD;
        }

        return ans;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = 0;

        long i;
        for( i = 1; i*i <= n; i++){
            long t1 = i * (n / i - i + 1); // adding i every time it appears with numbers greater than or equal to itself
            long t2 = (((((n/ i) % MOD) * (((n / i) + 1) % MOD)) % MOD) * inv(2))  % MOD ; // adding numbers that appear with i and are greater than i
            long t3 = ((i * (i + 1)) / 2) % MOD;
            long t4 = (t2 - t3 + MOD) % MOD;
            result = (result +  t1 + t4 ) % MOD ;
        }
        System.out.println(result % MOD);
        //736806794367
        //922119871


        }








}
