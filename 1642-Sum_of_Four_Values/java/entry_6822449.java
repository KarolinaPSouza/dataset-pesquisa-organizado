import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class entry_6822449 {
    static class Pair{
        int val;
        int idx;
        Pair(){}
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
   }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tSum = sc.nextInt();

         Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(sc.nextInt(), i + 1);
        }

        Arrays.sort(arr, new Comparator<Pair>() {

            public int compare(Pair p1, Pair p2){
                return p1.val - p2.val;
            }
        });

        for(int i = 0; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++){
                int k = j + 1;
                int l = n - 1;
                long ctSum = (long)(tSum - arr[i].val - arr[j].val);
                while(k < l){
                    long sum = arr[k].val + arr[l].val;
                    if(sum < ctSum){
                        k++;
                    }else if(sum > ctSum){
                        l--;
                    }else{
                        System.out.println(arr[i].idx + " " + arr[j].idx + " " + arr[k].idx + " " + arr[l].idx);
                        return;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}