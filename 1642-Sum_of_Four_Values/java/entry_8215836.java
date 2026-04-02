import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class entry_8215836 {
    static class pair{
        int a, b;
        public pair(int a1, int b1){
            a = a1;
            b = b1;
        }
        public String toString(){
            return a+" "+b;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), x = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0; i<n; i++){
            a[i] = scan.nextInt();
        }
        boolean done = false;
        HashMap<Integer, pair> lsums = new HashMap<>();
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i-1; j++){
                lsums.put(a[j]+a[i-1], new pair(i, j+1));
            }
            for(int j = i+1; j<n; j++){
                if(lsums.containsKey(x-a[j]-a[i])){
                    System.out.println(lsums.get(x-a[i]-a[j]).a + " " + lsums.get(x-a[i]-a[j]).b + " " + (i+1) + " " + (j+1));
                    done = true;
                    break;
                }
            }
            if(done) break;
        }
        if(!done) System.out.println("IMPOSSIBLE");
    }
}