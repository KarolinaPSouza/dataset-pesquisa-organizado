import java.util.*;
import java.io.*;
public class entry_5520933 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(scan.readLine());

        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> h = new ArrayList<>();
        List<Integer> ap = new ArrayList<>();

        st = new StringTokenizer(scan.readLine());
        for (int i = 0; i < n; i++)
            ap.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(scan.readLine());
        for (int i = 0; i < m; i++)
            h.add(Integer.parseInt(st.nextToken()));
        Collections.sort(ap); Collections.sort(h);
        int idx1 = 0; int idx2 = 0;
        while(idx1 != n && idx2 != m)
        {
            if(ap.get(idx1) - k <= h.get(idx2) && ap.get(idx1) + k >= h.get(idx2))
            {
                idx1++; idx2++; count++;
            }
            else if(ap.get(idx1) - k > h.get(idx2)) idx2++;
            else idx1++;
        }

        pw.print(count);
        pw.close();
    }
}