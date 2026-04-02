import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class entry_11608823 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        long target = Long.parseLong(parts[1]);


        Pair [] arr = new Pair[n];

        parts = reader.readLine().split(" ");
        for(int i = 0;i<n;i++) {
            arr[i] = new Pair(Integer.parseInt(parts[i]), i+1);
        }

        Arrays.sort(arr, (Pair a, Pair b)-> a.a - b.a);

        for(int i = 0;i<n;i++ ) {
            for(int j = i+1;j<n;j++) {
                int k = j+1, l = n-1;



                while(k<l) {
                    long sum = arr[i].a+arr[j].a+arr[k].a+arr[l].a;
                    if(sum==target) {
                        System.out.println(arr[i].b +" "+arr[j].b +" "+arr[k].b+" "+arr[l].b);
                        return;
                    } else if(sum>target) {
                        l--;
                    } else {
                        k++;
                    }
                }



            }
        }

        System.out.println("IMPOSSIBLE");


    }

}

class Pair {
    int a, b;

    Pair(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
}