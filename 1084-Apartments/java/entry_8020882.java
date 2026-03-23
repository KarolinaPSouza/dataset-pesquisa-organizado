import java.util.*;
import java.io.*;

public class entry_8020882 {

    public static void main(String[] args) throws IOException {

     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer>a = new ArrayList<Integer>();
        ArrayList<Integer>s = new ArrayList<Integer>();

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) s.add(Integer.parseInt(st.nextToken()));


        Collections.sort(a);
        Collections.sort(s);


        int ans=0;
        int idx=0;
        for(int i=0; i<n; i++) {
            if(idx>=m) break;
            if(Math.abs(a.get(i)-s.get(idx))<=k) {
                ans++;
                idx++;
                continue;
            }
            if(s.get(idx)<(a.get(i))) {
                if(idx==m-1) {
                    //System.out.println(ans);
                    break;
                }
                idx++;
                i--;
            }
        }
        System.out.println(ans);
    }
}