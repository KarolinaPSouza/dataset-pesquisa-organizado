import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class entry_445157 {
    static class Scanner{
        Scanner(InputStream in){this.in = in;} InputStream in;
        int k , l; byte[] bb = new byte[1 << 15];

        byte getc(){
            if(k >= 1){
                k = 0;
                try{l = in.read(bb);}catch (IOException ex){l=0;}
                if(l <= 0){return -1;}
            }
            return bb[k++];
        }

        int nexInt(){
            byte c = 0; while(c<=32) c = getc();
            int a = 0;
            while (c > 32){a = a * 10 + c - '0'; c = getc();}
            return a;
        }
    }

    static Random rand = new Random();

    public static void main(String[] args) {
        try{
            main();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void main() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] applicants = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            applicants[i] = Integer.parseInt(st.nextToken());
        }

        int[] apartments = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            apartments[i] = Integer.parseInt(st.nextToken());
        }

        sortShuffle(applicants);
        sortShuffle(apartments);

        int ans = 0;
        for(int i = 0, j = 0; i < n && j < m;){
            if(Math.abs(applicants[i]-apartments[j]) <= k){
                ans++;
                i++;
                j++;
            }
            else if(applicants[i] < apartments[j]){
                i++;
            }
            else{
                j++;
            }
        }
        System.out.println(ans);
    }

    public static void sortShuffle(int[] a){
        int size = a.length;
        for(int i =0; i < size; i++){
            int j = rand.nextInt(i+1);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
}